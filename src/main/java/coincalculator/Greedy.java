package coincalculator;

import java.util.Scanner;
import coincalculator.CoinCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:05 AM
 */
public class Greedy {

    private CoinCalculator coinCalculator;
    
    public Greedy() {
        
    }
    
    public void setCoinCalculator( CoinCalculator coinCalculator ) {
        this.coinCalculator = coinCalculator;
    }
    
    public void start() {
        
        Scanner s = new Scanner( System.in );
        
        System.out.print("Input amount of Change: $");
        
        float changeAmount = s.nextFloat();
        
        System.out.print("\n");
        
        int result = coinCalculator.calculateChange( Float.toString(changeAmount) );
        
        System.out.println( "Result: " + result );
    }
    
    public static void main(String[] varArgs) {
        
        
        ApplicationContext context = new ClassPathXmlApplicationContext( "application-context.xml");
        Greedy obj = (Greedy) context.getBean("greedy");

        obj.start();
            
        
    }

}
