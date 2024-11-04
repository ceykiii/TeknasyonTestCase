package util;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code StringContext} utility class provides a centralized way to store and retrieve
 * string data across different parts of an application. It allows setting values with keys,
 * retrieving values by keys, and clearing all stored data when necessary.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class StringContext {

    /**
     * A map to store various values by their associated keys.
     */
    private static final Map<String, String> dataMap = new HashMap<>();

    /**
     * Stores a string value with a specified key.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be stored in the map
     */
    public static void setData(String key, String value) {
        dataMap.put(key, value);
    }

    /**
     * Returns the string value associated with the specified key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or {@code null} if no value is found
     */
    public static String getData(String key) {
        return dataMap.get(key);
    }

    /**
     * Clears all stored data from the context.
     */
    public static void clearAllData() {
        dataMap.clear();
    }
}
