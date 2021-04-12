package fitnessTracker2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphFxmlController implements Initializable {

    @FXML
    public LineChart<String, Number> calorieBurnedLineChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        XYChart.Series<String, Number> series1 = new XYChart.Series<>();

        series1.setName("Series 1");

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
