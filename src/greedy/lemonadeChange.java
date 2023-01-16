package greedy;

public class lemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five_bills = 0, ten_bills = 0;
        for (int i : bills) {
            if (i == 5) {
                five_bills++;
            } else if (i == 10) {
                if (five_bills >= 1) {
                    five_bills--;
                    ten_bills++;
                } else {
                    return false;
                }
            } else {
                if (five_bills >= 1 && ten_bills >= 1) {
                    five_bills--;
                    ten_bills--;
                } else if (five_bills >= 3) {
                    five_bills -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10,10,5,20,5,10,5,5}));
    }
}
