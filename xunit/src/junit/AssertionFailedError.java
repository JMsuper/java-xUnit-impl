package junit;

public class AssertionFailedError extends Error{
    public AssertionFailedError(){super();}
    public AssertionFailedError(String msg){
        super(msg);
    }
}
