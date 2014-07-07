package coincalculator;


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
    
    public void setCoinCalculator( CoinCalculator coinCalculator ) {
        this.coinCalculator = coinCalculator;
    }
    
    public void start( String amountOfChange ) {
        String result = coinCalculator.calculateChange(amountOfChange);
        
        System.out.println( "Result: " + result );
    }
    
    public static void main(String[] varArgs) {
        if (varArgs.length > 1) {
            ApplicationContext context = new ClassPathXmlApplicationContext( "application-context.xml");
            Greedy obj = (Greedy) context.getBean("greedy");
            
            obj.start( varArgs[0] );
            
        }else throw new IllegalArgumentException("No value given");
    }

}
