package watki1;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrClass implements Runnable {

    DataOutputStream writer;
    private int randomNumber;
    private File file;
    private final String path;
    private final Random random = new Random();
    
    public ThrClass(int number){
        path = "File number #" + (number + 1) + ".bin";
    }
    
    @Override
    public void run() {
        try {
            FileOutputStream writer = new FileOutputStream(path);
            BufferedOutputStream out = new BufferedOutputStream(writer);
            file = new File(path);
             while(file.length() < 1048576){
            randomNumber = random.nextInt(255);
            out.write(randomNumber);
        }
            out.flush();
            writer.close();
        
             } catch (IOException ex) {
                Logger.getLogger(ThrClass.class.getName()).log(Level.SEVERE, null, ex);
            }

            
    }

}
