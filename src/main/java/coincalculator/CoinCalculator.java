package coincalculator;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:06 AM
 */

import java.lang.Integer;
import java.util.Scanner;

public class CoinCalculator {

    private static float coins[] = new float[] { 1.0f, 0.25f, 0.1f, 0.05f, 0.01f };
    
    public String calculateChange(String amountOfChange) {
        float changeValue = new Float( amountOfChange ).floatValue();
        int count = 0, i = 0;
        while( changeValue > 0 ) {
            if( changeValue >= coins[i] ) {
                changeValue -= coins[i];
                count++;
            } else {
                i++;
            }
        }
        
        return Integer.toString( count );
    }
}
