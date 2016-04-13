

public class Vehicle {

    private String identifier;
    protected double speed;
    protected double maxSpeed;
    private int x;
    private int y;
    //Point p = new Point(0,0);


    public Vehicle(String identifierIn, double speedIn, double maxSpeedIn, int xIn, int yIn ) throws InvalidParameterException {
        setSpeed(speedIn);
        setMaxSpeed(maxSpeedIn);
        setIdentifier(identifierIn);

    }

    public Vehicle(double speed, double maxSpeed, String identifier, int x, int y){

    }

    public double getSpeed(){
        return speed;
    }

    public double getMaxSpeed(){
        return maxSpeed;
    }

    public String getIdentifier(){
        return identifier;
    }

    public void setSpeed(double s) throws InvalidParameterException {
        if (s < 0.0) {
            throw new InvalidParameterException("Negative speed is not valid" );
        }
        speed = s;
    }


    public void setMaxSpeed(double m) throws InvalidParameterException {
        if (m < 0.0){
            throw new InvalidParameterException("Negative max speed is not valid");
        }
        maxSpeed = m;
    }


    public void setIdentifier(String i) throws InvalidParameterException{
        if (i == null || i.length()== 0){
            throw new InvalidParameterException("Identifier cannot be null or empty");
        }
        identifier = i;
    }

    public void updateLocation(int xIn, int yIn) throws InvalidParameterException{
       }

  /*  public String toString() {
        return System.out.print(identifier);
    }
*/



}
