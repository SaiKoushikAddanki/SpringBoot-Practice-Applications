package com.encryption.demo.encrtptor.utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Slf4j
public class BaseAESEncryptDecryptUtility {
    private static final String Algorithm = "AES/CBC/PKCS5Padding";
    private static final String SALT = "koushik";
    private final Cipher cipherEncryptor;
    private final Cipher cipherDecryptor;

    public BaseAESEncryptDecryptUtility(final String fileKey, final int aesKeyLength) {
        SecretKeySpec secretKeySpec = createSecret(fileKey, aesKeyLength);
        this.cipherEncryptor = createEncryptor(secretKeySpec);
        this.cipherDecryptor = createDecryptor(secretKeySpec);
    }

    private Cipher createDecryptor(SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, getIV());
            return cipher;
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private Cipher createEncryptor(SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, getIV());
            return cipher;
        } catch (NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private IvParameterSpec getIV() {
        return new IvParameterSpec(new byte[16]);
    }

    private SecretKeySpec createSecret(String fileKey, int aesKeyLength) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(fileKey.toCharArray(), SALT.getBytes(), 65536, aesKeyLength);
            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new IllegalStateException("Cannot generate secretkey", e);
        }
    }

    public String encrypt(String strToEncrypt) {
        try {
            return Base64.getEncoder().encodeToString(cipherEncryptor.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String strToDecrypt) {
        try {
            return new String(cipherDecryptor.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

}
