package work;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.TitledPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Diagrams_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    // region FXML
    @FXML
    private TitledPane dimension_1_BOX;

    @FXML // к-во клиентов в городах
    private PieChart dimension_1_DIAGRAM;

    @FXML
    private TitledPane dimension_2_BOX;

    @FXML // зависимость средней стоимости тарифа от типа оплаты
    private LineChart<String, Double> dimension_2_DIAGRAM;

    @FXML
    private CategoryAxis dimension_2_CATEGORY;

    @FXML
    private NumberAxis dimension_2_NUMBER;

    @FXML // связь клиентов, их счетов и количества проведённых по ним фин. операций
    private TitledPane dimension_3_BOX;

    @FXML
    private StackedBarChart<String, Double> dimension_3_DIAGRAM;

    @FXML
    private CategoryAxis dimension_3_CATEGORY;

    @FXML
    private NumberAxis dimension_3_NUMBER;
    // endregion

    // region CODE
    // common FUNCTIONS
    public void callDiagram(String diagramType)
    {
        switch (diagramType)
        {
            case "dimension_1" -> show_dimension_1_DIAGRAM();
            case "dimension_2" -> show_dimension_2_DIAGRAM();
            case "dimension_3" -> show_dimension_3_DIAGRAM();
        }
    }

    private void show_dimension_1_DIAGRAM()
    {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        try {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery("""
                    SELECT COUNT(c.id), ci.name FROM clients AS c
                    INNER JOIN client_cities AS ci ON ci.id = c.id_city
                    GROUP BY ci.name ORDER BY 1
                    """);
            while (AppCore.resultSet.next()) {
                data.add(new PieChart.Data(
                        AppCore.resultSet.getString(2).trim(),
                        Double.parseDouble(AppCore.resultSet.getString(1).trim())
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        dimension_1_DIAGRAM.setData(data);

        dimension_1_BOX.toFront();
        dimension_1_BOX.setText("Диаграмма, отражающая к-во клиентов в городах");
    }
    private void show_dimension_2_DIAGRAM()
    {
        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();
        try {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery("""
                    SELECT ROUND(AVG(t.cost::numeric), 2), ch.name FROM tariffs AS t
                    INNER JOIN charge_types AS ch ON ch.id = t.id_charge_type
                    GROUP BY ch.name ORDER BY 2
                    """);
            while (AppCore.resultSet.next()) {
                XYChart.Series<String, Double> data_part = new XYChart.Series<>();
                data_part.getData().add(new XYChart.Data<>(
                        AppCore.resultSet.getString(2).trim(),
                        Double.parseDouble(AppCore.resultSet.getString(1).trim())
                ));
                data.add(data_part);
            }
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        dimension_2_DIAGRAM.setData(data);

        dimension_2_BOX.toFront();
        dimension_2_BOX.setText("Диаграмма, отражающая зависимость средней стоимости тарифа от типа оплаты");
    }
    private void show_dimension_3_DIAGRAM()
    {
        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();
        try {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery("""
                    SELECT COUNT(f.id), b.id, c.name FROM financial_operations AS f
                    INNER JOIN bills AS b ON b.id = f.id_bill
                    INNER JOIN clients AS c ON c.id = b.id_client
                    GROUP BY b.id, c.name ORDER BY 3, 1, 2
                    """);
            XYChart.Series<String, Double> data_holder = new XYChart.Series<>();
            String client = ""; int counter = 1;
            while (AppCore.resultSet.next()) {
                if (!client.equals(AppCore.resultSet.getString(3)))
                {
                    if (!data_holder.getData().isEmpty())
                    {
                        data.add(data_holder);
                        data_holder = new XYChart.Series<>();
                    }
                    counter = 1;
                    client = AppCore.resultSet.getString(3);
                    data_holder.setName(client);
                }
                data_holder.getData().add(new XYChart.Data<>(
                        counter + "-й счёт",
                        Double.parseDouble(AppCore.resultSet.getString(1).trim())
                ));
                counter++;
            }
            data.add(data_holder);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        dimension_3_DIAGRAM.setData(data);

        dimension_3_BOX.toFront();
        dimension_3_BOX.setText("Диаграмма, отражающая связь клиентов, их счетов и количества проведённых по ним фин. операций");
    }

    // for FXML CODE
    @FXML
    void initialize() { AppCore.diagramsController = this; }
    // endregion
}