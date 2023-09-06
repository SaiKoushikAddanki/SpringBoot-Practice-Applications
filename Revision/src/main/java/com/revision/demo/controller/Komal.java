package com.revision.demo.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Komal {

	private static final Charset CHARSET_ENCODING = Charset.forName("UTF-8");
	private static final String MAC_ALGORITHM = "HmacSHA1";

	public static String generateDigestFromPrivateKey(String privateKey, String timestamp, String requestedFunction)
			throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		byte[] bytes = null;
		Mac mac = Mac.getInstance(MAC_ALGORITHM);
		mac.init(new SecretKeySpec(privateKey.getBytes(CHARSET_ENCODING.displayName()), MAC_ALGORITHM));
		String message = timestamp + " " + requestedFunction;
		bytes = mac.doFinal(message.getBytes());
		bytes = Base64.getEncoder().encode(bytes);
		return new String(bytes);
	}

	public static void main(String[] args)
			throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = generateDigestFromPrivateKey(
				"VNWYXARR28T7DVXSGZCSMB1AJSURJH1V8V4SYNKSC7NTRDSMBLTJPTXFVRQGRTMA3X0BIHLT6ZMEOUXVINB8AZB3NU9PG73G4NSAUEFIKFXENUAPF1P2TYERR90ZOP9BMROJ8CDE29MYULT2VYR95H7WW69J30T76MYW7031ACONJ7UVKU29XL6ARXPP115YIEA51R3L189VPR6WUQT5FSJK7JXIQPWHHM78CDGM2C5NCC7",
				new Date().toLocaleString(), "PATIENTREPORT");
		System.out.println(result);
	}

}
