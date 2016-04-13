package assn2;

import assn2.exception.AlreadyExistsException;
import assn2.exception.DoesNotExistException;
import assn2.shape.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ShapeManager {
    private static HashSet<Shape> shapes = new HashSet<>();

    public static void addShape(Shape shape) throws AlreadyExistsException {
        if (shapes.contains(shape))
            throw new AlreadyExistsException(shape);
        shapes.add(shape);
    }

    public static void removeShape(Shape shape) throws DoesNotExistException {
        if (!shapes.contains(shape))
            throw new DoesNotExistException(shape);
    }

    public static ArrayList<Shape> getContents(){
        ArrayList<Shape> arrayList = new ArrayList<>(shapes);
        Collections.sort(arrayList);
        return arrayList;
    }

}
