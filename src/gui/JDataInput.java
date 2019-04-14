package gui;
import org.apache.logging.log4j.*;

import javax.swing.*;
import java.awt.*;

public class JDataInput extends JPanel {
    Logger logger = LogManager.getLogger(JDataInput.class);

    private JLabel lblInput;
    private JTextField txtInput;
    private JLabel lblMessage;

    public JDataInput(){

    }

    public JDataInput(String caption){
        logger.debug("JDataInput constructor");

        lblInput = new JLabel(caption);
            txtInput = new JTextField(20);
            lblMessage = new JLabel("");

            JPanel row1 = new JPanel();
            JPanel row2 = new JPanel();

            row1.add(lblInput);
            row1.add(txtInput);
            row2.add(lblMessage);

            this.setLayout(new GridLayout(2,1));
            this.add(row1);
            this.add(row2);
    }

    public double getDoubleValue() {
        logger.debug("JDataInput getdoublevalue");


        double returnValue = 0.00;
        lblMessage.setText("");
        try {
            returnValue = Double.parseDouble(txtInput.getText());
        }catch(NumberFormatException nfex){
            lblMessage.setForeground(Color.RED);
            lblMessage.setText(nfex.toString());
            throw nfex;
        }


        return returnValue;
    }
    public int getIntValue() {
        logger.debug("JDataInput getintvalue");


        int returnValue = 0;
        lblMessage.setText("");
        try {
            returnValue = Integer.parseInt(txtInput.getText());
        }catch(NumberFormatException nfex){
            lblMessage.setForeground(Color.RED);
            lblMessage.setText(nfex.toString());
            throw nfex;
        }


        return returnValue;
    }

    public String getStringValue(){
        logger.debug("JDataInput getstringvalue");

        lblMessage.setText("");
        return txtInput.getText();
    }

    public void setMessage(String in){
        logger.debug("JDataInput setmessage");

        lblMessage.setForeground(Color.RED);
        lblMessage.setText(in);
    }
}
