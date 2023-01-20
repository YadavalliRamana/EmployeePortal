package com.employee.security.signature;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public interface ISignatureService {
	public static final String SEPARATOR = ".";

	public String sign(String alias, String algorithm, String data)
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;

	public boolean verify(String alias, String algorithm, String signedData)
			throws InvalidKeyException, NoSuchAlgorithmException, SignatureException;

	public String hashPassword(String password, String salt) throws RuntimeException;
}
