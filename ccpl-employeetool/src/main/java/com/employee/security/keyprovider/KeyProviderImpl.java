package com.employee.security.keyprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class KeyProviderImpl implements IKeyProvider {
	private KeyStore keyStore;
	@Value("${keyFilePath}")
	private String keyFilePath;
	
	@Value("${keyFilePassword}")
	private String keyFilePassword;
	
	public KeyProviderImpl() throws KeyStoreException {
		this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
	}
	
	@PostConstruct
	public void loadKeyFile() throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		this.keyStore.load(new FileInputStream(new File(this.keyFilePath)), this.keyFilePassword.toCharArray());
	}
	@Override
	public PrivateKey getPrivateKey(String aliasName)
			throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, InvalidKeySpecException {
		Key key = keyStore.getKey(aliasName, this.keyFilePassword.toCharArray());
		byte[] encoded = key.getEncoded();
		PKCS8EncodedKeySpec privspec = new PKCS8EncodedKeySpec(encoded);
		PrivateKey privateKey = KeyFactory.getInstance(key.getAlgorithm()).generatePrivate(privspec);
		return privateKey;
	}

	@Override	
	public PublicKey getPublicKey(String aliasName) throws KeyStoreException {
		PublicKey publickey = keyStore.getCertificate(aliasName).getPublicKey();
		return publickey;
		}

}
