package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationForNumber {

    static String[] keys = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder stringBuilder = new StringBuilder();
        generate(res, digits, 0, stringBuilder);
        return res;
    }

    private static void generate(List<String> res, String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        for (char c : keys[digits.charAt(index) - '2'].toCharArray()) {
            stringBuilder.append(c);
            generate(res, digits, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

//    public static List<String> letterCombinations(String digits) {
//        if(digits.length()==0) return new ArrayList<>();
//        HashMap<Character, String> map = new HashMap<>();
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        List<String> res = new ArrayList<>();
//        res.add("");
//        generate(map, res, digits, 0);
//        return res;
//    }
//
//    private static void generate(HashMap<Character, String> map, List<String> res, String digits, int i) {
//        if (i == digits.length()) {
//            return;
//        }
//        int len = res.size();
//        String s = map.get(digits.charAt(i));
//        increaseSizeOfList(res, s.length());
//        int q = 0;
//        for (char x : s.toCharArray()) {
//            for (int w = 0; w < len; w++) {
//                String s1 = res.get(q) + x;
//                res.remove(q);
//                res.add(q, s1);
//                q++;
//            }
//        }
//        generate(map, res, digits, i + 1);
//    }
//
//    private static void increaseSizeOfList(List<String> res, int length) {
//        List<String> original = new ArrayList<>(res);
//        for (int i = 0; i < length - 1; i++) {
//            res.addAll(new ArrayList<>(original));
//        }
//    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
