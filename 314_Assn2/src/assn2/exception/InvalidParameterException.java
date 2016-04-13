package assn2.exception;

public class InvalidParameterException extends Exception {
    private String s;
    private double val;

    public InvalidParameterException(String s, double val) {
        this.s = s;
        this.val = val;
    }

    @Override
    public String getMessage() {
        return "Invalid parameter - " + s + ": " + String.format("%10.1f",val);
    }
}
