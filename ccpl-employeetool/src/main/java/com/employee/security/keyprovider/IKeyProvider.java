package com.employee.security.keyprovider;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;

public interface IKeyProvider {
	public PrivateKey getPrivateKey(String aliasName)
			throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, InvalidKeySpecException,RuntimeException;

	public PublicKey getPublicKey(String aliasName) throws KeyStoreException;

}
