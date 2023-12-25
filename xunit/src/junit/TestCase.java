package junit;

public class TestCase {
    private String name;

    public TestCase(String name){
        this.name = name;
    }

    public void setUp(){}
    public void tearDown(){}

    public TestResult run(TestResult result){
        result.testStarted();
        setUp();

    }
}
