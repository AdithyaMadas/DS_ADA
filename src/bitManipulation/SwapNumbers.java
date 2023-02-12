package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SwapNumbers {
    static List<Integer> get(int a, int b) {
        List<Integer> list = new ArrayList<>();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        list.add(a);
        list.add(b);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(get(3, 6));
    }
}
