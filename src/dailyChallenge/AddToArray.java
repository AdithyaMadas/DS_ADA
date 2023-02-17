package dailyChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddToArray {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        boolean carry = false;
        while (k != 0 && i >= 0) {
            int digit = k % 10;
            k /= 10;
            list.addFirst((digit + num[i] + (carry ? 1 : 0)) % 10);
            carry = (digit + num[i--] + (carry ? 1 : 0)) > 9;
        }
        while (k != 0) {
            int digit = k % 10;
            k /= 10;
            list.addFirst( (digit + (carry ? 1 : 0)) % 10);
            carry = (digit + (carry ? 1 : 0)) > 9;
        }
        while (i >= 0) {
            list.addFirst( (num[i] + (carry ? 1 : 0)) % 10);
            carry = (num[i--] + (carry ? 1 : 0)) > 9;
        }
        if(carry) list.addFirst( 1);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
    }
}
