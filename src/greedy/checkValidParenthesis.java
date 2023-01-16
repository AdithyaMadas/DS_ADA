package greedy;

import java.util.Stack;

public class checkValidParenthesis {


    public static boolean checkValidString(String s) {
        int leftMax = 0, leftMin = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMax++;
                leftMin++;
            }
            else if (c == ')') {
                leftMax--;
                leftMin--;
            } else {
                leftMax++;
                leftMin--;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
            if (leftMax < 0) {
                return false;
            }
        }
        return leftMin == 0;
    }
    /*public static boolean checkValidString(String s) {
        Stack<Integer> opening_stack = new Stack<>();
        Stack<Integer> star_stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                star_stack.push(i);
            }else if (s.charAt(i) == '(') {
                opening_stack.push(i);
            } else {
                if (opening_stack.size() > 0) {
                    opening_stack.pop();
                } else if (star_stack.size() > 0) {
                    star_stack.pop();
                } else {
                    return false;
                }
            }
        }
        while (opening_stack.size() > 0 && star_stack.size() > 0) {
            if (opening_stack.peek() > star_stack.peek()) {
                return false;
            } else {
                opening_stack.pop();
                star_stack.pop();
            }
        }
        return opening_stack.size() == 0;
    }*/

    public static void main(String[] args) {
        System.out.println(checkValidString("*("));
    }
}
