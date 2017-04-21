package kata7.application.swing;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import kata7.view.HistogramDisplay;
import kata7.model.Histogram;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class HistogramPanel extends JPanel implements HistogramDisplay {
    private Histogram<String> hm;

    public HistogramPanel() {
        super(new BorderLayout());
    }

    @Override
    public Histogram histogram() {
        return this.hm;
    }

    @Override
    public void show(Histogram hm) {
        this.hm = hm;
        this.reload();
    }

    private JFreeChart createChart(DefaultCategoryDataset dt) {
        JFreeChart chart = ChartFactory.createBarChart(null, "", "NÚMERO", dt, PlotOrientation.VERTICAL, false, false, false);
        return chart;
    }
    
    private void reload() {
        this.removeAll();
        this.add(new ChartPanel(createChart(createDataset(this.hm))));
        this.revalidate();
    }

    private DefaultCategoryDataset createDataset(Histogram hm) {
        DefaultCategoryDataset dt = new DefaultCategoryDataset();
        for (Object key : hm.keySet()) {
            dataSet.addValue(hm.get(key), "", (Comparable) key);
        }
        return dt;
    }
}
