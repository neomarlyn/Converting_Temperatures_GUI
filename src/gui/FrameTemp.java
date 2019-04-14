package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import org.apache.logging.log4j.*;


public class FrameTemp extends JFrame {
    Logger logger = LogManager.getLogger(FrameTemp.class);

    private PanelTempInput pnlInput;
    private PanelTempOutput pnlOutput;

    public FrameTemp(){
        logger.debug("inside FrameTemp constructor");

        this.setSize(1200,400);
        pnlInput = new PanelTempInput();
        pnlOutput = new PanelTempOutput();

        pnlInput.setOutputPanelReference(pnlOutput);

        add(pnlInput, BorderLayout.WEST);
        add(pnlOutput, BorderLayout.EAST);
        this.setLayout(new GridLayout(1,2));
    }
}
