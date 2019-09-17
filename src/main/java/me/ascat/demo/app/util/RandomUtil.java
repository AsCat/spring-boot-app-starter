package me.ascat.demo.app.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author wengyanghui@gmail.com
 */
public class RandomUtil {

    private final static String LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    private final static java.util.Random RAND = new java.util.Random();

    private final static Set<String> IDENTIFIERS = new HashSet<>();

    public static String getRandName() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = RAND.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(LEXICON.charAt(RAND.nextInt(LEXICON.length())));
            }
            if (IDENTIFIERS.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public static int getRandAge(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return RAND.nextInt((max - min) + 1) + min;
    }
}
