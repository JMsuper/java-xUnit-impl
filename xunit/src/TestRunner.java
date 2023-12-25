import junit.TestResult;
import junit.TestSuite;
import money.MoneyTest;

public class TestRunner {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        suite.addTest(new MoneyTest("testMoneyEquals"));
        suite.addTest(new MoneyTest("testFailed"));
        suite.addTest(new MoneyTest("testNotMoneyEquals"));
        suite.addTest(new MoneyTest("NotExistMethod"));
        TestResult result = suite.run(new TestResult());
        System.out.println(result.summary());
    }
}