package work;

import java.util.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppCore extends Application
{
    public static Main_Controller mainController;
    public static Authorization_Controller authorizationController;
    public static Queries_Controller queriesController;
    public static Diagrams_Controller diagramsController;

    public static Dictionary<String, Stage> stages = new Hashtable<>();
    public static String login_password = "";

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    //Functions
    public static void showAlert(String alertMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setContentText(alertMessage);
        alert.show();

        Thread thread = new Thread(() -> {
            try
            {
                Thread.sleep(3000);
                if (alert.isShowing())
                    Platform.runLater(alert::close);
            } catch (Exception exp) { exp.printStackTrace(); }
        });
        thread.setDaemon(true); thread.start();
    }

    public static void setConnection()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/PracticeDB", "A.T.A.N", "123");
            connection.setAutoCommit(false);
            System.out.println("-- DB opening successful");
        }
        catch (Exception e) { e.printStackTrace(); System.exit(0); }
    }

    public static void createEndDaemon()
    {
        Thread thread = new Thread(() -> {
            while(true)
            {
                if (Thread.currentThread().isInterrupted())
                {
                    try  { resultSet.close(); statement.close(); connection.commit(); connection.close(); }
                    catch (Exception e) { e.printStackTrace(); System.exit(0); }
                }
            }
        });
        thread.setDaemon(true); thread.start();
    }

    @Override
    public void start(Stage mainForm) throws Exception
    {
        setConnection();
        createEndDaemon();

        // Main form load
        Parent root = FXMLLoader.load(getClass().getResource("Main_Form.fxml"));
        mainForm.setTitle("База данных \"Оператор связи\"");
        mainForm.setScene(new Scene(root, 1000, 600));
        mainForm.setResizable(false);
        stages.put("Main", mainForm);

        // Queries form load
        root = FXMLLoader.load(getClass().getResource("Queries_Form.fxml"));
        Stage queriesForm = new Stage();
        queriesForm.setTitle("Результаты специализированного запроса");
        queriesForm.setScene(new Scene(root, 800, 600));
        queriesForm.setResizable(false);
        stages.put("Queries", queriesForm);

        // Queries form load
        root = FXMLLoader.load(getClass().getResource("Diagrams_Form.fxml"));
        Stage diagramsForm = new Stage();
        diagramsForm.setTitle("Диаграмма");
        diagramsForm.setScene(new Scene(root, 800, 600));
        diagramsForm.setResizable(false);
        stages.put("Diagrams", diagramsForm);

        // Authorization form load
        root = FXMLLoader.load(getClass().getResource("Authorization_Form.fxml"));
        Stage authorizationForm = new Stage();
        authorizationForm.setTitle("Авторизация");
        authorizationForm.setScene(new Scene(root, 450, 300));
        authorizationForm.setResizable(false);
        stages.put("Authorization", authorizationForm);

        stages.get("Authorization").show();
    }

    public static void main(String[] args) { launch(args); }
}
