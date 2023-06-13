package codingRounds;

import java.util.*;

public class lruCache {

    static class Node {
        int anInt;

        public Node(int anInt) {
            this.anInt = anInt;
        }
    }
    public static int  cacheMisses(int[] inputNum, int size)
    {
        if(size==0) return inputNum.length;
        HashMap<Integer, Node> set = new HashMap<>();
        LinkedList<Node> list = new LinkedList<>();
        int  answer = 0;
        for (int i : inputNum) {
            if (!set.containsKey(i)) {
                answer++;
                if (list.size() == size) {
                    set.remove(list.removeLast().anInt);
                }
                Node node = new Node(i);
                list.addFirst(node);
                set.put(i, node);
            } else {
//                Node node = set.get(i);
//                list.remove(node);
//                list.addFirst(node);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(cacheMisses(new int[]{1, 2, 1, 3, 1, 2}, 2));
    }


}
