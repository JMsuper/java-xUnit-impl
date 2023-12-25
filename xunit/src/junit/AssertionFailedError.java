package junit;

public class AssertionFailedError extends Error{
    public AssertionFailedError(){}
    public AssertionFailedError(String msg){
        super(msg);
    }
}
