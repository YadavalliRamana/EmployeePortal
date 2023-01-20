package com.employee.core.auth.dto;

public class GenericAccessToken {
	// Issued At Claim
	private long iat = System.currentTimeMillis();

	// Time To Live
	private long ttl;

	private String version = "v1";

	private GrantType grantType;

	private EncodingAlgorithm algorithm;
	
	public GenericAccessToken(long ttl, GrantType grantType, EncodingAlgorithm encodingAlgorithm) {
		this.ttl = ttl;
		this.grantType = grantType;
		this.algorithm = encodingAlgorithm;
	}

	public static enum EncodingAlgorithm {

		DSA("SHA256withRSA"), RSA("SHA256withRSA"), SHA256("SHA256withRSA");

		private String algo;

		private EncodingAlgorithm(String algo) {
			this.algo = algo;
		}

		public String getAlgo() {
			return algo;
		}

		public void setAlgo(String algo) {
			this.algo = algo;
		}
	}

	public static enum GrantType {
		PWD
	}

	public long getIat() {
		return iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public long getTtl() {
		return ttl;
	}

	public void setTtl(long ttl) {
		this.ttl = ttl;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public GrantType getGrantType() {
		return grantType;
	}

	public void setGrantType(GrantType grantType) {
		this.grantType = grantType;
	}

	public EncodingAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(EncodingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
}
