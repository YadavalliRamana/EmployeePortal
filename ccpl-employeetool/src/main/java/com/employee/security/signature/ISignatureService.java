package com.employee.security.signature;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public interface ISignatureService {
	public static final String SEPARATOR = ".";

	public String sign(String alias, String algorithm, String data)
<<<<<<< HEAD
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,NullPointerException;
=======
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException,RuntimeException;
>>>>>>> 8e3b88cbc4d99070a935321ec85b07e89667575e

	public boolean verify(String alias, String algorithm, String signedData)
			throws InvalidKeyException, NoSuchAlgorithmException, SignatureException;

	public String hashPassword(String password, String salt) throws RuntimeException;
}
