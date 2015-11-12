package AC_Classwork;
import org.omg.SendingContext.RunTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by alvin2 on 11/10/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class AC_11_10
{


    private static final int MAX_INT = 999999999;

    public static int returnLargestNum(List<Integer> nums)
    {

        if(nums.isEmpty())
        {
            throw new IllegalArgumentException("empty list");
        }


        int largestNum = Integer.MIN_VALUE;


        for(int num : nums)
        {
            largestNum = Math.max(num, largestNum);
        }

        return largestNum;
    }





    public static Set<Integer> SSNlist = new HashSet<>();
    private static int counter = 0;

    public static int returnSSN() {

        int ssn = counter;
        if (ssn > MAX_INT) {
            throw new RuntimeException("Error");
        }
        counter++;

        return ssn;

    }



    public static BigDecimal fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n is negative");
        } else if (n == 0 || n == 1) {
            return BigDecimal.ONE;
        } else {
            BigDecimal result = cache.get(n);
            if (result != null) {
                // "Cache hit" looked in cache and found it
                return result;
            }

            // "Cache miss"
            result = fibonacci(n-1).add(fibonacci(n-1));
            cache.put(n, result);
            return result;
        }



    }

    private static Map<Integer, BigDecimal> cache;

    // STATIC INITIALIZER:  (pre-stuffing a cache) --- setup that occurs before class is even initialized
    static {
        = new HashMap<Integer, BigDecimal>();
        cache.put(0, BigDecimal.ONE);
        cache.put(1, BigDecimal.ONE);
    }


    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(5);
        nums.add(9);
        nums.add(20);
        nums.add(2);


        System.out.println(returnLargestNum(nums));

        for(int i = 0; i < 15; i++)
        {
            System.out.println(String.format("%09d", returnSSN()));
        }
    }

}
