package watki1;


public class Watki1 {

    public static void main(String[] args){
        
        for (int i = 0; i < 10; i++) {
            Thread newThread = new Thread(new ThrClass(i));
            newThread.start();
            
        }
    }

}
