import java.util.ArrayList;

/**
 * Created by alvin2 on 11/16/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class HW_11_17
{

    public static int getMaxDif()
    {
        int[] stocks = {10, 7, 5, 8, 11, 9};
        int maxDif = 0;

        for(int i = 0; i < stocks.length - 1; i++)
        {
            for(int j = 1; j < stocks.length; j++)
            {
                if(stocks[i] - stocks[j] > maxDif)
                {
                    maxDif = stocks[i] - stocks[j];
                }
            }
        }

        return maxDif;

    }

    public static ArrayList<Integer> getProducts()
    {
        int[] nums = {1, 7, 3, 4};
        ArrayList<Integer> products = new ArrayList<>(4);

        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] == nums[j]) {

                }
                    if (! products.contains(nums[i] * nums[j]))
                    {
                        products.add(nums[i] * nums[j]);
                    }

            }
        }

        return products;
    }

    public static void main(String[] args2)
    {
        System.out.println(getMaxDif());
        System.out.println(getProducts());

    }


}
