package assn2.exception;

import assn2.shape.Shape;

public class AlreadyExistsException extends Exception{
    private Shape shape;

    public AlreadyExistsException(Shape shape){
        this.shape = shape;
    }

    @Override
    public String getMessage() {
        return "Shape already exists:\n" + shape.toString();
    }
}
