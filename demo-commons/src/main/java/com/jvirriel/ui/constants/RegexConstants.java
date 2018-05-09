package com.jvirriel.ui.constants;

/**
 * Constantes literales para expresiones regulares.
 * Created by ypetrilli on 20/10/2017.
 */
public class RegexConstants {
    public static final String ONLY_LETTERS_NUMBERS_AND_SPECIFIC_CHARACTERS = "([A-Za-z0-9])+([-\\.\\_\\s]([A-Za-z0-9])+)*";
    public static final String ONLY_LETTERS_AND_SPECIFIC_CHARACTERS = "([A-Za-zñÑáéíóúÁÉÍÓÚ])+([-\\.\\_\\s]([A-Za-zñÑáéíóúÁÉÍÓÚ])+)*";
    public static final String ONLY_LETTERS_AND_SPACES = "([A-Za-zñÑáéíóúÁÉÍÓÚ])+(\\s([A-Za-zñÑáéíóúÁÉÍÓÚ])+)*";

    public static final String VALID_USERNAME = "([a-z0-9])\\w+";
}