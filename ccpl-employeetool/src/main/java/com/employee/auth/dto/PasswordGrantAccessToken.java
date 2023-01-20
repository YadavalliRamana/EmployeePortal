package com.employee.auth.dto;

import com.employee.core.auth.dto.GenericAccessToken;

public class PasswordGrantAccessToken extends GenericAccessToken {
	
	public PasswordGrantAccessToken(long ttl, EncodingAlgorithm encodingAlgorithm) {
		super(ttl, GrantType.PWD, encodingAlgorithm);
	}
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
