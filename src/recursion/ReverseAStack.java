package recursion;

import java.util.Stack;

public class ReverseAStack {
    static void reverse(Stack<Integer> s){
        int x=s.peek();
        s.pop();
//        fun(s);
        insert_at_bottom(s, x);
    }

    static void insert_at_bottom(Stack<Integer> s, int x){
        if(s.size()==0){
            s.add(x);
        }
        else{
            int y= s.peek();
            s.pop();
            insert_at_bottom(s, x);
            s.add(y);
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(41);
        stack.push(3);
        stack.push(32);
        stack.push(2);
        stack.push(11);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
