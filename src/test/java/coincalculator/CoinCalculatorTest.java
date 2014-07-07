package coincalculator;

import coincalculator.CoinCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:28 AM
 */
public class CoinCalculatorTest {

    @Test
    public void zeroChangeMeansYouGetZeroCoins() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("0.00");

        assertEquals("0", coinMessage);
    }

    @Test
    public void oneCentShouldGiveYouOnePenny() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("0.01");

        assertEquals("1", coinMessage);
    }

    @Test
    public void tenCentsShouldGiveYouOneDime() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("0.10");

        assertEquals("1", coinMessage);
    }
    
    @Test
    public void twentyFiveCentsShouldGiveYouOneQuarter() {
        CoinCalculator coinCalculator =new CoinCalculator();
        
        String coinMessage = coinCalculator.calculateChange("0.25");
        
        assertEquals("1", coinMessage);
    }

    @Test
    public void ThirtyCentsShouldGiveYouOneQuarterAndOneNickel() {
        CoinCalculator coinCalculator =new CoinCalculator();
        
        String coinMessage = coinCalculator.calculateChange("0.30");
        
        assertEquals("2", coinMessage);
    }
    
    @Test
    public void oneHundredCentsShouldGiveYouOneDollar() {
        CoinCalculator coinCalculator =new CoinCalculator();
        
        String coinMessage = coinCalculator.calculateChange("1.00");
        
        assertEquals("1", coinMessage);
    }
    
    @Test
    public void twentyNineCentsShouldGiveYouOneQuarterAndFourPennies() {
        CoinCalculator coinCalculator =new CoinCalculator();
        
        String coinMessage = coinCalculator.calculateChange("0.29");
        
        assertEquals("5", coinMessage);
    }
    
}
