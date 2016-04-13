import java.security.InvalidParameterException;


public class Point {

    private int x;
    private int y;


    public Point(int xIn, int yIn)throws InvalidParameterException {
        setX(xIn);
        setY(yIn);}

    public int getX(){
        return x;}

    public int getY(){
        return y;}

    public final void setX(int xIn) throws InvalidParameterException {

        if(xIn < 0.0){
            throw new InvalidParameterException("Invalid 'x' value" + xIn);}

        x = xIn;}


    public final void setY(int yIn) throws InvalidParameterException {
        if (yIn < 0.0) {
            throw new InvalidParameterException("Invalid 'y' value: " + yIn);
        }
        y = yIn;}


    public String toString(){

        return "("+x+ "," + y +")";}

}
