/**
 * Created by alvin2 on 11/5/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class RecursionHW
{

    public static boolean isEvenWord(String string) {

        char letter = string.charAt(0);
        int index = string.indexOf(letter, 1);


        if (string.equals("")) {
            return true;
        }

        // '<0' could -1 which is 'false'
        if (index < 0) {
            return false;
        } else {
            String subString = string.substring(1, index) + string.substring(index + 1, string.length());
            // only does the recursive call if finds duplicate
            return isEvenWord(subString);
        }

    }

    // sum numbers from 1 to n

    // multiply 2 nums using addition

    // Find nth fibonacci number
    public static int fibonacci(int n) {
        if (n == 1 || n == 2)
        {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n - 2);

    }


    public static void main(String[] args) {

        System.out.println(isEvenWord("appeases"));
        System.out.println(fibonacci(4));
    }

}
