import java.security.InvalidParameterException;
import java.util.ArrayList;

public class DataOwner {
    private final ArrayList<String> stringData;
    private final ArrayList<Integer> numericData;

    public DataOwner() {
        stringData = new ArrayList<>();
        numericData = new ArrayList<>();
    }

    public void addString(String s) throws AlreadyExistException {
        if (s == null || s.isEmpty())
            throw new InvalidParameterException();

        synchronized (stringData) {
            if (stringData.contains(s))
                throw new AlreadyExistException();
            stringData.add(s);
        }
    }

    public void addInteger(Integer i) throws AlreadyExistException {
        if (i == null)
            throw new InvalidParameterException();

        synchronized (numericData) {
            if (numericData.contains(i))
                throw new AlreadyExistException();
            numericData.add(i);
        }
    }

    @Override
    public String toString() {
        return "String list size: " + stringData.size() + " Integer list size: " + numericData.size();
    }
}
