package money;

import junit.TestCase;
import money.Money;

public class MoneyTest extends TestCase {
    private Money f12CHF;
    private Money f14CHF;
    private Money f28USD;


    public MoneyTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f28USD = new Money(28,"USD");
    }

    @Override
    protected void tearDown() {

    }

    public void testMoneyEquals(){
        asserEquals(12,f12CHF.getAmount());
    }
    public void testNotMoneyEquals(){asserEquals(11,f12CHF.getAmount());}

    public void testFailed(){
        assertTrue(false);
    }
}
