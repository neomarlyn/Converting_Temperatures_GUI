package domain;

public class TemperatureException extends Exception{

    public TemperatureException(){
        super("Invalid temperature operation occurred!");
    }

    public TemperatureException(String message){
        super(message);
    }


}
