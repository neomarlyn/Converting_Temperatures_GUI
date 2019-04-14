package domain;
import org.apache.logging.log4j.*;
public class Temperature {
    Logger logger = LogManager.getLogger(Temperature.class);

    public enum Scale { Kelvin, Celsius, Farenheit };

    private static final double LOWEST_KELVIN_TEMP = 0.0;
    private static final double LOWEST_CELSIUS_TEMP = -273.15;
    private static final double LOWEST_FARENHEIT_TEMP = -459.67;
    private double kelvin;

    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFarenheit() {
        return farenheit;
    }

    private double celsius;
    private double farenheit;

    public Temperature()throws TemperatureException{
        setKelvin(LOWEST_KELVIN_TEMP);
    }

    public Temperature(double inputTemp)throws TemperatureException{
        logger.debug("Temp constructor");
        setKelvin(inputTemp);
    }

    public Temperature(Scale inputScale, double inputTemp)throws TemperatureException{

        //int intScale = inputScale.ordinal();
        //String scale = inputScale.toString();
        //String kelvin = Scale.Kelvin.toString();

        switch(inputScale){


            case Kelvin:
                logger.debug("Temp switch on inputscale K");
                setKelvin(inputTemp);
                break;
            case Celsius:
                logger.debug("Temp switch on inputscale C");
                setCelsius(inputTemp);
                break;
            case Farenheit:
                logger.debug("Temp switch on inputscale F");
                setFarenheit(inputTemp);
                break;

        }




    }

    @Override
    public String toString() {
        logger.debug("Temp tostring");

        return "Temperature{" +
                "kelvin=" + kelvin +
                ", celsius=" + celsius +
                ", farenheit=" + farenheit +
                '}';
    }

    public void setKelvin(double kelvin) throws TemperatureException{
        logger.debug("Temp setkelvin");

        if (kelvin < LOWEST_KELVIN_TEMP){
            throw new TemperatureException("Invalid Kelvin Temperature (>= " + LOWEST_KELVIN_TEMP + ")");
        }
        this.kelvin = kelvin;
        convertKelvinToCelsius();
        convertCelsiusToFarenheit();
    }

    public void setCelsius(double celsius)  throws TemperatureException{
        logger.debug("Temp setcelsius");

        if (celsius < LOWEST_CELSIUS_TEMP){
            throw new TemperatureException("Invalid Celsius Temperature (>= " + LOWEST_CELSIUS_TEMP + ")");
        }
        this.celsius = celsius;

        convertCelsiusToFarenheit();
        convertFarenheitToKelvin();
    }

    public void setFarenheit(double farenheit) throws TemperatureException {
        logger.debug("Temp setfarenheit");

        if (farenheit < LOWEST_FARENHEIT_TEMP){
            throw new TemperatureException("Invalid Farenheit Temperature (>= " + LOWEST_FARENHEIT_TEMP + ")");
        }
        this.farenheit = farenheit;
        convertFarenheitToKelvin();
        convertKelvinToCelsius();
    }


    private void convertKelvinToCelsius(){
        logger.debug("Temp convertkelvintocelsius");

        celsius = kelvin - 273.15; }

    private void convertCelsiusToFarenheit(){
        logger.debug("Temp convertcelsiustofarenheit");


        farenheit = celsius * 9.0/5.0 + 32.0;
    }

    private void convertFarenheitToKelvin(){
        logger.debug("Temp convertfarenheittokelvin");

        kelvin = (farenheit - 32)*5/9 + 273.15;}


}
