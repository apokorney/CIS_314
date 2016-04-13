package assn2.shape;

import assn2.exception.InvalidParameterException;

public class Cone implements Shape {
    private double radius, height;

    public Cone(double radius, double height) throws InvalidParameterException {
        if (radius <= 0)
            throw new InvalidParameterException("Radius", radius);

        if (height <= 0)
            throw new InvalidParameterException("Height", height);

        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateSurfaceArea() {
        return Math.PI * radius * (radius + Math.sqrt((Math.pow(height, 2) + Math.pow(radius, 2))));
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * (height / 3);
    }

    @Override
    public String toString() {
        return "Cone:\n" +
                String.format("\t%-25s %10.1f\n", "Radius:", radius) +
                String.format("\t%-25s %10.1f\n", "Height:", height) +
                String.format("\t%-25s %10.1f\n", "Volume:", calculateVolume()) +
                String.format("\t%-25s %10.1f", "Surface Area:", calculateSurfaceArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cone){
            Cone objCone = (Cone)obj;
            if ((radius == objCone.radius) && (height == objCone.height))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Shape o) {
        double thisVolume = calculateVolume();
        double oVolume = o.calculateVolume();
        if (thisVolume < oVolume)
            return -1;
        if (thisVolume > oVolume)
            return 1;
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        double result = 5;
        result = prime * result + radius;
        result = prime * result + height;
        return (int)result;
    }
}
