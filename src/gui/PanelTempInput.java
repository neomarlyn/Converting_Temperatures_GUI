package gui;
import org.apache.logging.log4j.*;

import domain.Temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTempInput extends JPanel implements ActionListener {
    Logger logger = LogManager.getLogger(PanelTempInput.class);

    private JDataInput datTemperature;
    private JComboBox<Temperature.Scale> cboScale;
    private JButton btnSubmit;

    private PanelTempOutput refOutputPanel;
    public void setOutputPanelReference(PanelTempOutput outputPanel){
        logger.debug("inside paneltempinput setoutputpanelreference");


        this.refOutputPanel = outputPanel;
    }

    public PanelTempInput(){
        logger.debug("inside paneltempinput constructor");

        datTemperature = new JDataInput("Enter temperature value:");
        btnSubmit = new JButton("Submit");
        btnSubmit.setActionCommand("Submit");


        btnSubmit.addActionListener(this);

        btnSubmit.addActionListener(new ClickHandler());

        //either the panel itself traps the events
        //or our custom handler class traps the events

        cboScale = new JComboBox<Temperature.Scale>();
        cboScale.addItem(Temperature.Scale.Kelvin);
        cboScale.addItem(Temperature.Scale.Celsius);
        cboScale.addItem(Temperature.Scale.Farenheit);

        //have individual PANELS act as "rows" for neat output layout
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();

        //add each widget to its own "row panel"
        row1.add(cboScale);
        row2.add(datTemperature);
        row3.add(btnSubmit);
        //have each "row panel" appear vertically down a NEW GRID layout
        this.setLayout(new GridLayout(3,1));


        // actually add the row panels to the enclosing panel
        add(row1);
        add(row2);
        add(row3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("HEY!! The panel caught this !!!");


        try {
            System.out.println(datTemperature.getDoubleValue());

            Temperature.Scale inputScale = (Temperature.Scale) cboScale.getSelectedItem();
            double inputTemp = datTemperature.getDoubleValue();

            Temperature myTemp = new Temperature(inputScale, inputTemp);
            //need to be able to call a method on an instance of the output panel
            refOutputPanel.DisplayTextInTextArea(myTemp.toString());
        }catch(Exception ex){

        }

    }

    private class ClickHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("HEY!! The custom button click handler thingy caught this !!!");
            try{
                System.out.println(datTemperature.getDoubleValue());
            }catch(Exception ex){

            }
        }
    }
}
