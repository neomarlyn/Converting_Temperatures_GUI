package main;

import gui.FrameTemp;

import javax.swing.*;
import org.apache.logging.log4j.*;
public class DriverTemp {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(DriverTemp.class);
        logger.debug("INSIDE DRIVER MAIN !!!");

        FrameTemp frmApp = new FrameTemp();
        frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frmApp.setSize(800,400);
        frmApp.setVisible(true);



        /*try {
            Temperature lenexa = new Temperature(Temperature.Scale.Celsius, 100.0);
            System.out.println(lenexa.toString());
        }
        catch(TemperatureException tex){
            System.out.println(tex.toString());
        }*/



    }


}
