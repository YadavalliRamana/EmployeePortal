package com.employee.security;

import com.employee.core.auth.dto.GenericAccessToken;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;

public interface ILoginService {
	
	public EmployeeResponseDto login(EmployeeRequestDto employeeRequestDto);
	public GenericAccessToken verifyToken(String accessToken, String decodeToken);
	public void logout(String accessToken);
	public GenericAccessToken doVerifyToken(String accessToken, String decodeToken);

}
