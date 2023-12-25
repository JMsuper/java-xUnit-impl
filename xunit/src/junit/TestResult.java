package junit;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    protected int fRunTests;
    private List<TestFailure> fErrors;
    private List<TestFailure> fFailures;

    public TestResult(){
        fRunTests = 0;
        fErrors = new ArrayList<>();
        fFailures = new ArrayList<>();
    }

    public synchronized void startTest(Test test){
        fRunTests++;
    }

    public synchronized void addError(Test test, Throwable t){
        fErrors.add(new TestFailure(test,t));
    }

    public synchronized void addFailure(Test test, Throwable t){
        fFailures.add(new TestFailure(test,t));
    }
}
