package junit;

import java.lang.reflect.Method;

public abstract class TestCase implements Test{
    private final String fName;


    public TestCase(String name) {
        this.fName = name;
    }

    @Override
    public void run(TestResult result) {
        result.startTest(this);
        setUp();
        try{
            runTest();
        }catch (AssertionFailedError e){
            result.addFailure(this, e);
        }catch (Throwable e){
            result.addError(this,e);
        }finally {
            tearDown();
        }
    }

    protected void runTest() throws Throwable{
        Method runMethod = null;
        try{
            runMethod = getClass().getMethod(fName);
        }catch (NoSuchMethodException e){
            assertTrue("Method \""+fName+"\" not found", false);
        }
        if(runMethod != null){
            runMethod.invoke(this);
        }
    }
    protected abstract void setUp();
    protected abstract void tearDown();

    protected void assertTrue(boolean condition){
        if(!condition){
            throw new AssertionFailedError();
        }
    }

    protected void assertTrue(String msg,boolean condition){
        if(!condition){
            throw new AssertionFailedError(msg);
        }
    }

    protected void asserEquals(Object expected, Object actual){
        if(!expected.equals(actual)){
            throw new AssertionFailedError();
        }
    }
}
