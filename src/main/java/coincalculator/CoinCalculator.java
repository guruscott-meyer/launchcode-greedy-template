package coincalculator;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:06 AM
 */

import java.lang.Integer;
import static java.lang.Math.round;
import java.util.Scanner;

public class CoinCalculator {

    private static int coins[] = new int[] { 100, 25, 10, 5, 1 };
    
    public int calculateChange(String amountOfChange) {
        int changeValue = round( Float.parseFloat( amountOfChange ) * 100f );
        int count = 0, i = 0;
        while( changeValue >= 0 && i < coins.length ) {
            if( changeValue >= coins[i]) {
                changeValue -= coins[i];
                count++;
            } else {
                i++;
            }
        }
        
//        return Integer.toString( count );
        return count;
    }
}
