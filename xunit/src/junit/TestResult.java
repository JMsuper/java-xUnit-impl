package junit;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private final List<TestCase> fRunTests = new ArrayList<>();
    private final List<TestFailure> fErrors = new ArrayList<>();
    private final List<TestFailure> fFailures = new ArrayList<>();

    public synchronized void startTest(TestCase test){
        fRunTests.add(test);
    }

    public synchronized void addError(TestCase test, Throwable t){
        fErrors.add(new TestFailure(test,t));
    }

    public synchronized void addFailure(TestCase test, Throwable t){
        fFailures.add(new TestFailure(test,t));
    }

    public String summary(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d run, %d failed",fRunTests.size(),fErrors.size() + fFailures.size()))
                .append(System.lineSeparator());

        for(TestFailure testFailure : fFailures){
            Error e = (Error)testFailure.fThrownException;
            sb.append("failed method : ")
                .append(testFailure.fFailedTest.getTestName())
                    .append(" , msg : ")
                    .append((e.getMessage()))
                    .append(System.lineSeparator());
        }
        for(TestFailure testFailure : fErrors){
            sb.append("errored method : ")
                    .append(testFailure.fFailedTest.getTestName())
                    .append(" , msg : ")
                    .append(testFailure.fThrownException.getMessage())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
