package dailyChallenge;

//https://leetcode.com/problems/detect-capital/
public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        if(Character.isUpperCase(word.charAt(0))) return allLow(word) || allCaps(word);
        else return allLow(word);
    }

    private static boolean allLow(String word) {
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                return false;
            }
        }
        return true;
    }
    private static boolean allCaps(String word) {
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Flag"));
    }
}
