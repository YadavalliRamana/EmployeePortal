package com.employee.security;

import org.apache.commons.lang3.StringUtils;

import com.employee.core.auth.dto.GenericAccessToken;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;

public abstract class AbstractLoginService implements ILoginService {

	    //@Autowired
		//private RedisTemplate<String, String> redisStringValueTemplate;
		
	@Override
	public EmployeeResponseDto login(EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto employeeResponseDto=doLogin(employeeRequestDto);
		//this.redisStringValueTemplate.opsForValue().set(legatoEmployeeResponseDto.getAccessToken(), legatoEmployeeResponseDto.getId().toString(), getTtl(legatoEmployeeDto));
		return employeeResponseDto;
	}

	public abstract EmployeeResponseDto doLogin(EmployeeRequestDto employeeRequestDto);
	
	public abstract long getTtl(EmployeeRequestDto employeeRequestDto);
	
	
	@Override
	public GenericAccessToken verifyToken(String accessToken, String decodeToken) {
		//String token = this.redisStringValueTemplate.opsForValue().get(accessToken);
		//if (StringUtils.isEmpty(token)) {
			//throw new InvalidAccessTokenException("Invalid Token please login", ErrorCodes.TOKEN_NOT_VALID);
		//}
		return doVerifyToken(accessToken, decodeToken);
		}

	@Override
	public void logout(String accessToken) {
		if (StringUtils.isEmpty(accessToken)) {
			//throw new AccessTokenMissingException("accessToken not passing", ErrorCodes.TOKEN_NOT_VALID);	//Create new Exception and throw
		}
		//redisStringValueTemplate.delete(accessToken);
		
	}
	public abstract GenericAccessToken doVerifyToken(String accessToken, String decodeToken);
}
