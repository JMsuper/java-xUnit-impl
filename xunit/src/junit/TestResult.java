package junit;

public class TestResult {
    protected int fRunTests;

    public TestResult(){
        fRunTests = 0;
    }

    public synchronized void startTest(Test test){
        fRunTests++;
    }
}
