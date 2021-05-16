package fitnessTracker2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Simple Controller class for graph.fxml. Mainly handles drawing a simple graph.
 */
public class GraphFxmlController implements Initializable {

    /**
     * The chart itself.
     */
    @FXML
    public LineChart<String, Number> calorieBurnedLineChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        XYChart.Series<String, Number> series1 = new XYChart.Series<>();

        series1.setName("Calories Burned by session");

        for (int i = 1; i < ExerciseSessionWrapper.exerciseSessionArrayList.size(); i++)
        {
            series1.getData().add(new XYChart.Data<>(
                    ExerciseSessionWrapper.exerciseSessionArrayList.get(i).getCode().toString(),
                    ExerciseSessionWrapper.exerciseSessionArrayList.get(i).getBurnedCalories()
            ));
        }

        calorieBurnedLineChart.getData().add(series1);
    }
}
