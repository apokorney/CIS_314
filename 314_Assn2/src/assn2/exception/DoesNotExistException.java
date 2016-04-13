package assn2.exception;

import assn2.shape.Shape;

public class DoesNotExistException extends Exception {
    private Shape shape;

    public DoesNotExistException(Shape shape){
        this.shape = shape;
    }


    @Override
    public String getMessage() {
        return "Shape does not exist:\n" + shape;
    }
}
