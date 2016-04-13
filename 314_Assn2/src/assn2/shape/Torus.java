package assn2.shape;

import assn2.exception.InvalidParameterException;

public class Torus implements Shape {
    double ringRadius, crossSectionRadius;

    public Torus(double ringRadius, double crossSectionRadius) throws InvalidParameterException {
        if (ringRadius <= 0)
            throw new InvalidParameterException("Ring Radius", ringRadius);

        if (crossSectionRadius <= 0)
            throw new InvalidParameterException("Cross Section Radius", crossSectionRadius);

        this.ringRadius = ringRadius;
        this.crossSectionRadius = crossSectionRadius;
    }

    public double getRingRadius() {
        return ringRadius;
    }

    public void setRingRadius(double ringRadius) {
        this.ringRadius = ringRadius;
    }

    public double getCrossSectionRadius() {
        return crossSectionRadius;
    }

    public void setCrossSectionRadius(double crossSectionRadius) {
        this.crossSectionRadius = crossSectionRadius;
    }

    @Override
    public double calculateSurfaceArea() {
        return (2 * Math.PI * crossSectionRadius) * (2 * Math.PI * ringRadius);
    }

    @Override
    public double calculateVolume() {
        return (Math.PI * Math.pow(ringRadius, 2)) * (2 * Math.PI * crossSectionRadius);

    }

    @Override
    public String toString() {
        return "Torus:\n" +
                String.format("\t%-25s %10.1f\n", "Ring Radius:", ringRadius) +
                String.format("\t%-25s %10.1f\n", "Cross Section Radius:", crossSectionRadius) +
                String.format("\t%-25s %10.1f\n", "Volume:", calculateVolume()) +
                String.format("\t%-25s %10.1f", "Surface Area:", calculateSurfaceArea());
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Torus){
            Torus objTorus = (Torus)obj;
            if ((ringRadius == objTorus.ringRadius) && (crossSectionRadius == objTorus.crossSectionRadius))
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
        final int prime = 89;
        double result = 3;
        result = prime * result + ringRadius;
        result = prime * result + crossSectionRadius;
        return (int)result;
    }
}
