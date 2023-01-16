package greedy;

import java.util.Arrays;
import java.util.Map;

public class Candy {

    public static int candy(int[] ratings) {
        int[] a = new int[ratings.length];
        Arrays.fill(a, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                a[i] = a[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                if (a[i+1] + 1 > a[i]) {
                    a[i] = a[i + 1] + 1;
                }
            }
        }
        return Arrays.stream(a).sum();
    }
    /*static class Student implements Comparable<Student> {
        int rating, position;

        public Student(int rating, int position) {
            this.rating = rating;
            this.position = position;
        }


        @Override
        public int compareTo(Student o) {
            return rating - o.rating;
        }
    }
    public static int candy(int[] ratings) {
        Student[] students = new Student[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            students[i] = new Student(ratings[i], i);
        }
        Arrays.sort(students);
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        for (Student s : students) {
            int left = s.position - 1, right = s.position + 1;
            if (left >= 0 && right < ratings.length) {
                if (ratings[left] < ratings[s.position] && ratings[right] < ratings[s.position]) {
                    candy[s.position] = Math.max(candy[left], candy[right]) + 1;
                } else if (ratings[left] < ratings[s.position]) {
                    candy[s.position] = candy[left] + 1;
                }else if (ratings[right] < ratings[s.position]) {
                    candy[s.position] = candy[right] + 1;
                }
            } else if (left >= 0) {
                if (ratings[left] < ratings[s.position]) {
                    candy[s.position] = candy[left] + 1;
                }
            } else if(right < ratings.length) {
                if (ratings[right] < ratings[s.position]) {
                    candy[s.position] = candy[right] + 1;
                }
            }
        }
        return Arrays.stream(candy).sum();
    }*/

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2,2}));
    }
}
