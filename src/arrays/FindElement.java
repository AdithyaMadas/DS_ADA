package arrays;

public class FindElement {
    static int searchInSorted(int arr[], int N, int K) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > K) {
                return -1;
            }
            if (arr[i] == K) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(searchInSorted(new int[]{1,2,4,5},4,2));
        System.out.println(searchInSorted(new int[]{1,2,4,5},4,-1));
    }
}
