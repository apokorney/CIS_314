import java.security.InvalidParameterException;

public class DataWorker implements Runnable {
    private DataOwner dataOwner;

    public DataWorker(DataOwner dataOwner) {
        if (dataOwner == null)
            throw new InvalidParameterException();
        setDataOwner(dataOwner);
    }

    public void setDataOwner(DataOwner dataOwner) {
        this.dataOwner = dataOwner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            String str = Thread.currentThread().getName() + ": " + i;
            int number = hashCode() + i;
            try {
                dataOwner.addString(str);
            } catch (AlreadyExistException e) {
                e.printStackTrace();
            }
            try {
                dataOwner.addInteger(number);
            } catch (AlreadyExistException e) {
                e.printStackTrace();
            }
        }
    }
}
