package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test10 {
    private final static String FULL_TEXT_MATCH_FORMAT = "(?i)%s";
    private final static String NON_FULL_TEXT_MATCH_FORMAT = "(?i).*%s.*";

    public static void main(String[] args) {
        // String[] serverLimits = { "4", "2", "1", "3" };
        //
        // Arrays.sort(serverLimits);
        // System.out.println(Arrays.binarySearch(serverLimits, "-4"));
        //
        // System.out.println(ArrayUtils.contains(serverLimits, "3"));

        String key = "test";

        System.out.println("122TESTx".matches(String.format(NON_FULL_TEXT_MATCH_FORMAT, key)));
        System.out.println("Test".matches(String.format(FULL_TEXT_MATCH_FORMAT, key)));
    }
}
