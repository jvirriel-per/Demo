package com.jvirriel.cipher;

import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;
import static java.lang.Double.toHexString;
import static java.lang.Math.PI;

public class JwtCipherUtility {
    private static final String CIPHER_ALGORITHM = "AES";
    private static final String CIPHER_KEY = toHexString(PI);
    private static final String EMPTY = "";

    public static String cipher(String tokenToEncode) {
        return cipher(tokenToEncode, EMPTY);
    }

    public static String cipher(String tokenToEncode, String cipherKey) {
        String result;

        byte[] cipherKeyBytes = new byte[0];

        try {
            cipherKeyBytes = isNotEmpty(cipherKey) ? cipherKey.getBytes() : CIPHER_KEY.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        result = Jwts.builder()
                .setSubject(tokenToEncode)
                .signWith(HS512, new SecretKeySpec(cipherKeyBytes, 0, cipherKeyBytes.length, CIPHER_ALGORITHM))
                .compact();

        return result;
    }

    public static String decipher(String tokenToDecode) {
        return decipher(tokenToDecode, EMPTY);
    }

    public static String decipher(String tokenToDecode, String cipherKey) {
        String result;

        byte[] cipherKeyBytes = new byte[0];

        try {
            cipherKeyBytes = isNotEmpty(cipherKey) ? cipherKey.getBytes() : CIPHER_KEY.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        result = Jwts.parser()
                .setSigningKey(new SecretKeySpec(cipherKeyBytes, 0, cipherKeyBytes.length, CIPHER_ALGORITHM))
                .parseClaimsJws(tokenToDecode)
                .getBody()
                .getSubject();

        return result;
    }

    private static boolean isNotEmpty(String str) {
        return !(str == null || str.length() == 0);
    }
}
