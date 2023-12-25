package junit;

import java.util.Enumeration;
import java.util.Vector;

public class TestSuite implements Test{
    private Vector fTests = new Vector();

    @Override
    public TestResult run(TestResult result) {
        for(Enumeration e = fTests.elements(); e.hasMoreElements();){
          Test test = (Test)e.nextElement();
          test.run(result);
        }
        return result;
    }

    public void addTest(Test test){
        fTests.addElement(test);
    }
}
