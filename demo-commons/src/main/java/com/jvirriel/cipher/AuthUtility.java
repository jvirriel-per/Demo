package com.jvirriel.cipher;

import static com.jvirriel.cipher.JwtCipherUtility.cipher;
import static com.jvirriel.cipher.JwtCipherUtility.decipher;
import static com.jvirriel.cipher.SeasoningUtility.getSalt;
import static com.jvirriel.cipher.SeasoningUtility.season;
import static com.jvirriel.cipher.SeasoningUtility.unSeason;

public class AuthUtility {
    public static String getAuth(String seed, String content, String key) {
        return cipher(season(content, getSalt(seed)), key);
    }

    public static String getAuthContent(String seed, String auth, String key) {
        return unSeason(decipher(auth, key), getSalt(seed));
    }
}
