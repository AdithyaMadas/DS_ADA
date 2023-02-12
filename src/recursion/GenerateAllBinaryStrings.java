package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {
    public static List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();
        generate(res, n - 1, "0");
        generate(res, n - 1, "1");
        return res;
    }

    private static void generate(List<String> res, int len, String currString) {
        if (len == 0) {
            res.add(currString);
            return;
        }
        if (currString.charAt(currString.length() - 1) == '0') {
            generate(res, len - 1, currString + "0");
            generate(res, len - 1, currString + "1");
        } else {
            generate(res, len - 1, currString + "0");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateBinaryStrings(3));
    }
}
