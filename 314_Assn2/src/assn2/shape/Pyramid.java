package assn2.shape;

import assn2.exception.InvalidParameterException;

public class Pyramid implements Shape {
    double length, width, apex;

    public Pyramid(double length, double width, double apex) throws InvalidParameterException {
        if (length <= 0)
            throw new InvalidParameterException("Length", length);

        if (width <= 0)
            throw new InvalidParameterException("Width", width);

        if (apex <= 0)
            throw new InvalidParameterException("Apex", apex);

        this.length = length;
        this.width = width;
        this.apex = apex;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getApex() {
        return apex;
    }

    public void setApex(double apex) {
        this.apex = apex;
    }

    @Override
    public double calculateSurfaceArea() {
        return (length * width) +
                (length * Math.sqrt(Math.pow(width / 2, 2) + Math.pow(apex, 2))) +
                (width * Math.sqrt(Math.pow(length / 2, 2) + Math.pow(apex, 2)));
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * (length * width * apex);
    }

    @Override
    public String toString() {
        return "Pyramid:\n" +
                String.format("\t%-25s %10.1f\n", "Length:", length) +
                String.format("\t%-25s %10.1f\n", "Width:", width) +
                String.format("\t%-25s %10.1f\n", "Apex:", apex) +
                String.format("\t%-25s %10.1f\n", "Volume:", calculateVolume()) +
                String.format("\t%-25s %10.1f", "Surface Area:", calculateSurfaceArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pyramid){
            Pyramid objPyramid = (Pyramid)obj;
            if ((length == objPyramid.length) && (width == objPyramid .width) && (apex == objPyramid.apex))
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
        final int prime = 59;
        double result = 7;
        result = prime * result + length;
        result = prime * result + width;
        result = prime * result + apex;
        return (int)result;
    }
}
