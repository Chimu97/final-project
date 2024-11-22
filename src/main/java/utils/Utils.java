package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String generateUniqueUsername(String prefix, int length) {
        String randomPart = RandomStringUtils.randomAlphanumeric(length);
        return prefix + randomPart;
    }
}