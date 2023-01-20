package com.employee.login;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.employee.auth.dto.PasswordGrantAccessToken;
import com.employee.core.auth.dto.GenericAccessToken;
import com.employee.core.auth.dto.GenericAccessToken.EncodingAlgorithm;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.security.AbstractLoginService;
import com.employee.security.signature.ISignatureService;
import com.employee.service.IEmployeeService;
import com.google.gson.Gson;
@Service("PWD")
public class PwdLoginService extends AbstractLoginService {
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private ISignatureService signatureService;
	
	@Value("${accessTokenAlias}")
	private String accessTokenAlias;

	
	private long defaultTtl = 2 * 60 * 60;
@Override
public EmployeeResponseDto doLogin(EmployeeRequestDto employeeRequestDto) {
EmployeeResponseDto employeeResponseDto=employeeService.verifyUser(employeeRequestDto);
PasswordGrantAccessToken accessToken = new PasswordGrantAccessToken(defaultTtl, EncodingAlgorithm.RSA);
accessToken.setUserId(employeeResponseDto.getId().toString());
String signedString = null;
try {
	signedString = signatureService.sign(this.accessTokenAlias, EncodingAlgorithm.RSA.getAlgo(), new Gson().toJson(accessToken));
} catch (InvalidKeyException e) {
	e.printStackTrace();
} catch (NoSuchAlgorithmException e) {
	e.printStackTrace();
} catch (SignatureException e) {
	e.printStackTrace();

}
employeeResponseDto.setAccessToken(signedString);	
return employeeResponseDto;
}
@Override
public long getTtl(EmployeeRequestDto employeeRequestDto) {
	return this.defaultTtl;
}
@Override
public GenericAccessToken doVerifyToken(String accessToken, String decodeToken) {
	boolean verified = false;
	try {
		verified = signatureService.verify(this.accessTokenAlias, EncodingAlgorithm.RSA.getAlgo(), accessToken);
		
	} catch (InvalidKeyException e) {
		
	} catch (NoSuchAlgorithmException e) {
		
	} catch (SignatureException e) {
		
	}
	if (!verified) {
	//	throw new InvalidCredentialsException("Accesstoken is not valid", ErrorCodes.TOKEN_NOT_VALID);
	
	}
	return new Gson().fromJson(decodeToken, PasswordGrantAccessToken.class);
}
}
