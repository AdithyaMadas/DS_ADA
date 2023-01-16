package dailyChallenge;

//https://leetcode.com/problems/delete-columns-to-make-sorted/description/
public class deleteColumnsToMakeSorted {

    public static int minDeletionSize(String[] strs) {
        int width = strs[0].length();
        int length = strs.length - 1;
        int count = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"a", "b"}));
    }
}
