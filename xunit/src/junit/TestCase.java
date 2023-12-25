package junit;

public abstract class TestCase implements Test{
    private final String fName;

    public TestCase(String name) {
        this.fName = name;
    }

    @Override
    public void run(TestResult result) {
        result.startTest(this);
        runTest();
        setUp();
        tearDown();
    }

    protected abstract void runTest();
    protected abstract void setUp();
    protected abstract void tearDown();
}
