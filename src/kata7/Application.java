package kata7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import kata7.control.Command;
import kata7.view.AttributeDialog;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import kata7.view.HistogramDisplay;
import kata7.view.PopulationDialog;
import kata7.application.swing.Toolbar;
import kata7.application.swing.HistogramPanel;
import kata7.control.CalculateCommand;

public class Application extends JFrame {
    private Map<String, Command> commands = new HashMap<>();
    private PopulationDialog populationDialog;
    private AttributeDialog attributeDialog;
    private HistogramDisplay histogramDisplay;

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    public Application() {
        this.createCommands();
        this.deployUI();
    }

    private void deployUI() {
        this.setTitle("Histogram Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(histogramPanel());
        this.getContentPane().add(toolbar(commands), BorderLayout.NORTH);
    }

    private HistogramPanel histogramPanel() {
        HistogramPanel hPanel = new HistogramPanel();
        this.histogramDisplay = hPanel;
        return hPanel;
    }

    private JPanel toolbar(Map<String, Command> commands) {
        Toolbar tPanel = new Toolbar(this.commands);
        this.attributeDialog = tPanel;
        this.populationDialog = tPanel;
        return tPanel;
    }
    
    private void createCommands() {
        this.commands.put("calculate", new CalculateCommand(attributeDialog, populationDialog, histogramDisplay));
    }
}
