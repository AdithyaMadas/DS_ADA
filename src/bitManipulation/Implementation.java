package bitManipulation;

//https://practice.geeksforgeeks.org/problems/bit-manipulation-1666686020/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bit-manipulation
public class Implementation {

    public static void main(String[] args) {
        int num = 8, i = 1;
        i--;
        int mask = 1 << i;
        System.out.print((num & mask) != 0 ? 1 : 0);
        System.out.print(" ");
        System.out.print((num | mask));
        System.out.print(" ");
        System.out.print((num & ~mask));

    }

}
