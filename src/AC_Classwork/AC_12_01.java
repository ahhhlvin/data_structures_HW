package AC_Classwork;
import java.util.Arrays;

/**
 * Created by alvin2 on 12/1/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class AC_12_01
{

    public static int missingNumber(int[] nums) {
        boolean[] boolArray = new boolean[100];

        for (int i : nums ) {
            boolArray[i-1] = true;
        }

        for (int j = 0; j <= boolArray.length; j++) {
            if (!boolArray[j]) {
                return j+1;
            }
        }

        return -1;
    }
}


