package dailyChallenge;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (canPlaceFlower(i, flowerbed)) {
                flowerbed[i] = 1;
                i++;
                n--;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean canPlaceFlower(int i, int[] flowerbed) {
        if (i >= flowerbed.length) {
            return false;
        }
        if (flowerbed.length == 1) {
            return flowerbed[i] == 0;
        }
        if (flowerbed[i] == 1) {
            return false;
        }
        if (i == 0) {
            return flowerbed[i + 1] == 0;
        } else if (i == flowerbed.length - 1) {
            return flowerbed[i - 1] == 0;
        } else {
            return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
    }
}
