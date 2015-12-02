import java.util.ArrayList;

/**
 * Created by alvin2 on 11/16/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class HW_11_17
{



    public static int get_max_profit(int [] stocks)
    {
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

    public static ArrayList<Integer> get_products_of_all_ints_except_at_index() {
        int[] nums = {1, 7, 3, 4};
        ArrayList<Integer> products = new ArrayList<>(4);


        for (int index = 0; index < nums.length; index++) {
            int tempNum = 1;

            for (int nestedIndex = 0; nestedIndex < nums.length; nestedIndex++)
            {
                if(nestedIndex != index)
                {
                    tempNum *= nums[nestedIndex];
                }
            }

            products.add(tempNum);
        }

        return products;
    }



    public static void main(String[] args2)
    {
        int[] stock_prices_yesterday = {10, 7, 5, 8, 11, 9};

        System.out.println(get_max_profit(stock_prices_yesterday));
        System.out.println(get_products_of_all_ints_except_at_index());


    }




}
