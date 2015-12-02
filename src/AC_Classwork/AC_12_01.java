package AC_Classwork;
/**
 * Created by alvin2 on 12/1/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class AC_12_01
{

    public static int missingNumber(int[] nums) {
        int missingNum = 0;
        // assuming that the int[] nums contains 99 numbers and 100 spaces
        for(int i = 0; i <= nums.length; i++)
        {

            if (i == nums[i]) {

            } else {
                missingNum = i;
            }
        }

        return missingNum;
    }
}


