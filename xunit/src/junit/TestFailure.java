package junit;

public class TestFailure {
    protected TestCase fFailedTest;
    protected Throwable fThrownException;

    public TestFailure(TestCase fFailedTest, Throwable fThrownException) {
        this.fFailedTest = fFailedTest;
        this.fThrownException = fThrownException;
    }
}
