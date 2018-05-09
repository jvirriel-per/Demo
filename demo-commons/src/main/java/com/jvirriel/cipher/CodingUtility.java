package com.jvirriel.cipher;

import java.util.Base64;

import static java.util.Base64.*;

public class CodingUtility {
    public static String code(String source) {
       return getEncoder().encodeToString(source.getBytes());
    }

    public static String decode(String source) {
        return new String(getDecoder().decode(source.getBytes()));
    }
}
