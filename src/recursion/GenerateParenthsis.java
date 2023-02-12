package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthsis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", n, n);
        return res;
    }

    private static void generate(List<String> res, String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if(left>0) generate(res, s + "(", left - 1, right);
        if(right>left) generate(res, s + ")", left , right - 1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
