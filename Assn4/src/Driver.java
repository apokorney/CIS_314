import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {
    public static void main(String[] args) {
        int numThreads = 4;
        DataOwner dOwner = new DataOwner(); // Create a DataOwner

        for (int i = 0; i < numThreads; i++) {
            new Thread(new DataWorker(dOwner)).start(); // Create and start threads
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Results:");
        System.out.println(dOwner);
    }
}
