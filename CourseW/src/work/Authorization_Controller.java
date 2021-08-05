package work;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Authorization_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //==================================================

    @FXML
    private TextField login_FIELD;

    @FXML
    private PasswordField password_FIELD;

    @FXML
    private Button authorize_BTN;

    @FXML
    private Button close_BTN;

    @FXML
    void initialize()
    {
        AppCore.authorizationController = this;

        // BTNs actions
        authorize_BTN.setOnAction(event ->
        {
            if (login_FIELD.getText().equals("admin") && password_FIELD.getText().equals("password"))
            {
                AppCore.login_password = "admin_password";
                AppCore.stages.get("Authorization").hide();
                AppCore.stages.get("Main").show();
            }
            else { AppCore.showAlert("Неверные логин и/или пароль\nПожалуйста, попробуйте ещё раз"); }
        });

        close_BTN.setOnAction(event -> Platform.exit());
    }
}