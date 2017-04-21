package kata7.control;

import kata7.model.Histogram;
import kata7.view.AttributeDialog;
import kata7.view.PopulationDialog;
import kata7.view.HistogramBuilder;
import kata7.view.HistogramDisplay;

public class CalculateCommand implements Command {
    private final AttributeDialog attributeDialog;
    private final PopulationDialog populationDialog;
    private final HistogramDisplay display;

    public CalculateCommand(AttributeDialog attributeDialog, PopulationDialog populationDialog, HistogramDisplay display) {
        this.attributeDialog = attributeDialog;
        this.populationDialog = populationDialog;
        this.display = display;
    }

    @Override
    public void execute() {
        Histogram hm = new HistogramBuilder(populationDialog.population()).build(attributeDialog.attribute());
        display.show(hm);
    }
}
