package com.jvirriel.cipher;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.function.Function;

import static java.lang.Integer.toHexString;
import static java.util.Base64.getEncoder;
import static org.apache.commons.lang3.StringUtils.reverse;
import static org.apache.commons.lang3.StringUtils.rotate;


public class SeasoningUtility {
    public static String getSalt(String seed) {
        Function<String, String> encode = SeasoningUtility::getString;

        String result = seed;
        String hex = encode.apply(toHexString(seed.length()));

        for (int i = 0; i < 4; i++) {
            result = rotate(reverse(encode.apply(hex + result + hex)), result.length() / 2);
        }

        result = rotate(result, result.length() / 2);

        return result;
    }

    public static String season(String source, String seasoningString) {
        return seasoningString + source + seasoningString;
    }

    public static String unSeason(String source, String seasoningString) {
        return source.contains(seasoningString) ? source.replace(seasoningString, StringUtils.EMPTY) : source;
    }

    private static String getString(String str) {
        String result = "";

        try {
            result = getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }
}
