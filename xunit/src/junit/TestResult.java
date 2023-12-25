package junit;

public class TestResult {
    private int runCount = 0;
    private int failedCount = 0;

    public void testStarted(){
        runCount += 1;
    }

    public void testFailed(){
        failedCount -= 1;
    }

    public String summary(){
        return String.format("%d run, %d failed",this.runCount,this.failedCount);
    }
}
