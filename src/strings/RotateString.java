package strings;

public class RotateString {

    /*public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }*/
    public static boolean rotateString(String s, String goal) {
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if ((goal.substring(i, len) + goal.substring(0, i)).equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abced"));
    }
}
