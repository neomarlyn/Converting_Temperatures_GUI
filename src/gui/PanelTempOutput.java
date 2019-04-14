package gui;
import org.apache.logging.log4j.*;

import javax.swing.*;
import java.awt.*;

public class PanelTempOutput extends JPanel {
    Logger logger = LogManager.getLogger(PanelTempOutput.class);

    private JTextArea taOutput;

    public PanelTempOutput()
    {
        logger.debug("inside PanelTempOutput constructor");

        this.setLayout(new GridLayout(1,1));

        taOutput = new JTextArea(15, 60);
        taOutput.setAutoscrolls(true);
        //taOutput.setPreferredSize(new Dimension(400,300));
        //taOutput.setSize(300, 400);
        //taOutput.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(taOutput);

    }

    public void DisplayTextInTextArea(String data){
        logger.debug("inside PanelTempOutput displaytextintextarea");

        taOutput.append(data + "\n");
    }

}
