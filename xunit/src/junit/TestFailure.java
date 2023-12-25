package junit;

public class TestFailure {
    protected Test fFailedTest;
    protected Throwable fThrownException;

    public TestFailure(Test fFailedTest, Throwable fThrownException) {
        this.fFailedTest = fFailedTest;
        this.fThrownException = fThrownException;
    }
}
