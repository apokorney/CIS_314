import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {

    private int maxDeliveries;
    private List<List<String>> addresses = new ArrayList<List<String>>();


    public Truck(String identifierIn, double speedIn, double maxSpeedIn, int xIn, int yIn){     //stuck here, why a default constructor error?

    }

    public Truck(){     //no default constructor in Vehicle????? Same issue as above constructor.

    }


    public ArrayList addDestination() throws ListFullException{
        if (addresses.size() == maxDeliveries){
        throw new ListFullException ("Array List is full");}
        return maxDeliveries:}


    public ArrayList removeDestination(ArrayList addresses) throws InvalidParameterException{
        if (addresses.isEmpty() || addresses.equals("null")){
            throw new InvalidParameterException("Identifier cannot be null or empty");
        }
        return addresses;
    }

    public ArrayList alreadyExistsException(ArrayList addresses) throws AlreadyExistsException{
        if (addresses == addresses){
            throw new AlreadyExistsException("Already Exists!");}
        return addresses;
        }



        public ArrayList DoesNotExistExceptionon(ArrayList addresses) throws DoesNotExistException{
        if (addresses == addresses){
        throw new DoesNotExistException("Does not Exist!");}
        return addresses;
        }
        }









}
