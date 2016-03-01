package watki2;

import java.math.BigInteger;


public class Factorial implements Runnable {

    private final boolean recursiveMode;
    private static BigInteger number, recResult, itResult;
    private static long recTime, itTime;
    
    public  static BigInteger GetRecResult(){
        if (recResult.compareTo(BigInteger.ONE) < 0)
            recResult = BigInteger.ONE;
        return recResult;
    }
    
    public static BigInteger GetItResult(){
        if (itResult.compareTo(BigInteger.ONE) < 0)
            itResult = BigInteger.ONE;
        return itResult;
    }
    
    public static long GetRecTime(){
        return recTime/1000;
    }
    
    public static long GetItTime(){
        return itTime/1000;
    }
    
    public Factorial(boolean mode, int number){
        this.recursiveMode = mode;
        Factorial.number = BigInteger.valueOf(number);
    }
    
    private  BigInteger CalculateRec(BigInteger number, BigInteger number2){
        number = number.multiply(number2);
       
       if(number2.intValue() <= 1)
           return number;
        else{
            number2 = number2.subtract(BigInteger.valueOf(1));
            return CalculateRec(number,number2);
        }
    }
    
    private BigInteger CalculateIt(BigInteger number, BigInteger number2){
        if(number == BigInteger.valueOf(1) || number == BigInteger.valueOf(0))
            return BigInteger.valueOf(1);
        else{
            while ((number.compareTo(BigInteger.ZERO)) > 0){
            
                number2 = number2.multiply(number);
                number = number.subtract(BigInteger.valueOf(1));
                }
            return number2;
        }
    }
    
    
    @Override
    public void run(){
        long start,end;
        if(recursiveMode){
            start = System.nanoTime();
            recResult = CalculateRec(number, Factorial.number.subtract(BigInteger.valueOf(1)));
            end = System.nanoTime();
            recTime = end - start;
        }
           
        else{
            start = System.nanoTime();
            itResult = CalculateIt(number, BigInteger.valueOf(1));
            end = System.nanoTime();
            itTime = end - start;
        }
    }
    
}


    
