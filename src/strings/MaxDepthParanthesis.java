package strings;

public class MaxDepthParanthesis {
    public static int maxDepth(String s) {
        int maxDepth = 0, currDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currDepth++;
                if (currDepth > maxDepth) {
                    maxDepth = currDepth;
                }
            }
            if (c == ')') {
                currDepth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
