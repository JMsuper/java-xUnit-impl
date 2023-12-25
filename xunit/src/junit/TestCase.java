package junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase implements Test{
    private final String fName;


    public TestCase(String name) {
        this.fName = name;
    }

    public String getTestName() {
        return fName;
    }

    @Override
    public TestResult run(TestResult result) {
        result.startTest(this);
        setUp();
        try{
            runTest();
        }catch (AssertionFailedError e){
            result.addFailure(this, e);
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(e.getCause());
            result.addError(this,e);
        }finally {
            tearDown();
        }
        return result;
    }

    private void runTest() throws Throwable{
        Method runMethod = null;
        try{
            runMethod = getClass().getMethod(fName);
        }catch (NoSuchMethodException e){
            assertTrue("Method \""+fName+"\" not found", false);
        }
        try{
            runMethod.invoke(this);
        }catch (InvocationTargetException e){
            throw e.getCause();
        }
    }
    protected abstract void setUp();
    protected abstract void tearDown();

    protected void assertTrue(boolean condition){
        if(!condition){
            throw new AssertionFailedError("assert condition is not true");
        }
    }

    protected void assertTrue(String msg,boolean condition){
        if(!condition){
            throw new AssertionFailedError(msg);
        }
    }

    protected void asserEquals(Object expected, Object actual){
        if(!expected.equals(actual)){
            throw new AssertionFailedError(String.format("actual(%s) not equal to actual(%s)",actual,expected));
        }
    }
}
