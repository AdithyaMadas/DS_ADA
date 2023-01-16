package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

class Item {
    int value, weight;
    double weight_value;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
        this.weight_value = ((double) value) / weight;
    }
}

class fractionalKnapsack
{
    //Function to get the maximum total value in the knapsack.
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (int) (o2.weight_value - o1.weight_value);
            }
        });
        double ans = 0;
        for (Item item : arr) {
            ans += item.weight_value * (Math.min(item.weight, W));
            W -= Math.min(item.weight, W);
            if (W == 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fractionalKnapsack(50, new Item[]{new Item(60, 10), new Item(100, 20), new Item(120, 30)}, 3));
    }
}
