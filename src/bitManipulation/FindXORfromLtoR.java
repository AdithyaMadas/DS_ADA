package bitManipulation;

public class FindXORfromLtoR {
    public static int findXOR(int l, int r) {
        /*int xor = 0;
        for (int i = 0; i <= 8; i++) {
            xor ^= i;
            System.out.println(xor);
        }*/
        return findCummilativeSum(l-1) ^ findCummilativeSum(r);
    }

    private static int findCummilativeSum(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            case 3:
                return 0;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findXOR(4, 8));
    }

}
