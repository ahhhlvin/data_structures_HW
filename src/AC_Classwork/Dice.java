package AC_Classwork;
import java.util.Random;

/**
 * Created by alvin2 on 11/10/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class Dice
{
    static int timesRolled;
    static int numOfDice;

    public Dice(int numOfDice)
    {
        this.numOfDice = numOfDice;
    }

    public static int getNumRolls()
    {
        return numRolls;
    }

    public static int numRolls;


    public static int roll1()
    {
        numRolls++;
        return 1 + (int) (Math.random() * 6);
    }


    public static int roll(Dice dice)
    {

        int sum = 0;

        for(int i = 0; i < numOfDice; i++)
        {
            if(numOfDice < 1)
            {
                return 0;
            }
            Random random = new Random();
            int r = 1 + random.nextInt(5);
            System.out.println(r);
            sum += r;
        }

        return sum;
    }


    public static void main(String[] args)
    {
        Dice dice = new Dice(4);
        System.out.println("total of " + numOfDice + " dice rolled = " + roll(dice));
    }
}
