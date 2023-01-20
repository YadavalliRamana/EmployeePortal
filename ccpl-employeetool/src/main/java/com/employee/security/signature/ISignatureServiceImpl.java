package com.employee.security.signature;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.security.keyprovider.IKeyProvider;
@Service
public class ISignatureServiceImpl implements ISignatureService  {
	
	private static final int NO_OF_UPDTES = 100;

	protected final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	@Autowired
	private IKeyProvider keyProvider;

	
	@Override
	public String hashPassword(String password, String salt) throws RuntimeException {
		String toBeHashed = password + salt;
		try {
			byte[] stringToHash = toBeHashed.getBytes();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes());
			for (int i = 0; i < NO_OF_UPDTES; i++) {
				md.reset();
				stringToHash = md.digest(stringToHash);
			}

			return bytesToHex(stringToHash);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}

		return new String(hexChars);
	}

	@Override
	public String sign(String alias, String algorithm, String data)
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		PrivateKey privateKey = null;
		try {
			privateKey = keyProvider.getPrivateKey(alias);
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		byte[] dataBytes = null;
		try {
			dataBytes = data.getBytes("UTF8");
		} catch (UnsupportedEncodingException e) {
		}
        String encodedString = Base64.getEncoder().encodeToString(dataBytes);
        Signature sig = Signature.getInstance(algorithm);
        sig.initSign(privateKey);
        sig.update(dataBytes);
        byte[] signatureBytes = sig.sign();
        String signedString = Base64.getEncoder().encodeToString(signatureBytes);
        return encodedString + SEPARATOR + signedString;
	}

	@Override
	public boolean verify(String alias, String algorithm, String signedData)
			throws InvalidKeyException, NoSuchAlgorithmException, SignatureException {
		String[] split = signedData.split("\\" + SEPARATOR);
		PublicKey publicKey = null;
		try {
			publicKey = keyProvider.getPublicKey(alias);
		} catch (KeyStoreException e) {
		}
        Signature sig = Signature.getInstance(algorithm);
        sig.initVerify(publicKey);
        sig.update(Base64.getDecoder().decode(split[0].getBytes()));
        boolean verified = sig.verify(Base64.getDecoder().decode(split[1].getBytes()));
		return verified;
	}

}
