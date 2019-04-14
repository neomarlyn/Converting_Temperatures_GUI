package domain;

import org.junit.Assert;
import org.junit.Test;

public class TestTemperature {

    /*private void convertKelvinToCelsius(){ celsius = kelvin - 273.15; }

    private void convertCelsiusToFarenheit(){
        farenheit = celsius * 9.0/5.0 + 32.0;
    }

    private void convertFarenheitToKelvin(){kelvin = (farenheit - 32)*5/9 + 273.15;}
    */

    @Test
    public void TestTemperatureKelvin() throws TemperatureException {
        Temperature t = new Temperature(0);
        Assert.assertEquals(0.0, t.getKelvin(), 0.5);
        //Assert.assertEquals(0.0, wc.getWeightInPounds(), 0.000001);

    }

    @Test
    public void TestTemperatureCelsius() throws TemperatureException{
        Temperature t = new Temperature(0);
        Assert.assertEquals(-273.15, t.getCelsius(), 0.5);
    }

    @Test
    public void TestTemperatureFarenheit() throws TemperatureException {
        Temperature t = new Temperature(0);
        Assert.assertEquals(-459.4, t.getFarenheit(), 0.5);
    }

    @Test
    public void TestTemperatureConstructor() throws TemperatureException{
        Temperature t = new Temperature(0);
        Assert.assertEquals(0.0, t.getKelvin(), .5);
    }
}
