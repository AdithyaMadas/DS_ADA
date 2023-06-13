package codingRounds;

import java.util.*;

public class sureScripts {

    static int __builtin_ctz(int a)
    {
        int count = 0;
        for(int i = 0; i < 40; i++)
            if(((a >> i) & 1) == 0)
            {
                count++;
            }
            else
                break;
        return count;
    }


    static int getMinServers(int x,List<Integer> list)
    {
        int n = list.size();
        // To store the count of powers of two
        Vector<Integer> cnt = new Vector<Integer>();

        for (int i = 0; i < 31; ++i)
            cnt.add(0);

        for (int i = 0; i < n; ++i)
        {

            // __builtin_ctz(list.get(i)) returns the count
            // of trailing 0s in list.get(i)

            cnt.set(__builtin_ctz(list.get(i)),
                    (cnt.get(__builtin_ctz(list.get(i))) == null) ?
                            1 : cnt.get(__builtin_ctz(list.get(i))) + 1);
        }

        int ans = 0;
        for (int i = 30; i >= 0 && x > 0; --i)
        {

            // If current power is available
            // in the array and can be used
            int need = Math.min(x >> i, cnt.get(i));

            // Update the answer
            ans += need;

            // Reduce the number
            x -= (1 << i) * need;
        }

        // If the original number is not reduced to 0
        // It cannot be represented as the sum
        // of the given powers of 2
        if (x > 0)
            ans = -1;

        return ans;
    }





    public static void main(String[] args) {
        System.out.println(getMinServers(10, new ArrayList<Integer>() {{
            add(1);
            add(1);
            add(2);
            add(4);
            add(4);
        }}));
    }

}
