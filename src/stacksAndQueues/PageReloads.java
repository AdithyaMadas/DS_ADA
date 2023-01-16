package stacksAndQueues;

import java.util.*;

public class PageReloads {
    static int pageFaults(int N, int C, int pages[]) {
        Queue<Integer> q = new LinkedList<>();
        int fault=0;
        for(int i=0; i<N; i++) {
            if(q.contains(pages[i])) { //If Page is alread in Queue
                q.remove(pages[i]); //remove it from it's position
                q.add(pages[i]); //refresh it's location in the Queue (Head)

            } else {
                if(q.size() < C) { //If Queue <Memory> has space
                    q.add(pages[i]); // add page to Queue (Head)
                    fault++; //Increase fault

                } else { //If Queue <Memory> is full
                    q.remove();  // remove the <LRU> Least Recently Used from Tail
                    q.add(pages[i]); //add page to Queue (Head)
                    fault++; // Increase fault
                }
            }
        }

        return fault;
    }

    private static void updateQueue(ArrayDeque<Integer> queue, int element) {
        queue.remove(element);
        queue.offerFirst(element);
    }

    private static void addToCache(Set<Integer> pagesInCache, ArrayDeque<Integer> queue, int element, int capacity) {
        if (pagesInCache.size() < capacity) {
            pagesInCache.add(element);
            queue.offer(element);
            return;
        }

        Integer integer = queue.pollFirst();
        pagesInCache.remove(integer);
        pagesInCache.add(element);
        queue.offer(element);
    }

    public static void main(String[] args) {
        System.out.println(pageFaults(9, 4, new int[]{5, 0, 1, 3, 2, 4, 1, 0, 5}));
    }
}
