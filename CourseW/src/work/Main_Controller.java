package work;

import DBTables.*;

import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main_Controller
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

// region FXML segment
    @FXML
    private Pane titleText_BOX;

    @FXML
    private VBox show_BOX;

    @FXML
    private StackPane forms_BOX;

    @FXML
    private TitledPane techInfF_BOX;

    @FXML
    private TextField drSR_TechInfF_FIELD;

    @FXML
    private TextField serverID_TechInfF_FIELD;

    @FXML
    private TextField portSAP_TechInfF_FIELD;

    @FXML
    private TextField speed_TechInfF_FIELD;

    @FXML
    private TextField ip_TechInfF_FIELD;

    @FXML
    private TextField scheme_TechInfF_FIELD;

    @FXML
    private TextField pm_TechInfF_FIELD;

    @FXML
    private Button use_TechInfF_BTN;

    @FXML
    private Button prev_TechInfF_BTN;

    @FXML
    private TextField cur_TechInfF_FIELD;

    @FXML
    private Button next_TechInfF_BTN;

    @FXML
    private Button cancel_TechInfF_BTN;

    @FXML
    private TitledPane clientsF_BOX;

    @FXML
    private TextField name_ClientsF_FIELD;

    @FXML
    private ComboBox<String> techInf_ClientsF_CHOICE;

    @FXML
    private ComboBox<String> city_ClientsF_CHOICE;

    @FXML
    private TextField address_ClientsF_FIELD;

    @FXML
    private TextArea contactInf_ClientsF_FIELD;

    @FXML
    private Button use_ClientsF_BTN;

    @FXML
    private Button prev_ClientsF_BTN;

    @FXML
    private TextField cur_ClientsF_FIELD;

    @FXML
    private Button next_ClientsF_BTN;

    @FXML
    private Button cancel_ClientsF_BTN;

    @FXML
    private TitledPane finOpsF_BOX;

    @FXML
    private ComboBox<String> bill_FinOpsF_CHOICE;

    @FXML
    private ComboBox<String> transactionType_FinOpsF_CHOICE;

    @FXML
    private TextField sum_FinOpsF_FIELD;

    @FXML
    private TextField operationDate_FinOpsF_FIELD;

    @FXML
    private ComboBox<String> contractPart_FinOpsF_CHOICE;

    @FXML
    private TextArea comment_FinOpsF_FIELD;

    @FXML
    private Button use_FinOpsF_BTN;

    @FXML
    private Button prev_FinOpsF_BTN;

    @FXML
    private TextField cur_FinOpsF_FIELD;

    @FXML
    private Button next_FinOpsF_BTN;

    @FXML
    private Button cancel_FinOpsF_BTN;

    @FXML
    private TitledPane contractsF_BOX;

    @FXML
    private TextField name_ContractsF_FIELD;

    @FXML
    private ComboBox<String> client_ContractsF_CHOICE;

    @FXML
    private TextField preparationDate_ContractsF_FIELD;

    @FXML
    private TextField startDate_ContractsF_FIELD;

    @FXML
    private ComboBox<String> status_ContractsF_CHOICE;

    @FXML
    private TextField endDate_ContractsF_FIELD;

    @FXML
    private Button use_ContractsF_BTN;

    @FXML
    private Button prev_ContractsF_BTN;

    @FXML
    private TextField cur_ContractsF_FIELD;

    @FXML
    private Button next_ContractsF_BTN;

    @FXML
    private Button cancel_ContractsF_BTN;

    @FXML
    private StackPane tables_BOX;

    @FXML
    private TitledPane techInfT_BOX;

    @FXML
    private TableView<FullTableRow> techInf_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> drSR_TechInfT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> serverID_TechInfT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> portSAP_TechInfT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> speed_TechInfT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> ip_TechInfT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> scheme_TechInfT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> pm_TechInfT_COLUMN;

    @FXML
    private TitledPane commonCatalogT_BOX;

    @FXML
    private TableView<FullTableRow> commonCatalog_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> name_CommonCatalogT_COLUMN;

    @FXML
    private TitledPane clientsT_BOX;

    @FXML
    private TableView<FullTableRow> clients_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> name_ClientsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> serverID_ClientsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> portSAP_ClientsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> speed_ClientsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> city_ClientsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> address_ClientsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> contactInf_ClientsT_COLUMN;

    @FXML
    private TitledPane finOpsT_BOX;

    @FXML
    private TableView<FullTableRow> finOps_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> client_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> balance_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> transactionType_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> sum_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> operationDate_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> contract_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> tariff_FinOpsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> comment_FinOpsT_COLUMN;

    @FXML
    private TitledPane contractPartsT_BOX;

    @FXML
    private TableView<FullTableRow> contractParts_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> contract_ContractPartsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> tariff_ContractPartsT_COLUMN;

    @FXML
    private TitledPane billsT_BOX;

    @FXML
    private TableView<FullTableRow> bills_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> client_BillsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> balance_BillsT_COLUMN;

    @FXML
    private TitledPane tariffsT_BOX;

    @FXML
    private TableView<FullTableRow> tariffs_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> name_TariffsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> service_TariffsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> chargeType_TariffsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> cost_TariffsT_COLUMN;

    @FXML
    private TitledPane contractsT_BOX;

    @FXML
    private TableView<FullTableRow> contracts_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> name_ContractsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> client_ContractsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> preparationDate_ContractsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> startDate_ContractsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> status_ContractsT_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> endDate_ContractsT_COLUMN;

    @FXML
    private Label recordsCounter_FIELD;

    @FXML
    private Button toMain_BTN;

    @FXML
    private Button generation_BTN;

    @FXML
    private SplitPane menu_BOX;

    @FXML
    private Button transactionTypes_BTN;

    @FXML
    private Button services_BTN;

    @FXML
    private Button paymentTypes_BTN;

    @FXML
    private Button tariffs_BTN;

    @FXML
    private Button contractStatuses_BTN;

    @FXML
    private Button clientCities_BTN;

    @FXML
    private Button finOps_BTN;

    @FXML
    private Button clients_BTN;

    @FXML
    private Button contractParts_BTN;

    @FXML
    private Button contracts_BTN;

    @FXML
    private Button techInf_BTN;

    @FXML
    private Button bills_BTN;

    @FXML
    private Button INNER_WHERE_FK_Tariffs_BTN;

    @FXML
    private Button INNER_WHERE_FK_Contracts_BTN;

    @FXML
    private Button INNER_WHERE_DATE_FinOps_BTN;

    @FXML
    private Button INNER_WHERE_DATE_Contracts_BTN;

    @FXML
    private Button INNER_no_WHERE_Clients_BTN;

    @FXML
    private Button INNER_no_WHERE_Tariffs_BTN;

    @FXML
    private Button INNER_no_WHERE_ContractParts_BTN;

    @FXML
    private Button LEFT_OUTER_BTN;

    @FXML
    private Button RIGHT_OUTER_BTN;

    @FXML
    private Button SELECT_$_FROM_SELECT_BTN;

    @FXML
    private Button AGGREGATE_no_WHERE_BTN;

    @FXML
    private Button AGGREGATE_WHERE_BTN;

    @FXML
    private Button AGGREGATE_HAVING_BTN;

    @FXML
    private Button AGGREGATE_WHERE_HAVING_BTN;

    @FXML
    private Button AGGREGATE_$_FROM_SELECT_BTN;

    @FXML
    private Button SELECT_$_WHERE_SELECT_BTN;

    @FXML
    private Button SPECIAL_QR_1_BTN;

    @FXML
    private Button SPECIAL_QR_2_BTN;

    @FXML
    private Button SPECIAL_QR_3_BTN;

    @FXML
    private Button dimension_1_BTN;

    @FXML
    private Button dimension_2_BTN;

    @FXML
    private Button dimension_3_BTN;

    @FXML
    private ScrollPane subMenu_BOX;

    @FXML
    private Button handAdd_BTN;

    @FXML
    private Button fieldsChange_BTN;

    @FXML
    private Button choseChange_BTN;

    @FXML
    private Button fieldsDelete_BTN;

    @FXML
    private Button choseDelete_BTN;

    @FXML
    private Button searchRows_BTN;

    @FXML
    private TitledPane showType_BOX;

    @FXML
    private ToggleButton tableShowType_BTN;

    @FXML
    private ToggleGroup dataShowing;

    @FXML
    private ToggleButton recordsShowType_BTN;

    @FXML
    private Button quitAccount_BTN;

    @FXML
    private Button quitApp_BTN;
// endregion

// region CODE segment
    // VARIABLES
    private String curTable;
    private ArrayList<ArrayList<String>> records;
    private int recordsCount;
    private String actionType;

    private int curRecord;
    private boolean curRecord_changed = false;

    // FUNCTIONS
    private void show_Base_Easier(String query, String boxTitle)
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(query);
            recordsCount = 0;
            while (AppCore.resultSet.next()) {
                FullTableRow row = new FullTableRow();
                row.setField_01(AppCore.resultSet.getString(1).trim());
                rows.add(row);
                recordsCount++;
            }
            recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            AppCore.resultSet.close();
            AppCore.statement.close();
            AppCore.connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        name_CommonCatalogT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_01"));
        commonCatalog_TABLE.setItems(rows);

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(true);

        show_BOX.toFront();
        tables_BOX.toFront();
        commonCatalogT_BOX.toFront();
        commonCatalogT_BOX.setText(boxTitle);
    }
    private void show_CommonCatalog(String tableName)
    {
        showType_BOX.setDisable(true);
        fieldsChange_BTN.setDisable(true);
        fieldsDelete_BTN.setDisable(true);
        choseChange_BTN.setDisable(false);
        choseDelete_BTN.setDisable(false);
        switch (tableName)
        {
            case "contract_parts" -> {
                ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
                try {
                    AppCore.statement = AppCore.connection.createStatement();
                    AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_CONTRACT_PARTS);
                    recordsCount = 0;
                    while (AppCore.resultSet.next()) {
                        FullTableRow row = new FullTableRow();
                        row.setField_01(AppCore.resultSet.getString(1).trim());
                        row.setField_02(AppCore.resultSet.getString(2).trim());
                        rows.add(row);
                        recordsCount++;
                    }
                    recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    AppCore.resultSet.close();
                    AppCore.statement.close();
                    AppCore.connection.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                contract_ContractPartsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_01"));
                tariff_ContractPartsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_02"));
                contractParts_TABLE.setItems(rows);

                toMain_BTN.setDisable(false);
                subMenu_BOX.setVisible(true);

                show_BOX.toFront();
                tables_BOX.toFront();
                contractPartsT_BOX.toFront();
            }
            case "bills" -> {
                ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
                try {
                    AppCore.statement = AppCore.connection.createStatement();
                    AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_BILLS);
                    recordsCount = 0;
                    while (AppCore.resultSet.next()) {
                        FullTableRow row = new FullTableRow();
                        row.setField_01(AppCore.resultSet.getString(1).trim());
                        row.setField_02(AppCore.resultSet.getString(2).trim());
                        rows.add(row);
                        recordsCount++;
                    }
                    recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    AppCore.resultSet.close();
                    AppCore.statement.close();
                    AppCore.connection.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                client_BillsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_01"));
                balance_BillsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_02"));
                bills_TABLE.setItems(rows);

                toMain_BTN.setDisable(false);
                subMenu_BOX.setVisible(true);

                show_BOX.toFront();
                tables_BOX.toFront();
                billsT_BOX.toFront();
            }
            case "tariffs" -> {
                ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
                try {
                    AppCore.statement = AppCore.connection.createStatement();
                    AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_TARIFFS);
                    recordsCount = 0;
                    while (AppCore.resultSet.next()) {
                        FullTableRow row = new FullTableRow();
                        row.setField_01(AppCore.resultSet.getString(1).trim());
                        row.setField_02(AppCore.resultSet.getString(2).trim());
                        row.setField_03(AppCore.resultSet.getString(3).trim());
                        row.setField_04(AppCore.resultSet.getString(4).trim());
                        rows.add(row);
                        recordsCount++;
                    }
                    recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    AppCore.resultSet.close();
                    AppCore.statement.close();
                    AppCore.connection.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                name_TariffsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_01"));
                service_TariffsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_02"));
                chargeType_TariffsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_03"));
                cost_TariffsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_04"));
                tariffs_TABLE.setItems(rows);

                toMain_BTN.setDisable(false);
                subMenu_BOX.setVisible(true);

                show_BOX.toFront();
                tables_BOX.toFront();
                tariffsT_BOX.toFront();
            }
            // easier
            case "client_cities" -> show_Base_Easier(QrsCommonCatalogs.SELECT_CLIENT_CITIES, "Таблица ГОРОДА КЛИЕНТОВ");
            case "transaction_types" -> show_Base_Easier(QrsCommonCatalogs.SELECT_TRANSACTION_TYPES, "Таблица ТИПЫ ТРАНЗАКЦИЙ");
            case "services" -> show_Base_Easier(QrsCommonCatalogs.SELECT_SERVICES, "Таблица УСЛУГИ");
            case "charge_types" -> show_Base_Easier(QrsCommonCatalogs.SELECT_CHARGE_TYPES, "Таблица ТИПЫ ОПЛАТЫ");
            case "contract_statuses" -> show_Base_Easier(QrsCommonCatalogs.SELECT_CONTRACT_STATUSES, "Таблица СТАТУСЫ КОНТРАКТОВ");
        }
    }

// region HARD
    // Clients =====================================
    private void use_Record_ClientsF(String alert_msg, String action_type)
    {
        AppCore.showAlert(alert_msg);

        name_ClientsF_FIELD.setEditable(true); name_ClientsF_FIELD.setText("");
        techInf_ClientsF_CHOICE.setEditable(true);
        city_ClientsF_CHOICE.setEditable(true);
        address_ClientsF_FIELD.setEditable(true); address_ClientsF_FIELD.setText("");
        contactInf_ClientsF_FIELD.setEditable(true); contactInf_ClientsF_FIELD.setText("");

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsTechInf.SELECT_4CLIENTS);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            "[" + AppCore.resultSet.getString(1).trim() + "] " +
                                    "Серв.ID: " + AppCore.resultSet.getString(2).trim() + "; " +
                                    "Port/sap: " + AppCore.resultSet.getString(3).trim() + "; " +
                                    "Скорость: " + AppCore.resultSet.getString(4).trim()
                    );
                }
                techInf_ClientsF_CHOICE.setItems(items);
                techInf_ClientsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_CLIENT_CITIES);
                while (AppCore.resultSet.next())
                { items.add(AppCore.resultSet.getString(1).trim()); }
                city_ClientsF_CHOICE.setItems(items);
                city_ClientsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        use_ClientsF_BTN.setVisible(true);
        prev_ClientsF_BTN.setVisible(false);
        cur_ClientsF_FIELD.setVisible(false);
        next_ClientsF_BTN.setVisible(false);
        cancel_ClientsF_BTN.setVisible(true);

        actionType = action_type;

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        clientsF_BOX.toFront();
    }

    // show
    private void show_Clients(String showType)
    {
        showType_BOX.setDisable(false);
        fieldsChange_BTN.setDisable(false);
        fieldsDelete_BTN.setDisable(false);
        choseChange_BTN.setDisable(true);
        choseDelete_BTN.setDisable(true);
        if (showType.equals("asTable"))
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsClients.SELECT_TABLE);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    row.setField_03(AppCore.resultSet.getString(3).trim());
                    row.setField_04(AppCore.resultSet.getString(4).trim());
                    row.setField_05(AppCore.resultSet.getString(5).trim());
                    row.setField_06(AppCore.resultSet.getString(6).trim());
                    row.setField_07(AppCore.resultSet.getString(7).trim());
                    rows.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            name_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>      ("field_01"));
            serverID_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>  ("field_02"));
            portSAP_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>   ("field_03"));
            speed_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>     ("field_04"));
            city_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>      ("field_05"));
            address_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>   ("field_06"));
            contactInf_ClientsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_07"));
            clients_TABLE.setItems(rows);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(true);
            recordsShowType_BTN.setSelected(false);

            show_BOX.toFront();
            tables_BOX.toFront();
            clientsT_BOX.toFront();
        }
        else if (showType.equals("byRecords"))
        {
            records = new ArrayList<>();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsClients.SELECT_TABLE);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    ArrayList<String> row = new ArrayList<>();
                    row.add(AppCore.resultSet.getString(1).trim());
                    row.add(
                        "[" + AppCore.resultSet.getString(8).trim() + "] " +
                        "Серв.ID: " + AppCore.resultSet.getString(2).trim() + "; " +
                        "Port/sap: " + AppCore.resultSet.getString(3).trim() + "; " +
                        "Скорость: " + AppCore.resultSet.getString(4).trim()
                    );
                    row.add(AppCore.resultSet.getString(5).trim());
                    row.add(AppCore.resultSet.getString(6).trim());
                    row.add(AppCore.resultSet.getString(7).trim());
                    records.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            curRecord = 1;

            use_ClientsF_BTN.setVisible(false);
            prev_ClientsF_BTN.setVisible(true);
            next_ClientsF_BTN.setVisible(true);

            techInf_ClientsF_CHOICE.setItems(null);
            city_ClientsF_CHOICE.setItems(null);
            showRecord_ClientsF();
            name_ClientsF_FIELD.setEditable(false);
            techInf_ClientsF_CHOICE.setEditable(false);
            city_ClientsF_CHOICE.setEditable(false);
            address_ClientsF_FIELD.setEditable(false);
            contactInf_ClientsF_FIELD.setEditable(false);

            cur_ClientsF_FIELD.setVisible(true);
            cancel_ClientsF_BTN.setVisible(false);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(true);

            show_BOX.toFront();
            forms_BOX.toFront();
            clientsF_BOX.toFront();
        }
    }

    private void showRecord_ClientsF()
    {
        curRecord_changed = false;
        if (records.size() != 0)
        {
            cur_ClientsF_FIELD.setText(curRecord + "/" + records.size());

            name_ClientsF_FIELD.setText(records.get(curRecord - 1).get(0));
            techInf_ClientsF_CHOICE.setValue(records.get(curRecord - 1).get(1));
            city_ClientsF_CHOICE.setValue(records.get(curRecord - 1).get(2));
            address_ClientsF_FIELD.setText(records.get(curRecord - 1).get(3));
            contactInf_ClientsF_FIELD.setText(records.get(curRecord - 1).get(4));
        }
        else
        {
            cur_ClientsF_FIELD.setText("0/0");

            name_ClientsF_FIELD.setText("");
            techInf_ClientsF_CHOICE.setValue(null);
            city_ClientsF_CHOICE.setValue(null);
            address_ClientsF_FIELD.setText("");
            contactInf_ClientsF_FIELD.setText("");

            use_ClientsF_BTN.setVisible(false);
            prev_ClientsF_BTN.setVisible(false);
            next_ClientsF_BTN.setVisible(false);
        }
    }

    // wherePart
    private String getWherePart_ClientsF()
    {
        StringBuilder wherePart = new StringBuilder();

        if (!name_ClientsF_FIELD.getText().equals(""))
            wherePart.append(" AND cl.name = '").append(name_ClientsF_FIELD.getText()).append("'");
        if (techInf_ClientsF_CHOICE.getValue() != null)
        {
            String tempStr = techInf_ClientsF_CHOICE.getValue();
            wherePart.append(" AND cl.id_technical_information = ")
                    .append(tempStr, tempStr.indexOf('[') + 1, tempStr.indexOf(']'));
        }
        if (city_ClientsF_CHOICE.getValue() != null)
            wherePart.append(" AND cl.id_city = (SELECT id FROM client_cities WHERE name = '")
                    .append(city_ClientsF_CHOICE.getValue()).append("')");
        if (!address_ClientsF_FIELD.getText().equals(""))
            wherePart.append(" AND cl.address = '").append(address_ClientsF_FIELD.getText()).append("'");
        if (!contactInf_ClientsF_FIELD.getText().equals(""))
            wherePart.append(" AND cl.contact_information = '").append(contactInf_ClientsF_FIELD.getText()).append("'");

        return wherePart.toString();
    }

    // search
    private void searchRecord_Clients()
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(String.format(QrsClients.SELECT_2CHANGE, getWherePart_ClientsF()));
            recordsCount = 0;
            while (AppCore.resultSet.next())
            {
                FullTableRow row = new FullTableRow();
                row.setField_01(AppCore.resultSet.getString(1).trim());
                row.setField_02(AppCore.resultSet.getString(2).trim());
                row.setField_03(AppCore.resultSet.getString(3).trim());
                row.setField_04(AppCore.resultSet.getString(4).trim());
                row.setField_05(AppCore.resultSet.getString(5).trim());
                row.setField_06(AppCore.resultSet.getString(6).trim());
                row.setField_07(AppCore.resultSet.getString(7).trim());
                rows.add(row);
                recordsCount++;
            }
            clients_TABLE.setItems(rows);
            recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(true);
        showType_BOX.setDisable(true);
        tableShowType_BTN.setSelected(false);
        recordsShowType_BTN.setSelected(false);

        show_BOX.toFront();
        tables_BOX.toFront();
        clientsT_BOX.toFront();
    }

    // change
    private void changeRecord_ClientsF()
    {
        records = new ArrayList<>();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsClients.SELECT_2CHANGE, getWherePart_ClientsF()));
            while (AppCore.resultSet.next())
            {
                ArrayList<String> row = new ArrayList<>();
                row.add(AppCore.resultSet.getString(1).trim());
                row.add(
                    "[" + AppCore.resultSet.getString(8).trim() + "] " +
                    "Серв.ID: " + AppCore.resultSet.getString(2).trim() + "; " +
                    "Port/sap: " + AppCore.resultSet.getString(3).trim() + "; " +
                    "Скорость: " + AppCore.resultSet.getString(4).trim()
                );
                row.add(AppCore.resultSet.getString(5).trim());
                row.add(AppCore.resultSet.getString(6).trim());
                row.add(AppCore.resultSet.getString(7).trim());
                records.add(row);
            }
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        curRecord = 1;
        actionType = "change";

        AppCore.showAlert("Приступайте к изменениям");

        use_ClientsF_BTN.setVisible(true);
        prev_ClientsF_BTN.setVisible(true);
        next_ClientsF_BTN.setVisible(true);

        showRecord_ClientsF();
        name_ClientsF_FIELD.setEditable(true);
        techInf_ClientsF_CHOICE.setEditable(true);
        city_ClientsF_CHOICE.setEditable(true);
        address_ClientsF_FIELD.setEditable(true);
        contactInf_ClientsF_FIELD.setEditable(true);

        cur_ClientsF_FIELD.setVisible(true);
        cancel_ClientsF_BTN.setVisible(true);

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        clientsF_BOX.toFront();
    }

    // delete
    private void deleteRecord_ClientsF()
    {
        int rowsCount = 0;
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsClients.SELECT_2DELETE, getWherePart_ClientsF()));
            AppCore.resultSet.next();
            rowsCount = AppCore.resultSet.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setContentText("Найдено " + rowsCount +
                " подходящих записей\n\nУдалить все?\n(Также будут удалены все связанные записи)");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
                try {
                    AppCore.statement = AppCore.connection.createStatement();
                    int executeCount = AppCore.statement.executeUpdate(
                            "DELETE FROM clients AS cl WHERE id = id" + getWherePart_ClientsF());
                    recordsCounter_FIELD.setText("Всего записей: " + (recordsCount - rowsCount));
                    AppCore.showAlert("Удалённых записей: " + executeCount);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    AppCore.showAlert("Не удалось провести удаление");
                }
                try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    // Technical information =====================================
    private void use_Record_TechInfF(String alert_msg, String action_type)
    {
        AppCore.showAlert(alert_msg);

        drSR_TechInfF_FIELD.setEditable(true);     drSR_TechInfF_FIELD.    setText("");
        serverID_TechInfF_FIELD.setEditable(true); serverID_TechInfF_FIELD.setText("");
        portSAP_TechInfF_FIELD.setEditable(true);  portSAP_TechInfF_FIELD. setText("");
        speed_TechInfF_FIELD.setEditable(true);    speed_TechInfF_FIELD.   setText("");
        ip_TechInfF_FIELD.setEditable(true);       ip_TechInfF_FIELD.      setText("");
        scheme_TechInfF_FIELD.setEditable(true);   scheme_TechInfF_FIELD.  setText("");
        pm_TechInfF_FIELD.setEditable(true);       pm_TechInfF_FIELD.      setText("");

        use_TechInfF_BTN.setVisible(true);
        prev_TechInfF_BTN.setVisible(false);
        cur_TechInfF_FIELD.setVisible(false);
        next_TechInfF_BTN.setVisible(false);
        cancel_TechInfF_BTN.setVisible(true);

        actionType = action_type;

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        techInfF_BOX.toFront();
    }

    // show
    private void show_TechInf(String showType)
    {
        showType_BOX.setDisable(false);
        fieldsChange_BTN.setDisable(false);
        fieldsDelete_BTN.setDisable(false);
        choseChange_BTN.setDisable(true);
        choseDelete_BTN.setDisable(true);
        if (showType.equals("asTable"))
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsTechInf.SELECT_ALL);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    row.setField_03(AppCore.resultSet.getString(3).trim());
                    row.setField_04(AppCore.resultSet.getString(4).trim());
                    row.setField_05(AppCore.resultSet.getString(5).trim());
                    row.setField_06(AppCore.resultSet.getString(6).trim());
                    row.setField_07(AppCore.resultSet.getString(7).trim());
                    rows.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            drSR_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>      ("field_01"));
            serverID_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>  ("field_02"));
            portSAP_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>   ("field_03"));
            speed_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>     ("field_04"));
            ip_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>      ("field_05"));
            scheme_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>   ("field_06"));
            pm_TechInfT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_07"));
            techInf_TABLE.setItems(rows);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(true);
            recordsShowType_BTN.setSelected(false);

            show_BOX.toFront();
            tables_BOX.toFront();
            techInfT_BOX.toFront();
        }
        else if (showType.equals("byRecords"))
        {
            records = new ArrayList<>();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsTechInf.SELECT_ALL);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    ArrayList<String> row = new ArrayList<>();
                    row.add(AppCore.resultSet.getString(1).trim());
                    row.add(AppCore.resultSet.getString(2).trim());
                    row.add(AppCore.resultSet.getString(3).trim());
                    row.add(AppCore.resultSet.getString(4).trim());
                    row.add(AppCore.resultSet.getString(5).trim());
                    row.add(AppCore.resultSet.getString(6).trim());
                    row.add(AppCore.resultSet.getString(7).trim());
                    records.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            curRecord = 1;

            use_TechInfF_BTN.setVisible(false);
            prev_TechInfF_BTN.setVisible(true);
            next_TechInfF_BTN.setVisible(true);

            showRecord_TechInfF();
            drSR_TechInfF_FIELD.setEditable(false);
            serverID_TechInfF_FIELD.setEditable(false);
            portSAP_TechInfF_FIELD.setEditable(false);
            speed_TechInfF_FIELD.setEditable(false);
            ip_TechInfF_FIELD.setEditable(false);
            scheme_TechInfF_FIELD.setEditable(false);
            pm_TechInfF_FIELD.setEditable(false);

            cur_TechInfF_FIELD.setVisible(true);
            cancel_TechInfF_BTN.setVisible(false);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(true);

            show_BOX.toFront();
            forms_BOX.toFront();
            techInfF_BOX.toFront();
        }
    }

    private void showRecord_TechInfF()
    {
        curRecord_changed = false;
        if (records.size() != 0)
        {
            cur_TechInfF_FIELD.setText(curRecord + "/" + records.size());

            drSR_TechInfF_FIELD.    setText(records.get(curRecord - 1).get(0));
            serverID_TechInfF_FIELD.setText(records.get(curRecord - 1).get(1));
            portSAP_TechInfF_FIELD. setText(records.get(curRecord - 1).get(2));
            speed_TechInfF_FIELD.   setText(records.get(curRecord - 1).get(3));
            ip_TechInfF_FIELD.      setText(records.get(curRecord - 1).get(4));
            scheme_TechInfF_FIELD.  setText(records.get(curRecord - 1).get(5));
            pm_TechInfF_FIELD.      setText(records.get(curRecord - 1).get(6));
        }
        else
        {
            cur_TechInfF_FIELD.setText("0/0");

            drSR_TechInfF_FIELD.    setText("");
            serverID_TechInfF_FIELD.setText("");
            portSAP_TechInfF_FIELD. setText("");
            speed_TechInfF_FIELD.   setText("");
            ip_TechInfF_FIELD.      setText("");
            scheme_TechInfF_FIELD.  setText("");
            pm_TechInfF_FIELD.      setText("");

             use_TechInfF_BTN.setVisible(false);
            prev_TechInfF_BTN.setVisible(false);
            next_TechInfF_BTN.setVisible(false);
        }
    }

    // wherePart
    private String getWherePart_TechInfF()
    {
        StringBuilder wherePart = new StringBuilder();
        
        if (!drSR_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND \"dr/sr\" = '").append(drSR_TechInfF_FIELD.getText()).append("'");
        if (!serverID_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND server_id = '").append(serverID_TechInfF_FIELD.getText()).append("'");
        if (!portSAP_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND \"port/sap\" = '").append(portSAP_TechInfF_FIELD.getText()).append("'");
        if (!speed_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND \"speed(mb/s)\" = '").append(speed_TechInfF_FIELD.getText()).append("'");
        if (!ip_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND ip = '").append(ip_TechInfF_FIELD.getText()).append("'");
        if (!scheme_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND scheme = '").append(scheme_TechInfF_FIELD.getText()).append("'");
        if (!pm_TechInfF_FIELD.getText().equals(""))
            wherePart.append(" AND pm = '").append(pm_TechInfF_FIELD.getText()).append("'");
        
        return wherePart.toString();
    }

    // search
    private void searchRecord_TechInf()
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(String.format(QrsTechInf.SELECT_2CHANGE, getWherePart_TechInfF()));
            recordsCount = 0;
            while (AppCore.resultSet.next())
            {
                FullTableRow row = new FullTableRow();
                row.setField_01(AppCore.resultSet.getString(1).trim());
                row.setField_02(AppCore.resultSet.getString(2).trim());
                row.setField_03(AppCore.resultSet.getString(3).trim());
                row.setField_04(AppCore.resultSet.getString(4).trim());
                row.setField_05(AppCore.resultSet.getString(5).trim());
                row.setField_06(AppCore.resultSet.getString(6).trim());
                row.setField_07(AppCore.resultSet.getString(7).trim());
                rows.add(row);
                recordsCount++;
            }
            techInf_TABLE.setItems(rows);
            recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(true);
        showType_BOX.setDisable(true);
        tableShowType_BTN.setSelected(false);
        recordsShowType_BTN.setSelected(false);

        show_BOX.toFront();
        tables_BOX.toFront();
        techInfT_BOX.toFront();
    }
    
    // change
    private void changeRecord_TechInfF()
    {
        records = new ArrayList<>();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsTechInf.SELECT_2CHANGE, getWherePart_TechInfF()));
            while (AppCore.resultSet.next())
            {
                ArrayList<String> row = new ArrayList<>();
                row.add(AppCore.resultSet.getString(1).trim());
                row.add(AppCore.resultSet.getString(2).trim());
                row.add(AppCore.resultSet.getString(3).trim());
                row.add(AppCore.resultSet.getString(4).trim());
                row.add(AppCore.resultSet.getString(5).trim());
                row.add(AppCore.resultSet.getString(6).trim());
                row.add(AppCore.resultSet.getString(7).trim());
                records.add(row);
            }
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        curRecord = 1;
        actionType = "change";

        AppCore.showAlert("Приступайте к изменениям");

        use_TechInfF_BTN.setVisible(true);
        prev_TechInfF_BTN.setVisible(true);
        next_TechInfF_BTN.setVisible(true);

        showRecord_TechInfF();

        drSR_TechInfF_FIELD.setEditable(true);
        serverID_TechInfF_FIELD.setEditable(true);
        portSAP_TechInfF_FIELD.setEditable(true);
        speed_TechInfF_FIELD.setEditable(true);
        ip_TechInfF_FIELD.setEditable(true);
        scheme_TechInfF_FIELD.setEditable(true);
        pm_TechInfF_FIELD.setEditable(true);

        cur_TechInfF_FIELD.setVisible(true);
        cancel_TechInfF_BTN.setVisible(true);

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        techInfF_BOX.toFront();
    }

    // delete
    private void deleteRecord_TechInfF()
    {
        int rowsCount = 0;
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsTechInf.SELECT_2DELETE, getWherePart_TechInfF()));
            AppCore.resultSet.next();
            rowsCount = AppCore.resultSet.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setContentText("Найдено " + rowsCount +
                " подходящих записей\n\nУдалить все?\n(Также будут удалены все связанные записи)");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                int executeCount = AppCore.statement.executeUpdate(
                        "DELETE FROM technical_information WHERE id = id" + getWherePart_TechInfF());
                recordsCounter_FIELD.setText("Всего записей: " + (recordsCount - rowsCount));
                AppCore.showAlert("Удалённых записей: " + executeCount);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    // Contracts =====================================
    private void use_Record_ContractsF(String alert_msg, String action_type)
    {
        AppCore.showAlert(alert_msg);

        name_ContractsF_FIELD.setEditable(true); name_ContractsF_FIELD.setText("");
        client_ContractsF_CHOICE.setEditable(true);
        preparationDate_ContractsF_FIELD.setEditable(true); preparationDate_ContractsF_FIELD.setText("");
        startDate_ContractsF_FIELD.setEditable(true); startDate_ContractsF_FIELD.setText("");
        status_ContractsF_CHOICE.setEditable(true);
        endDate_ContractsF_FIELD.setEditable(true); endDate_ContractsF_FIELD.setText("");

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsClients.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            "[" + AppCore.resultSet.getString(1).trim() + "] " +
                            "Клиент: " + AppCore.resultSet.getString(2).trim()
                    );
                }
                client_ContractsF_CHOICE.setItems(items);
                client_ContractsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_CONTRACT_STATUSES);
                while (AppCore.resultSet.next())
                { items.add(AppCore.resultSet.getString(1).trim()); }
                status_ContractsF_CHOICE.setItems(items);
                status_ContractsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        use_ContractsF_BTN.setVisible(true);
        prev_ContractsF_BTN.setVisible(false);
        cur_ContractsF_FIELD.setVisible(false);
        next_ContractsF_BTN.setVisible(false);
        cancel_ContractsF_BTN.setVisible(true);

        actionType = action_type;

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        contractsF_BOX.toFront();
    }

    // show
    private void show_Contracts(String showType)
    {
        showType_BOX.setDisable(false);
        fieldsChange_BTN.setDisable(false);
        fieldsDelete_BTN.setDisable(false);
        choseChange_BTN.setDisable(true);
        choseDelete_BTN.setDisable(true);
        if (showType.equals("asTable"))
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsContracts.SELECT_TABLE);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    row.setField_03(AppCore.resultSet.getString(3).trim());
                    row.setField_04(AppCore.resultSet.getString(4).trim());
                    row.setField_05(AppCore.resultSet.getString(5).trim());
                    String temp = AppCore.resultSet.getString(6);
                    row.setField_06(temp != null ? temp.trim() : "null");
                    rows.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            name_ContractsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>           ("field_01"));
            client_ContractsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>         ("field_02"));
            preparationDate_ContractsT_COLUMN.setCellValueFactory(new PropertyValueFactory<> ("field_03"));
            startDate_ContractsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>      ("field_04"));
            status_ContractsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>         ("field_05"));
            endDate_ContractsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>        ("field_06"));
            contracts_TABLE.setItems(rows);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(true);
            recordsShowType_BTN.setSelected(false);

            show_BOX.toFront();
            tables_BOX.toFront();
            contractsT_BOX.toFront();
        }
        else if (showType.equals("byRecords"))
        {
            records = new ArrayList<>();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsContracts.SELECT_TABLE);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    ArrayList<String> row = new ArrayList<>();
                    row.add(AppCore.resultSet.getString(1).trim());
                    row.add(
                            "[" + AppCore.resultSet.getString(7).trim() + "] " +
                            "Клиент: " + AppCore.resultSet.getString(2).trim()
                    );
                    row.add(AppCore.resultSet.getString(3).trim());
                    row.add(AppCore.resultSet.getString(4).trim());
                    row.add(AppCore.resultSet.getString(5).trim());
                    row.add(AppCore.resultSet.getString(6).trim());
                    records.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            curRecord = 1;

            use_ContractsF_BTN .setVisible(false);
            prev_ContractsF_BTN.setVisible(true);
            next_ContractsF_BTN.setVisible(true);

            showRecord_ContractsF();
            name_ContractsF_FIELD          .setEditable(false);
            client_ContractsF_CHOICE       .setEditable(false);
            preparationDate_ContractsF_FIELD.setEditable(false);
            startDate_ContractsF_FIELD     .setEditable(false);
            status_ContractsF_CHOICE       .setEditable(false);
            endDate_ContractsF_FIELD       .setEditable(false);

            cur_ContractsF_FIELD .setVisible(true);
            cancel_ContractsF_BTN.setVisible(false);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(true);

            show_BOX.toFront();
            forms_BOX.toFront();
            contractsF_BOX.toFront();
        }
    }

    private void showRecord_ContractsF()
    {
        curRecord_changed = false;
        if (records.size() != 0)
        {
            cur_ContractsF_FIELD.setText(curRecord + "/" + records.size());

            name_ContractsF_FIELD          .setText (records.get(curRecord - 1).get(0));
            client_ContractsF_CHOICE       .setValue(records.get(curRecord - 1).get(1));
            preparationDate_ContractsF_FIELD.setText (records.get(curRecord - 1).get(2));
            startDate_ContractsF_FIELD     .setText (records.get(curRecord - 1).get(3));
            status_ContractsF_CHOICE       .setValue(records.get(curRecord - 1).get(4));
            endDate_ContractsF_FIELD       .setText (records.get(curRecord - 1).get(5));
        }
        else
        {
            cur_ContractsF_FIELD.setText("0/0");

            name_ContractsF_FIELD          .setText ("");
            client_ContractsF_CHOICE       .setValue(null);
            preparationDate_ContractsF_FIELD.setText ("");
            startDate_ContractsF_FIELD     .setText ("");
            status_ContractsF_CHOICE       .setValue(null);
            endDate_ContractsF_FIELD       .setText ("");

            use_ContractsF_BTN .setVisible(false);
            prev_ContractsF_BTN.setVisible(false);
            next_ContractsF_BTN.setVisible(false);
        }
    }
    
    // wherePart
    private String getWherePart_ContractsF()
    {
        StringBuilder wherePart = new StringBuilder();

        if (!name_ContractsF_FIELD.getText().equals(""))
            wherePart.append(" AND c.name = '").append(name_ContractsF_FIELD.getText()).append("'");
        if (client_ContractsF_CHOICE.getValue() != null)
        {
            String tempStr = client_ContractsF_CHOICE.getValue();
            wherePart.append(" AND c.id_client = ")
                    .append(tempStr, tempStr.indexOf('[') + 1, tempStr.indexOf(']'));
        }
        if (!preparationDate_ContractsF_FIELD.getText().equals(""))
            wherePart.append(" AND c.preparation_date = '").append(preparationDate_ContractsF_FIELD.getText()).append("'");
        if (!startDate_ContractsF_FIELD.getText().equals(""))
            wherePart.append(" AND c.start_date = '").append(startDate_ContractsF_FIELD.getText()).append("'");
        if (status_ContractsF_CHOICE.getValue() != null)
            wherePart.append(" AND c.id_status = (SELECT id FROM contract_statuses WHERE name = '")
                    .append(status_ContractsF_CHOICE.getValue()).append("')");
        if (!endDate_ContractsF_FIELD.getText().equals("")) {
            wherePart.append(" AND c.end_date ");
            if (endDate_ContractsF_FIELD.getText().equals("null")) wherePart.append("ISNULL");
            else wherePart.append("= '").append(endDate_ContractsF_FIELD.getText()).append("'");
        }
        
        return wherePart.toString();
    }

    // search
    private void searchRecord_Contracts()
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(String.format(QrsContracts.SELECT_2CHANGE, getWherePart_ContractsF()));
            recordsCount = 0;
            while (AppCore.resultSet.next())
            {
                FullTableRow row = new FullTableRow();
                row.setField_01(AppCore.resultSet.getString(1).trim());
                row.setField_02(AppCore.resultSet.getString(2).trim());
                row.setField_03(AppCore.resultSet.getString(3).trim());
                row.setField_04(AppCore.resultSet.getString(4).trim());
                row.setField_05(AppCore.resultSet.getString(5).trim());
                String temp = AppCore.resultSet.getString(6);
                row.setField_06(temp != null ? temp.trim() : "null");
                rows.add(row);
                recordsCount++;
            }
            contracts_TABLE.setItems(rows);
            recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(true);
        showType_BOX.setDisable(true);
        tableShowType_BTN.setSelected(false);
        recordsShowType_BTN.setSelected(false);

        show_BOX.toFront();
        tables_BOX.toFront();
        contractsT_BOX.toFront();
    }
    
    // change
    private void changeRecord_ContractsF()
    {
        records = new ArrayList<>();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsContracts.SELECT_2CHANGE, getWherePart_ContractsF()));
            while (AppCore.resultSet.next())
            {
                ArrayList<String> row = new ArrayList<>();
                row.add(AppCore.resultSet.getString(1).trim());
                row.add(
                        "[" + AppCore.resultSet.getString(7).trim() + "] " +
                        "Клиент: " + AppCore.resultSet.getString(2).trim()
                );
                row.add(AppCore.resultSet.getString(3).trim());
                row.add(AppCore.resultSet.getString(4).trim());
                row.add(AppCore.resultSet.getString(5).trim());
                row.add(AppCore.resultSet.getString(6).trim());
                records.add(row);
            }
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        curRecord = 1;
        actionType = "change";

        AppCore.showAlert("Приступайте к изменениям");

        use_ContractsF_BTN.setVisible(true);
        prev_ContractsF_BTN.setVisible(true);
        next_ContractsF_BTN.setVisible(true);

        showRecord_ContractsF();
        name_ContractsF_FIELD.setEditable(true);
        client_ContractsF_CHOICE.setEditable(true);
        preparationDate_ContractsF_FIELD.setEditable(true);
        startDate_ContractsF_FIELD.setEditable(true);
        status_ContractsF_CHOICE.setEditable(true);
        endDate_ContractsF_FIELD.setEditable(true);

        cur_ContractsF_FIELD.setVisible(true);
        cancel_ContractsF_BTN.setVisible(true);

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        contractsF_BOX.toFront();
    }

    // delete
    private void deleteRecord_ContractsF()
    {
        int rowsCount = 0;
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsContracts.SELECT_2DELETE, getWherePart_ContractsF()));
            AppCore.resultSet.next();
            rowsCount = AppCore.resultSet.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setContentText("Найдено " + rowsCount +
                " подходящих записей\n\nУдалить все?\n(Также будут удалены все связанные записи)");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                int executeCount = AppCore.statement.executeUpdate(
                        "DELETE FROM contracts AS c WHERE id = id" + getWherePart_ContractsF());
                recordsCounter_FIELD.setText("Всего записей: " + (recordsCount - rowsCount));
                AppCore.showAlert("Удалённых записей: " + executeCount);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    // FinOps =====================================
    private void use_Record_FinOpsF(String alert_msg, String action_type)
    {
        AppCore.showAlert(alert_msg);

        bill_FinOpsF_CHOICE.setEditable(true);
        transactionType_FinOpsF_CHOICE.setEditable(true);
        sum_FinOpsF_FIELD.setEditable(true); sum_FinOpsF_FIELD.setText("");
        operationDate_FinOpsF_FIELD.setEditable(true); operationDate_FinOpsF_FIELD.setText("");
        contractPart_FinOpsF_CHOICE.setEditable(true);
        comment_FinOpsF_FIELD.setEditable(true); comment_FinOpsF_FIELD.setText("");

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_BILLS);
                while (AppCore.resultSet.next())
                {
                    items.add(
                        "[" + AppCore.resultSet.getString(3).trim() + "] " +
                                "Клиент: " + AppCore.resultSet.getString(1).trim() +
                                " , баланс: " + AppCore.resultSet.getString(2).trim()
                    );
                }
                bill_FinOpsF_CHOICE.setItems(items);
                bill_FinOpsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_TRANSACTION_TYPES);
                while (AppCore.resultSet.next())
                { items.add(AppCore.resultSet.getString(1).trim()); }
                transactionType_FinOpsF_CHOICE.setItems(items);
                transactionType_FinOpsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_CONTRACT_PARTS);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            "[" + AppCore.resultSet.getString(3).trim() + "] " +
                                    "Контракт: " + AppCore.resultSet.getString(1).trim() +
                                    ", тариф: " + AppCore.resultSet.getString(2).trim()
                    );
                }
                contractPart_FinOpsF_CHOICE.setItems(items);
                contractPart_FinOpsF_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        use_FinOpsF_BTN.setVisible(true);
        prev_FinOpsF_BTN.setVisible(false);
        cur_FinOpsF_FIELD.setVisible(false);
        next_FinOpsF_BTN.setVisible(false);
        cancel_FinOpsF_BTN.setVisible(true);

        actionType = action_type;

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        finOpsF_BOX.toFront();
    }

    // show
    private void show_FinOps(String showType)
    {
        showType_BOX.setDisable(false);
        fieldsChange_BTN.setDisable(false);
        fieldsDelete_BTN.setDisable(false);
        choseChange_BTN.setDisable(true);
        choseDelete_BTN.setDisable(true);
        if (showType.equals("asTable"))
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsFinOps.SELECT_TABLE);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    row.setField_03(AppCore.resultSet.getString(3).trim());
                    row.setField_04(AppCore.resultSet.getString(4).trim());
                    row.setField_05(AppCore.resultSet.getString(5).trim());
                    String temp = AppCore.resultSet.getString(6);
                    row.setField_06(temp != null ? temp.trim() : "null");
                           temp = AppCore.resultSet.getString(7);
                    row.setField_07(temp != null ? temp.trim() : "null");
                    temp = AppCore.resultSet.getString(8);
                    row.setField_08(temp != null ? temp.trim() : "null");
                    rows.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            client_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>                ("field_01"));
            balance_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>               ("field_02"));
            transactionType_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>       ("field_03"));
            sum_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>                   ("field_04"));
            operationDate_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>         ("field_05"));
            contract_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>              ("field_06"));
            tariff_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>                ("field_07"));
            comment_FinOpsT_COLUMN.setCellValueFactory(new PropertyValueFactory<>               ("field_08"));
            finOps_TABLE.setItems(rows);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(true);
            recordsShowType_BTN.setSelected(false);

            show_BOX.toFront();
            tables_BOX.toFront();
            finOpsT_BOX.toFront();
        }
        else if (showType.equals("byRecords"))
        {
            records = new ArrayList<>();
            try
            {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsFinOps.SELECT_TABLE);
                recordsCount = 0;
                while (AppCore.resultSet.next())
                {
                    ArrayList<String> row = new ArrayList<>();
                    row.add(
                            "[" + AppCore.resultSet.getString(9).trim() + "] " +
                                    "Клиент: " + AppCore.resultSet.getString(1).trim() +
                                    " , баланс: " + AppCore.resultSet.getString(2).trim()
                    );
                    row.add(AppCore.resultSet.getString(3).trim());
                    row.add(AppCore.resultSet.getString(4).trim());
                    row.add(AppCore.resultSet.getString(5).trim());
                    String temp = AppCore.resultSet.getString(10);
                    row.add(temp != null ?
                            "[" + AppCore.resultSet.getString(10).trim() + "] " +
                                    "Контракт: " + AppCore.resultSet.getString(6).trim() +
                                    ", тариф: " + AppCore.resultSet.getString(7).trim()
                            : "null"
                    );
                           temp = AppCore.resultSet.getString(8);
                    row.add(temp != null ? temp.trim() : "null");
                    records.add(row);
                    recordsCount++;
                }
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            curRecord = 1;

            use_FinOpsF_BTN .setVisible(false);
            prev_FinOpsF_BTN.setVisible(true);
            next_FinOpsF_BTN.setVisible(true);

            bill_FinOpsF_CHOICE.setItems(null);
            transactionType_FinOpsF_CHOICE.setItems(null);
            contractPart_FinOpsF_CHOICE.setItems(null);
            showRecord_FinOpsF();
            bill_FinOpsF_CHOICE.setEditable(false);
            transactionType_FinOpsF_CHOICE.setEditable(false);
            sum_FinOpsF_FIELD.setEditable(false);
            operationDate_FinOpsF_FIELD.setEditable(false);
            contractPart_FinOpsF_CHOICE.setEditable(false);
            comment_FinOpsF_FIELD.setEditable(false);

            cur_FinOpsF_FIELD .setVisible(true);
            cancel_FinOpsF_BTN.setVisible(false);

            toMain_BTN.setDisable(false);
            subMenu_BOX.setVisible(true);
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(true);

            show_BOX.toFront();
            forms_BOX.toFront();
            finOpsF_BOX.toFront();
        }
    }

    private void showRecord_FinOpsF()
    {
        curRecord_changed = false;
        if (records.size() != 0)
        {
            cur_FinOpsF_FIELD.setText(curRecord + "/" + records.size());

            bill_FinOpsF_CHOICE.setValue(records.get(curRecord - 1).get(0));
            transactionType_FinOpsF_CHOICE.setValue(records.get(curRecord - 1).get(1));
            sum_FinOpsF_FIELD.setText (records.get(curRecord - 1).get(2));
            operationDate_FinOpsF_FIELD.setText (records.get(curRecord - 1).get(3));
            contractPart_FinOpsF_CHOICE.setValue(records.get(curRecord - 1).get(4));
            comment_FinOpsF_FIELD.setText (records.get(curRecord - 1).get(5));
        }
        else
        {
            cur_FinOpsF_FIELD.setText("0/0");

            bill_FinOpsF_CHOICE.setValue(null);
            transactionType_FinOpsF_CHOICE.setValue(null);
            sum_FinOpsF_FIELD.setText ("");
            operationDate_FinOpsF_FIELD.setText ("");
            contractPart_FinOpsF_CHOICE.setValue(null);
            comment_FinOpsF_FIELD.setText ("");

            use_FinOpsF_BTN .setVisible(false);
            prev_FinOpsF_BTN.setVisible(false);
            next_FinOpsF_BTN.setVisible(false);
        }
    }

    // wherePart
    private String getWherePart_FinOpsF()
    {
        StringBuilder wherePart = new StringBuilder();

        if (bill_FinOpsF_CHOICE.getValue() != null)
        {
            String tempStr = bill_FinOpsF_CHOICE.getValue();
            wherePart.append(" AND f.id_bill = ")
                    .append(tempStr, tempStr.indexOf('[') + 1, tempStr.indexOf(']'));
        }
        if (transactionType_FinOpsF_CHOICE.getValue() != null)
            wherePart.append(" AND f.id_transaction_type = (SELECT id FROM transaction_types WHERE name = '")
                    .append(transactionType_FinOpsF_CHOICE.getValue()).append("')");
        if (!sum_FinOpsF_FIELD.getText().equals(""))
            wherePart.append(" AND f.sum = '").append(sum_FinOpsF_FIELD.getText()).append("'");
        if (!operationDate_FinOpsF_FIELD.getText().equals(""))
            wherePart.append(" AND f.operation_date = '").append(operationDate_FinOpsF_FIELD.getText()).append("'");
        if (contractPart_FinOpsF_CHOICE.getValue() != null)
        {
            wherePart.append(" AND f.id_contract_part ");
            if (contractPart_FinOpsF_CHOICE.getValue().equals("null")) wherePart.append("ISNULL");
            else { String tempStr = contractPart_FinOpsF_CHOICE.getValue();
                   wherePart.append("= ").append(tempStr, tempStr.indexOf('[') + 1, tempStr.indexOf(']')); }
        }
        if (!comment_FinOpsF_FIELD.getText().equals("")) {
            wherePart.append(" AND f.comment ");
            if (comment_FinOpsF_FIELD.getText().equals("null")) wherePart.append("ISNULL");
            else wherePart.append("= '").append(comment_FinOpsF_FIELD.getText()).append("'");
        }

        return wherePart.toString();
    }

    // search
    private void searchRecord_FinOps()
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(String.format(QrsFinOps.SELECT_2CHANGE, getWherePart_FinOpsF()));
            recordsCount = 0;
            while (AppCore.resultSet.next())
            {
                FullTableRow row = new FullTableRow();
                row.setField_01(AppCore.resultSet.getString(1).trim());
                row.setField_02(AppCore.resultSet.getString(2).trim());
                row.setField_03(AppCore.resultSet.getString(3).trim());
                row.setField_04(AppCore.resultSet.getString(4).trim());
                row.setField_05(AppCore.resultSet.getString(5).trim());
                String temp = AppCore.resultSet.getString(6);
                row.setField_06(temp != null ? temp.trim() : "null");
                temp = AppCore.resultSet.getString(7);
                row.setField_07(temp != null ? temp.trim() : "null");
                temp = AppCore.resultSet.getString(8);
                row.setField_08(temp != null ? temp.trim() : "null");
                rows.add(row);
                recordsCount++;
            }
            finOps_TABLE.setItems(rows);
            recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(true);
        showType_BOX.setDisable(true);
        tableShowType_BTN.setSelected(false);
        recordsShowType_BTN.setSelected(false);

        show_BOX.toFront();
        tables_BOX.toFront();
        finOpsT_BOX.toFront();
    }

    // change
    private void changeRecord_FinOpsF()
    {
        records = new ArrayList<>();
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsFinOps.SELECT_2CHANGE, getWherePart_FinOpsF()));
            while (AppCore.resultSet.next())
            {
                ArrayList<String> row = new ArrayList<>();
                row.add(
                        "[" + AppCore.resultSet.getString(9).trim() + "] " +
                                "Клиент: " + AppCore.resultSet.getString(1).trim() +
                                " , баланс: " + AppCore.resultSet.getString(2).trim()
                );
                row.add(AppCore.resultSet.getString(3).trim());
                row.add(AppCore.resultSet.getString(4).trim());
                row.add(AppCore.resultSet.getString(5).trim());
                String temp = AppCore.resultSet.getString(10);
                if (temp != null) {
                    row.add(
                            "[" + temp.trim() + "] " +
                                    "Контракт: " + AppCore.resultSet.getString(6).trim() +
                                    ", тариф: " + AppCore.resultSet.getString(7).trim()
                    );
                } else row.add("[null]");
                temp = AppCore.resultSet.getString(8);
                if (temp != null) { row.add(temp.trim()); } else row.add("null");
                records.add(row);
            }
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        curRecord = 1;
        actionType = "change";

        AppCore.showAlert("Приступайте к изменениям");

        use_FinOpsF_BTN.setVisible(true);
        prev_FinOpsF_BTN.setVisible(true);
        next_FinOpsF_BTN.setVisible(true);

        showRecord_FinOpsF();
        bill_FinOpsF_CHOICE.setEditable(true);
        transactionType_FinOpsF_CHOICE.setEditable(true);
        sum_FinOpsF_FIELD.setEditable(true);
        operationDate_FinOpsF_FIELD.setEditable(true);
        contractPart_FinOpsF_CHOICE.setEditable(true);
        comment_FinOpsF_FIELD.setEditable(true);

        cur_FinOpsF_FIELD.setVisible(true);
        cancel_FinOpsF_BTN.setVisible(true);

        toMain_BTN.setDisable(false);
        subMenu_BOX.setVisible(false);

        show_BOX.toFront();
        forms_BOX.toFront();
        finOpsF_BOX.toFront();
    }

    // delete
    private void deleteRecord_FinOpsF()
    {
        int rowsCount = 0;
        try
        {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(
                    String.format(QrsFinOps.SELECT_2DELETE, getWherePart_FinOpsF()));
            AppCore.resultSet.next();
            rowsCount = AppCore.resultSet.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
        catch (Exception e) { e.printStackTrace(); }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setContentText("Найдено " + rowsCount +
                " подходящих записей\n\nУдалить все?\n(Также будут удалены все связанные записи)");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                int executeCount = AppCore.statement.executeUpdate(
                        "DELETE FROM financial_operations AS f WHERE id = id" + getWherePart_ContractsF());
                recordsCounter_FIELD.setText("Всего записей: " + (recordsCount - rowsCount));
                AppCore.showAlert("Удалённых записей: " + executeCount);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
// endregion
// region SOME EASIER
    // Contract parts ===================================
    private void proc_ContractParts(String title, String[] queryValues, String successText, String failText)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle(title);

        GridPane insideArea = new GridPane();
        Label contract_LBL = new Label("Контракт:"); ComboBox<String> contract_CHOICE = new ComboBox<>();
        Label tariff_LBL = new Label("Тариф:"); ComboBox<String> tariff_CHOICE = new ComboBox<>();

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsContracts.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            '[' + AppCore.resultSet.getString(1).trim() + "] " +
                            AppCore.resultSet.getString(2).trim()
                    );
                }
                contract_CHOICE.setItems(items);
                String tmpVal = "";
                for (String val : contract_CHOICE.getItems())
                    if (val != null) if (val.contains(queryValues[1])) tmpVal = val;
                contract_CHOICE.setValue(tmpVal);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsTariffs.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            '[' + AppCore.resultSet.getString(1).trim() + "] " +
                            AppCore.resultSet.getString(2).trim()
                    );
                }
                tariff_CHOICE.setItems(items);
                String tmpVal = "";
                for (String val : tariff_CHOICE.getItems())
                    if (val != null) if (val.contains(queryValues[2])) tmpVal = val;
                tariff_CHOICE.setValue(tmpVal);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            GridPane.setConstraints(contract_LBL, 0, 0);
            GridPane.setConstraints(tariff_LBL, 0, 1);
            GridPane.setConstraints(contract_CHOICE, 1, 0);
            GridPane.setConstraints(tariff_CHOICE, 1, 1);
        }

        insideArea.getChildren().addAll(contract_LBL, tariff_LBL, contract_CHOICE, tariff_CHOICE);
        dialog.getDialogPane().setContent(insideArea);

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(none ->
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                String tempContract = contract_CHOICE.getValue(),
                       tempTariff   = tariff_CHOICE.getValue();
                AppCore.statement.executeUpdate(
                        String.format(queryValues[0],
                                tempContract.substring(tempContract.indexOf('[') + 1, tempContract.indexOf(']')),
                                tempTariff.substring(tempContract.indexOf('[') + 1, tempContract.indexOf(']')),
                                queryValues[1], queryValues[2]));
                AppCore.showAlert(successText);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert(failText);
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        });

        show_CommonCatalog(curTable);
    }

    // add
    private void addRecord_ContractParts()
    {
        proc_ContractParts("Добавление новой части контрактов",
                new String[] {QrsCommonCatalogs.ADD_CONTRACT_PARTS, null, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // search
    private void searchRecord_ContractParts()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle("Поиск частей контрактов");

        GridPane insideArea = new GridPane();
        Label contract_LBL = new Label("Контракт:"); ComboBox<String> contract_CHOICE = new ComboBox<>();
        Label tariff_LBL = new Label("Тариф:"); ComboBox<String> tariff_CHOICE = new ComboBox<>();

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsContracts.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            '[' + AppCore.resultSet.getString(1).trim() + "] " +
                                    AppCore.resultSet.getString(2).trim()
                    );
                }
                contract_CHOICE.setItems(items);
                contract_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsTariffs.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            '[' + AppCore.resultSet.getString(1).trim() + "] " +
                                    AppCore.resultSet.getString(2).trim()
                    );
                }
                tariff_CHOICE.setItems(items);
                tariff_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            GridPane.setConstraints(contract_LBL, 0, 0);
            GridPane.setConstraints(tariff_LBL, 0, 1);
            GridPane.setConstraints(contract_CHOICE, 1, 0);
            GridPane.setConstraints(tariff_CHOICE, 1, 1);
        }

        insideArea.getChildren().addAll(contract_LBL, tariff_LBL, contract_CHOICE, tariff_CHOICE);
        dialog.getDialogPane().setContent(insideArea);

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(none ->
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try {
                StringBuilder wherePart = new StringBuilder();

                String tempContract = contract_CHOICE.getValue(),
                       tempTariff   = tariff_CHOICE.getValue();

                if (tempContract != null && !tempContract.equals(""))
                    wherePart.append(" AND cp.id_contract = ")
                             .append(tempContract, tempContract.indexOf('[') + 1, tempContract.indexOf(']'));
                if (tempTariff != null && !tempTariff.equals(""))
                    wherePart.append(" AND cp.id_tariff = ")
                             .append(tempTariff, tempTariff.indexOf('[') + 1, tempTariff.indexOf(']'));

                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(
                        String.format(QrsCommonCatalogs.SELECT_CONTRACT_PARTS_2SEARCH, wherePart)
                );
                recordsCount = 0;
                while (AppCore.resultSet.next()) {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    rows.add(row);
                    recordsCount++;
                }
                contractParts_TABLE.setItems(rows);
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) {
                e.printStackTrace(); AppCore.showAlert("Не удалось найди записи");
            }
            try {
                AppCore.resultSet.close();
                AppCore.statement.close();
                AppCore.connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // change
    private void changeRecord_ContractParts()
    {
        if (contractParts_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_ContractParts("Изменение части контрактов",
                new String[] {QrsCommonCatalogs.CHANGE_CONTRACT_PARTS,
                        contractParts_TABLE.getSelectionModel().getSelectedItem().getField_01(),
                        contractParts_TABLE.getSelectionModel().getSelectedItem().getField_02()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_ContractParts()
    {
        if (contractParts_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setTitle("Удаление части контрактов");
        alert.setContentText("Выбранная запись будет удалена.\nПродолжить?");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.statement.executeUpdate(String.format(
                        QrsCommonCatalogs.DELETE_CONTRACT_PARTS,
                        contractParts_TABLE.getSelectionModel().getSelectedItem().getField_01(),
                        contractParts_TABLE.getSelectionModel().getSelectedItem().getField_02()));
                AppCore.showAlert("Запись удалена");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        show_CommonCatalog(curTable);
    }

    // Bills ===================================
    private void proc_Bills(String title, String[] queryValues, String successText, String failText)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle(title);

        GridPane insideArea = new GridPane();
        Label client_LBL = new Label("Клиент:"); ComboBox<String> client_CHOICE = new ComboBox<>();
        Label balance_LBL = new Label("Баланс:"); TextField balance_FIELD = new TextField(queryValues[2]);

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsClients.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            '[' + AppCore.resultSet.getString(1).trim() + "] " +
                                    AppCore.resultSet.getString(2).trim()
                    );
                }
                client_CHOICE.setItems(items);
                String tmpVal = "";
                for (String val : client_CHOICE.getItems())
                    if (val != null) if (val.contains(queryValues[1])) tmpVal = val;
                client_CHOICE.setValue(tmpVal);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            GridPane.setConstraints(client_LBL, 0, 0);
            GridPane.setConstraints(balance_LBL, 0, 1);
            GridPane.setConstraints(client_CHOICE, 1, 0);
            GridPane.setConstraints(balance_FIELD, 1, 1);
        }

        insideArea.getChildren().addAll(client_LBL, balance_LBL, client_CHOICE, balance_FIELD);
        dialog.getDialogPane().setContent(insideArea);

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(none ->
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                String tempClient = client_CHOICE.getValue();

                AppCore.statement.executeUpdate(
                        String.format(queryValues[0],
                                tempClient.substring(tempClient.indexOf('[') + 1, tempClient.indexOf(']')),
                                balance_FIELD.getText(),
                                queryValues[1], queryValues[2]));
                AppCore.showAlert(successText);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert(failText);
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        });

        show_CommonCatalog(curTable);
    }

    // add
    private void addRecord_Bills()
    {
        proc_Bills("Добавление нового счёта",
                new String[] {QrsCommonCatalogs.ADD_BILLS, null, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // search
    private void searchRecord_Bills()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle("Поиск счетов");

        GridPane insideArea = new GridPane();
        Label client_LBL = new Label("Клиент:"); ComboBox<String> client_CHOICE = new ComboBox<>();
        Label balance_LBL = new Label("Баланс:"); TextField balance_FIELD = new TextField("");

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsClients.SELECT_NAMES);
                while (AppCore.resultSet.next())
                {
                    items.add(
                            '[' + AppCore.resultSet.getString(1).trim() + "] " +
                                    AppCore.resultSet.getString(2).trim()
                    );
                }
                client_CHOICE.setItems(items);
                client_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            GridPane.setConstraints(client_LBL, 0, 0);
            GridPane.setConstraints(balance_LBL, 0, 1);
            GridPane.setConstraints(client_CHOICE, 1, 0);
            GridPane.setConstraints(balance_FIELD, 1, 1);
        }

        insideArea.getChildren().addAll(client_LBL, balance_LBL, client_CHOICE, balance_FIELD);
        dialog.getDialogPane().setContent(insideArea);

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(none ->
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try {
                StringBuilder wherePart = new StringBuilder();

                String tempClient = client_CHOICE.getValue();
                if (tempClient != null && !tempClient.equals(""))
                    wherePart.append(" AND b.id_client = ")
                             .append(tempClient, tempClient.indexOf('[') + 1, tempClient.indexOf(']'));
                if (balance_FIELD.getText() != null && !balance_FIELD.getText().equals(""))
                    wherePart.append(" AND b.balance = '").append(balance_FIELD.getText()).append("'");

                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(
                        String.format(QrsCommonCatalogs.SELECT_BILLS_2SEARCH, wherePart)
                );
                recordsCount = 0;
                while (AppCore.resultSet.next()) {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    rows.add(row);
                    recordsCount++;
                }
                bills_TABLE.setItems(rows);
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) {
                e.printStackTrace(); AppCore.showAlert("Не удалось найди записи");
            }
            try {
                AppCore.resultSet.close();
                AppCore.statement.close();
                AppCore.connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // change
    private void changeRecord_Bills()
    {
        if (bills_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Bills("Изменение счёта",
                new String[] {QrsCommonCatalogs.CHANGE_BILLS,
                        bills_TABLE.getSelectionModel().getSelectedItem().getField_01(),
                        bills_TABLE.getSelectionModel().getSelectedItem().getField_02()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_Bills()
    {
        if (bills_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setTitle("Удаление счёта");
        alert.setContentText("Выбранная запись будет удалена.\nПродолжить?");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.statement.executeUpdate(String.format(
                        QrsCommonCatalogs.DELETE_BILLS,
                        bills_TABLE.getSelectionModel().getSelectedItem().getField_01(),
                        bills_TABLE.getSelectionModel().getSelectedItem().getField_02()));
                AppCore.showAlert("Запись удалена");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        show_CommonCatalog(curTable);
    }

    // Tariffs ===================================
    private void proc_Tariffs(String title, String[] queryValues, String successText, String failText)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle(title);

        GridPane insideArea = new GridPane();
        Label name_LBL = new Label("Тариф:"); TextField name_FIELD = new TextField(queryValues[1]);
        Label service_LBL = new Label("Услуга:"); ComboBox<String> service_CHOICE = new ComboBox<>();
        Label chargeType_LBL = new Label("Тип оплаты:"); ComboBox<String> chargeType_CHOICE = new ComboBox<>();
        Label cost_LBL = new Label("Стоимость:"); TextField cost_FIELD = new TextField(queryValues[4]);

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_SERVICES);
                while (AppCore.resultSet.next())
                {   items.add(AppCore.resultSet.getString(1).trim());   }
                service_CHOICE.setItems(items);
                String tmpVal = "";
                for (String val : service_CHOICE.getItems())
                    if (val != null) if (val.equals(queryValues[2])) tmpVal = val;
                service_CHOICE.setValue(tmpVal);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_CHARGE_TYPES);
                while (AppCore.resultSet.next())
                {   items.add(AppCore.resultSet.getString(1).trim());   }
                chargeType_CHOICE.setItems(items);
                String tmpVal = "";
                for (String val : chargeType_CHOICE.getItems())
                    if (val != null) if (val.equals(queryValues[3])) tmpVal = val;
                chargeType_CHOICE.setValue(tmpVal);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            GridPane.setConstraints(name_LBL, 0, 0); GridPane.setConstraints(name_FIELD, 0, 1);
            GridPane.setConstraints(service_LBL, 1, 0); GridPane.setConstraints(service_CHOICE, 1, 1);
            GridPane.setConstraints(chargeType_LBL, 2, 0); GridPane.setConstraints(chargeType_CHOICE, 2, 1);
            GridPane.setConstraints(cost_LBL, 3, 0); GridPane.setConstraints(cost_FIELD, 3, 1);

            //   limits
            cost_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
            {   try {
                if (cost_FIELD.isEditable())
                    if (!newValue.equals(""))
                    {
                        float parsed = Float.parseFloat(newValue.split("[? ]")[0]);
                        if (parsed < 10 || parsed > 1500)
                        { cost_FIELD.setStyle("-fx-background-color: #ffbb99;"); }
                        else { cost_FIELD.setStyle(null); }
                    }
                } catch (NumberFormatException ignored){}
            });
        }

        insideArea.getChildren().addAll(name_LBL, name_FIELD,
                                        service_LBL, service_CHOICE,
                                        chargeType_LBL, chargeType_CHOICE,
                                        cost_LBL, cost_FIELD);
        dialog.getDialogPane().setContent(insideArea);

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(none ->
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.statement.executeUpdate(
                        String.format(queryValues[0],
                                      name_FIELD.getText(),
                                      service_CHOICE.getValue(),
                                      chargeType_CHOICE.getValue(),
                                      cost_FIELD.getText(),
                                      queryValues[1], queryValues[2], queryValues[3], queryValues[4]));
                AppCore.showAlert(successText);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert(failText);
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        });

        show_CommonCatalog(curTable);
    }

    // add
    private void addRecord_Tariffs()
    {
        proc_Tariffs("Добавление нового тарифа",
                new String[] {QrsCommonCatalogs.ADD_TARIFFS, null, null, null, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    private void searchRecord_Tariffs()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle("Поиск тарифов");

        GridPane insideArea = new GridPane();
        Label name_LBL = new Label("Тариф:"); TextField name_FIELD = new TextField("");
        Label service_LBL = new Label("Услуга:"); ComboBox<String> service_CHOICE = new ComboBox<>();
        Label chargeType_LBL = new Label("Тип оплаты:"); ComboBox<String> chargeType_CHOICE = new ComboBox<>();
        Label cost_LBL = new Label("Стоимость:"); TextField cost_FIELD = new TextField("");

        {
            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_SERVICES);
                while (AppCore.resultSet.next())
                {   items.add(AppCore.resultSet.getString(1).trim());   }
                service_CHOICE.setItems(items);
                service_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            try {
                ObservableList<String> items = FXCollections.observableArrayList();
                items.add(null);
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(QrsCommonCatalogs.SELECT_CHARGE_TYPES);
                while (AppCore.resultSet.next())
                {   items.add(AppCore.resultSet.getString(1).trim());   }
                chargeType_CHOICE.setItems(items);
                chargeType_CHOICE.setValue(null);
            } catch (Exception e) { e.printStackTrace(); }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }

            GridPane.setConstraints(name_LBL, 0, 0); GridPane.setConstraints(name_FIELD, 0, 1);
            GridPane.setConstraints(service_LBL, 1, 0); GridPane.setConstraints(service_CHOICE, 1, 1);
            GridPane.setConstraints(chargeType_LBL, 2, 0); GridPane.setConstraints(chargeType_CHOICE, 2, 1);
            GridPane.setConstraints(cost_LBL, 3, 0); GridPane.setConstraints(cost_FIELD, 3, 1);
        }

        insideArea.getChildren().addAll(name_LBL, name_FIELD,
                service_LBL, service_CHOICE,
                chargeType_LBL, chargeType_CHOICE,
                cost_LBL, cost_FIELD);
        dialog.getDialogPane().setContent(insideArea);

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(none ->
        {
            StringBuilder wherePart = new StringBuilder();

            if (name_FIELD.getText() != null && !name_FIELD.getText().equals(""))
                wherePart.append(" AND t.name = '").append(name_FIELD.getText()).append("'");
            if (service_CHOICE.getValue() != null && !service_CHOICE.getValue().equals(""))
                wherePart.append(" AND t.id_service = (SELECT id FROM services WHERE name = '")
                         .append(service_CHOICE.getValue()).append("')");
            if (chargeType_CHOICE.getValue() != null && !chargeType_CHOICE.getValue().equals(""))
                wherePart.append(" AND t.id_charge_type = (SELECT id FROM charge_types WHERE name = '")
                        .append(chargeType_CHOICE.getValue()).append("')");
            if (cost_FIELD.getText() != null && !cost_FIELD.getText().equals(""))
                wherePart.append(" AND t.cost = '").append(cost_FIELD.getText()).append("'");

            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(
                        String.format(QrsCommonCatalogs.SELECT_TARIFFS_2SEARCH, wherePart)
                );
                recordsCount = 0;
                while (AppCore.resultSet.next()) {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    row.setField_02(AppCore.resultSet.getString(2).trim());
                    row.setField_03(AppCore.resultSet.getString(3).trim());
                    row.setField_04(AppCore.resultSet.getString(4).trim());
                    rows.add(row);
                    recordsCount++;
                }
                tariffs_TABLE.setItems(rows);
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                AppCore.resultSet.close();
                AppCore.statement.close();
                AppCore.connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // change
    private void changeRecord_Tariffs()
    {
        if (tariffs_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Tariffs("Изменение тарифа",
                new String[] {QrsCommonCatalogs.CHANGE_TARIFFS,
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_01(),
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_02(),
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_03(),
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_04()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_Tariffs()
    {
        if (tariffs_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setTitle("Удаление тарифа");
        alert.setContentText("Выбранная запись будет удалена.\nПродолжить?");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.statement.executeUpdate(String.format(
                        QrsCommonCatalogs.DELETE_TARIFFS,
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_01(),
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_02(),
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_03(),
                        tariffs_TABLE.getSelectionModel().getSelectedItem().getField_04()));
                AppCore.showAlert("Запись удалена");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        show_CommonCatalog(curTable);
    }
// endregion
// region MORE EASIER
    private void search_Base(String title, String query)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle(title);
        dialog.setContentText("Название:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(value ->
        {
            ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.resultSet = AppCore.statement.executeQuery(String.format(
                        query, value
                ));
                recordsCount = 0;
                while (AppCore.resultSet.next()) {
                    FullTableRow row = new FullTableRow();
                    row.setField_01(AppCore.resultSet.getString(1).trim());
                    rows.add(row);
                    recordsCount++;
                }
                commonCatalog_TABLE.setItems(rows);
                recordsCounter_FIELD.setText("Всего записей: " + recordsCount);
            } catch (Exception e) {
                e.printStackTrace(); AppCore.showAlert("Не удалось найти записи");
            }
            try {
                AppCore.resultSet.close();
                AppCore.statement.close();
                AppCore.connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void proc_Base(String title, String[] queryValues, String successText, String failText)
    {
        TextInputDialog dialog = new TextInputDialog(queryValues[1]);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setTitle(title);
        dialog.setContentText("Название:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(value ->
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.statement.executeUpdate(
                        String.format(queryValues[0], value, queryValues[1]));
                AppCore.showAlert(successText);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert(failText);
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        });

        show_CommonCatalog(curTable);
    }

    private void delete_Base(String title, String query)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText("Выбранная запись будет удалена.\nПродолжить?");

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK)
        {
            try {
                AppCore.statement = AppCore.connection.createStatement();
                AppCore.statement.executeUpdate(String.format(
                        query, commonCatalog_TABLE.getSelectionModel().getSelectedItem().getField_01()));
                AppCore.showAlert("Запись удалена");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                AppCore.showAlert("Не удалось провести удаление");
            }
            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        show_CommonCatalog(curTable);
    }

    // Client cities =====================================
    // search
    private void searchRecord_Cities()
    { search_Base("Поиск города клиентов", QrsCommonCatalogs.SELECT_CLIENT_CITIES_2SEARCH); }

    // add
    private void addRecord_Cities()
    {
        proc_Base("Добавление нового города клиентов",
                new String[] {QrsCommonCatalogs.ADD_CLIENT_CITIES, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // change
    private void changeRecord_Cities()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Base("Изменение города клиентов", new String[] {QrsCommonCatalogs.CHANGE_CLIENT_CITIES,
                        commonCatalog_TABLE.getSelectionModel().getSelectedItem().getField_01()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_Cities()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        delete_Base("Удаление города клиентов", QrsCommonCatalogs.DELETE_CLIENT_CITIES);
    }

    // Transaction types =====================================
    // search
    private void searchRecord_TransactionTypes()
    { search_Base("Поиск типа транзакций", QrsCommonCatalogs.SELECT_TRANSACTION_TYPES_2SEARCH); }

    // add
    private void addRecord_TransactionTypes()
    {
        proc_Base("Добавление нового типа транзакций",
                new String[]{QrsCommonCatalogs.ADD_TRANSACTION_TYPES, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // change
    private void changeRecord_TransactionTypes()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Base("Изменение типа транзакций", new String[] {QrsCommonCatalogs.CHANGE_TRANSACTION_TYPES,
                        commonCatalog_TABLE.getSelectionModel().getSelectedItem().getField_01()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_TransactionTypes()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        delete_Base("Удаление типа транзакций", QrsCommonCatalogs.DELETE_TRANSACTION_TYPES);
    }

    // Services =====================================
    // search
    private void searchRecord_Services()
    { search_Base("Поиск услуги", QrsCommonCatalogs.SELECT_SERVICES_2SEARCH); }

    // add
    private void addRecord_Services()
    {
        proc_Base("Добавление новой услуги",
                new String[]{QrsCommonCatalogs.ADD_SERVICES, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // change
    private void changeRecord_Services()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Base("Изменение услуги", new String[] {QrsCommonCatalogs.CHANGE_SERVICES,
                        commonCatalog_TABLE.getSelectionModel().getSelectedItem().getField_01()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_Services()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        delete_Base("Удаление услуги", QrsCommonCatalogs.DELETE_SERVICES);
    }

    // Charge types =====================================
    // search
    private void searchRecord_ChargeTypes()
    { search_Base("Поиск типа оплаты", QrsCommonCatalogs.SELECT_CHARGE_TYPES_2SEARCH); }

    // add
    private void addRecord_ChargeTypes()
    {
        proc_Base("Добавление нового типа оплаты",
                new String[]{QrsCommonCatalogs.ADD_CHARGE_TYPES, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // change
    private void changeRecord_ChargeTypes()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Base("Изменение типа оплаты", new String[] {QrsCommonCatalogs.CHANGE_CHARGE_TYPES,
                        commonCatalog_TABLE.getSelectionModel().getSelectedItem().getField_01()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_ChargeTypes()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        delete_Base("Удаление типа оплаты", QrsCommonCatalogs.DELETE_CHARGE_TYPES);
    }

    // Contract statuses =====================================
    // search
    private void searchRecord_ContractStatuses()
    { search_Base("Поиск статуса контрактов", QrsCommonCatalogs.SELECT_CONTRACT_STATUSES_2SEARCH); }

    // add
    private void addRecord_ContractStatuses()
    {
        proc_Base("Добавление нового статуса контрактов",
                new String[]{QrsCommonCatalogs.ADD_CONTRACT_STATUSES, null},
                "Новая запись добавлена", "Не удалось добавить запись");
    }

    // change
    private void changeRecord_ContractStatuses()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        proc_Base("Изменение статуса контрактов", new String[] {QrsCommonCatalogs.CHANGE_CONTRACT_STATUSES,
                        commonCatalog_TABLE.getSelectionModel().getSelectedItem().getField_01()},
                "Запись обновлена", "Не удалось обновить запись");
    }

    // delete
    private void deleteRecord_ContractStatuses()
    {
        if (commonCatalog_TABLE.getSelectionModel().getSelectedItem() == null)
        { AppCore.showAlert("Для выполнения действия\nсначала выберите строку"); return; }
        delete_Base("Удаление статуса контрактов", QrsCommonCatalogs.DELETE_CONTRACT_STATUSES);
    }
// endregion

    //////////////////////// BTNs CONTROLS //////////////////////////////
    @FXML
    void initialize()
    {
        AppCore.mainController = this;

        toMain_BTN.setDisable(true);
        subMenu_BOX.setVisible(false);
        titleText_BOX.toFront();

        toMain_BTN.setOnAction(event ->
        {
            toMain_BTN.setDisable(true);
            subMenu_BOX.setVisible(false);
            titleText_BOX.toFront();
        });

        generation_BTN.setOnAction(event ->
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setGraphic(null);
            alert.setHeaderText(null);
            alert.setTitle("Воссоздание данных базы");
            alert.setContentText("""
                                Все данные основных таблиц из базы
                                будут безвозвратно удалены.
                                После чего база будет наполнена
                                стортовым набором значений.
                                
                                ПРОДОЛЖИТЬ?""");

            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == ButtonType.OK)
            {
                try {
                    AppCore.statement = AppCore.connection.createStatement();
                    StringBuilder query = new StringBuilder();

                    String divide = ";\n";
                    query               .append(GenerateQrsData.truncate);
                    query.append(divide).append(GenerateQrsData.insertHeader_TechInf);
                    query.append(GenerateQrsData.insertData_TechInf.      repeat(100)); query.delete(query.length() - 1, query.length());
                    query.append(divide).append(GenerateQrsData.insertHeader_Clients);
                    query.append(GenerateQrsData.insertData_Clients.      repeat(150)); query.delete(query.length() - 1, query.length());
                    query.append(divide).append(GenerateQrsData.insertHeader_Bills);
                    query.append(GenerateQrsData.insertData_Bills.        repeat(100)); query.delete(query.length() - 1, query.length());
                    query.append(divide).append(GenerateQrsData.insertHeader_Contracts);
                    query.append(GenerateQrsData.insertData_Contracts.    repeat(200)); query.delete(query.length() - 1, query.length());
                    query.append(divide).append(GenerateQrsData.insertHeader_Tariffs);
                    query.append(GenerateQrsData.insertData_Tariffs.      repeat(5)); query.delete(query.length() - 1, query.length());
                    query.append(divide).append(GenerateQrsData.insertHeader_ContractParts);
                    query.append(GenerateQrsData.insertData_ContractParts.repeat(250)); query.delete(query.length() - 1, query.length());
                    query.append(divide).append(GenerateQrsData.insertHeader_FinOps);
                    query.append(GenerateQrsData.insertData_FinOps.       repeat(200)); query.delete(query.length() - 1, query.length());

                    AppCore.statement.executeUpdate(query.toString());
                    AppCore.showAlert("База данных воссоздана");
                }
                catch (Exception e) { e.printStackTrace(); AppCore.showAlert("Не удалось воссоздать базу данных"); }
                try { AppCore.statement.close(); AppCore.connection.commit(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        });

// region SHOW group
        //  Clients BTNs
        //   choices
        techInf_ClientsF_CHOICE.setOnAction(event ->
        {
            if (techInf_ClientsF_CHOICE.getValue() != null && techInf_ClientsF_CHOICE.getValue().equals(""))
                techInf_ClientsF_CHOICE.setValue(null);
        });

        city_ClientsF_CHOICE.setOnAction(event ->
        {
            if (city_ClientsF_CHOICE.getValue() != null && city_ClientsF_CHOICE.getValue().equals(""))
                city_ClientsF_CHOICE.setValue(null);
        });

        //   control
        use_ClientsF_BTN.setOnAction(event ->
        {
            switch (actionType)
            {
                case "add" ->
                {
                    if (!name_ClientsF_FIELD.getText().equals("") &&
                        techInf_ClientsF_CHOICE.getValue() != null &&
                        city_ClientsF_CHOICE.getValue() != null &&
                        !address_ClientsF_FIELD.getText().equals("") &&
                        !contactInf_ClientsF_FIELD.getText().equals(""))
                    {
                        try {
                            String tempStr = techInf_ClientsF_CHOICE.getValue();
                            AppCore.statement = AppCore.connection.createStatement();
                            AppCore.statement.executeUpdate(
                                    String.format(QrsClients.ADD_RECORD,
                                            name_ClientsF_FIELD.getText(),
                                            tempStr.substring(tempStr.indexOf('[') + 1, tempStr.indexOf(']')),
                                            city_ClientsF_CHOICE.getValue(),
                                            address_ClientsF_FIELD.getText(),
                                            contactInf_ClientsF_FIELD.getText()
                                            ));
                            AppCore.showAlert("Новая запись добавлена");
                            recordsCounter_FIELD.setText("Всего записей: " + ++recordsCount);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            AppCore.showAlert("Не удалось добавить запись");
                        }
                        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                        catch (Exception e) { e.printStackTrace(); }
                    }
                    else { AppCore.showAlert("Не все поля заполнены\nДобавление невозможно"); }
                }
                case "choice_change" -> changeRecord_ClientsF();
                case "change" ->
                {
                    try {
                        String tempInputted = techInf_ClientsF_CHOICE.getValue();
                        tempInputted = tempInputted.substring(tempInputted.indexOf('[') + 1, tempInputted.indexOf(']'));
                        String tempCur = records.get(curRecord - 1).get(1);
                        tempCur = tempCur.substring(tempCur.indexOf('[') + 1, tempCur.indexOf(']'));

                        AppCore.statement = AppCore.connection.createStatement();
                        AppCore.statement.executeUpdate(String.format(
                                QrsClients.UPDATE_RECORD,
                                name_ClientsF_FIELD.getText(),
                                tempInputted,
                                city_ClientsF_CHOICE.getValue(),
                                address_ClientsF_FIELD.getText(),
                                contactInf_ClientsF_FIELD.getText(),
                                records.get(curRecord - 1).get(0),
                                tempCur,
                                records.get(curRecord - 1).get(2),
                                records.get(curRecord - 1).get(3),
                                records.get(curRecord - 1).get(4)
                        ));
                        AppCore.showAlert("Запись обновлена");
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        AppCore.showAlert("Не удалось обновить запись");
                    }
                    try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                    catch (Exception e) { e.printStackTrace(); }
                }
                case "choice_delete" -> deleteRecord_ClientsF();
                case "search" -> searchRecord_Clients();
            }
        });

        cancel_ClientsF_BTN.setOnAction(event -> show_Clients("asTable"));

        //   cur control
        prev_ClientsF_BTN.setOnAction(event ->
        {
            curRecord--;
            if (curRecord == 0) curRecord = records.size();
            showRecord_ClientsF();
        });

        cur_ClientsF_FIELD.setOnAction(event ->
        {
            if (curRecord_changed)
            {
                int newValue = -1;
                try { newValue = Integer.parseInt(cur_ClientsF_FIELD.getText()); } catch (Exception ignored) { }
                if (newValue > 0 && newValue <= records.size()) curRecord = newValue;
                showRecord_ClientsF();
            }
        });
        cur_ClientsF_FIELD.textProperty().addListener((observable, oldValue, newValue) -> curRecord_changed = true);

        next_ClientsF_BTN.setOnAction(event ->
        {
            curRecord++;
            if (curRecord > records.size()) curRecord = 1;
            showRecord_ClientsF();
        });

        //  TechInf BTNs
        //   limits
        speed_TechInfF_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (speed_TechInfF_FIELD.isEditable())
                if (!newValue.equals("")) if (Integer.parseInt(newValue) < 10 || Integer.parseInt(newValue) > 500)
                { speed_TechInfF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                    use_TechInfF_BTN.setDisable(true); }
                else { speed_TechInfF_FIELD.setStyle(null);
                    if (!operationDate_FinOpsF_FIELD.getStyle().contains("#ffbb99")) use_TechInfF_BTN.setDisable(false); }
        });

        //   control
        use_TechInfF_BTN.setOnAction(event ->
        {
            switch (actionType)
            {
                case "add" ->
                {
                    if (!drSR_TechInfF_FIELD.getText().equals("") &&
                        !serverID_TechInfF_FIELD.getText().equals("") &&
                        !portSAP_TechInfF_FIELD.getText().equals("") &&
                        !speed_TechInfF_FIELD.getText().equals("") &&
                        !ip_TechInfF_FIELD.getText().equals("") &&
                        !scheme_TechInfF_FIELD.getText().equals("") &&
                        !pm_TechInfF_FIELD.getText().equals(""))
                    {
                        try {
                            AppCore.statement = AppCore.connection.createStatement();
                            AppCore.statement.executeUpdate(
                                    String.format(QrsTechInf.ADD_RECORD,
                                            drSR_TechInfF_FIELD.getText(),
                                            serverID_TechInfF_FIELD.getText(),
                                            portSAP_TechInfF_FIELD.getText(),
                                            speed_TechInfF_FIELD.getText(),
                                            ip_TechInfF_FIELD.getText(),
                                            scheme_TechInfF_FIELD.getText(),
                                            pm_TechInfF_FIELD.getText()
                                    ));
                            AppCore.showAlert("Новая запись добавлена");
                            recordsCounter_FIELD.setText("Всего записей: " + ++recordsCount);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            AppCore.showAlert("Не удалось добавить запись");
                        }
                        try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                        catch (Exception e) { e.printStackTrace(); }
                    }
                    else { AppCore.showAlert("Не все поля заполнены\nДобавление невозможно"); }
                }
                case "choice_change" -> changeRecord_TechInfF();
                case "change" ->
                {
                    try {
                        AppCore.statement = AppCore.connection.createStatement();
                        AppCore.statement.executeUpdate(String.format(
                                QrsTechInf.UPDATE_RECORD,
                                drSR_TechInfF_FIELD.getText(),
                                serverID_TechInfF_FIELD.getText(),
                                portSAP_TechInfF_FIELD.getText(),
                                speed_TechInfF_FIELD.getText(),
                                ip_TechInfF_FIELD.getText(),
                                scheme_TechInfF_FIELD.getText(),
                                pm_TechInfF_FIELD.getText(),
                                records.get(curRecord - 1).get(0),
                                records.get(curRecord - 1).get(1),
                                records.get(curRecord - 1).get(2),
                                records.get(curRecord - 1).get(3),
                                records.get(curRecord - 1).get(4),
                                records.get(curRecord - 1).get(5),
                                records.get(curRecord - 1).get(6)
                        ));
                        AppCore.showAlert("Запись обновлена");
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        AppCore.showAlert("Не удалось обновить запись");
                    }
                    try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                    catch (Exception e) { e.printStackTrace(); }
                }
                case "choice_delete" -> deleteRecord_TechInfF();
                case "search" -> searchRecord_TechInf();
            }
        });

        cancel_TechInfF_BTN.setOnAction(event -> show_TechInf("asTable"));

        //   cur control
        prev_TechInfF_BTN.setOnAction(event ->
        {
            curRecord--;
            if (curRecord == 0) curRecord = records.size();
            showRecord_TechInfF();
        });

        cur_TechInfF_FIELD.setOnAction(event ->
        {
            if (curRecord_changed)
            {
                int newValue = -1;
                try { newValue = Integer.parseInt(cur_TechInfF_FIELD.getText()); } catch (Exception ignored) { }
                if (newValue > 0 && newValue <= records.size()) curRecord = newValue;
                showRecord_TechInfF();
            }
        });
        cur_TechInfF_FIELD.textProperty().addListener((observable, oldValue, newValue) -> curRecord_changed = true);

        next_TechInfF_BTN.setOnAction(event ->
        {
            curRecord++;
            if (curRecord > records.size()) curRecord = 1;
            showRecord_TechInfF();
        });

        //  Contracts BTNs
        //   limits
        preparationDate_ContractsF_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (preparationDate_ContractsF_FIELD.isEditable())
                if (!newValue.equals("")) {String[] date = newValue.split("[-./]+");
                    if (date.length != 3 || (date[0].length() != 4 && date[2].length() != 4) ||
                            ((date[0].length() == 4 && ((Integer.parseInt(date[0]) < 1980) || (Integer.parseInt(date[0]) > 2025) || (Integer.parseInt(date[1]) < 1) || (Integer.parseInt(date[1]) > 12) || (Integer.parseInt(date[2]) < 1) || (Integer.parseInt(date[2]) > 31))) ||
                             (date[2].length() == 4 && ((Integer.parseInt(date[2]) < 1980) || (Integer.parseInt(date[2]) > 2025) || (Integer.parseInt(date[1]) < 1) || (Integer.parseInt(date[1]) > 12) || (Integer.parseInt(date[0]) < 1) || (Integer.parseInt(date[0]) > 31)))))
                    {
                        preparationDate_ContractsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                        use_ContractsF_BTN.setDisable(true);   }
                    else { preparationDate_ContractsF_FIELD.setStyle(null);
                           if (!startDate_ContractsF_FIELD.getStyle().contains("#ffbb99") && !endDate_ContractsF_FIELD.getStyle().contains("#ffbb99"))
                             use_ContractsF_BTN.setDisable(false); }
                }
        });
        startDate_ContractsF_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (startDate_ContractsF_FIELD.isEditable() && !actionType.equals("search") && !actionType.contains("choice"))
                if (!newValue.equals("")) {String[] startDate = newValue.split("[-./]+");
                    if (startDate.length != 3 || (startDate[0].length() != 4 && startDate[2].length() != 4) || (preparationDate_ContractsF_FIELD.getStyle().contains("#ffbb99")) || preparationDate_ContractsF_FIELD.getText().equals("") ||
                            ((startDate[0].length() == 4 && ((Integer.parseInt(startDate[0]) < 1980) || (Integer.parseInt(startDate[0]) > 2025) || (Integer.parseInt(startDate[1]) < 1) || (Integer.parseInt(startDate[1]) > 12) || (Integer.parseInt(startDate[2]) < 1) || (Integer.parseInt(startDate[2]) > 31))) ||
                             (startDate[2].length() == 4 && ((Integer.parseInt(startDate[2]) < 1980) || (Integer.parseInt(startDate[2]) > 2025) || (Integer.parseInt(startDate[1]) < 1) || (Integer.parseInt(startDate[1]) > 12) || (Integer.parseInt(startDate[0]) < 1) || (Integer.parseInt(startDate[0]) > 31)))))
                    {
                        startDate_ContractsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                        use_ContractsF_BTN.setDisable(true);   }
                    else {
                        String[] preparationDate = newValue.split("[-./]+");
                        if (preparationDate[0].length() != 4) { String temp = preparationDate[0]; preparationDate[0] = preparationDate[2]; preparationDate[2] = temp; }
                        if (startDate[0].length() != 4) { String temp = startDate[0]; startDate[0] = startDate[2]; startDate[2] = temp; }
                        if ((Integer.parseInt(startDate[0]) < Integer.parseInt(preparationDate[0])) ||
                            (Integer.parseInt(startDate[1]) < Integer.parseInt(preparationDate[1])) ||
                            (Integer.parseInt(startDate[2]) < Integer.parseInt(preparationDate[2])))
                         {
                            startDate_ContractsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                            use_ContractsF_BTN.setDisable(true);}
                         else {startDate_ContractsF_FIELD.setStyle(null);
                            if (!preparationDate_ContractsF_FIELD.getStyle().contains("#ffbb99") &&
                                !endDate_ContractsF_FIELD.getStyle().contains("#ffbb99"))
                                use_ContractsF_BTN.setDisable(false); }}
                }
        });
        endDate_ContractsF_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (endDate_ContractsF_FIELD.isEditable() && !actionType.equals("search") && !actionType.contains("choice"))
                if (!newValue.equals("")) {String[] endDate = newValue.split("[-./]+");
                    if (endDate.length != 3 || (endDate[0].length() != 4 && endDate[2].length() != 4) || (startDate_ContractsF_FIELD.getStyle().contains("#ffbb99")) || startDate_ContractsF_FIELD.getText().equals("") ||
                            ((endDate[0].length() == 4 && ((Integer.parseInt(endDate[0]) < 1980) || (Integer.parseInt(endDate[0]) > 2035) || (Integer.parseInt(endDate[1]) < 1) || (Integer.parseInt(endDate[1]) > 12) || (Integer.parseInt(endDate[2]) < 1) || (Integer.parseInt(endDate[2]) > 31))) ||
                             (endDate[2].length() == 4 && ((Integer.parseInt(endDate[2]) < 1980) || (Integer.parseInt(endDate[2]) > 2035) || (Integer.parseInt(endDate[1]) < 1) || (Integer.parseInt(endDate[1]) > 12) || (Integer.parseInt(endDate[0]) < 1) || (Integer.parseInt(endDate[0]) > 31)))))
                    {
                        endDate_ContractsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                        use_ContractsF_BTN.setDisable(true);   }
                    else {
                        String[] startDate = newValue.split("[-./]+");
                        if (startDate[0].length() != 4) { String temp = startDate[0]; startDate[0] = startDate[2]; startDate[2] = temp; }
                        if (endDate[0].length() != 4) { String temp = endDate[0]; endDate[0] = endDate[2]; endDate[2] = temp; }
                        if ((Integer.parseInt(endDate[0]) < Integer.parseInt(startDate[0])) ||
                            (Integer.parseInt(endDate[1]) < Integer.parseInt(startDate[1])) ||
                            (Integer.parseInt(endDate[2]) < Integer.parseInt(startDate[2])))
                        {
                            endDate_ContractsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                            use_ContractsF_BTN.setDisable(true);}
                        else {endDate_ContractsF_FIELD.setStyle(null);
                            if (!preparationDate_ContractsF_FIELD.getStyle().contains("#ffbb99") &&
                                !startDate_ContractsF_FIELD.getStyle().contains("#ffbb99"))
                                use_ContractsF_BTN.setDisable(false); }}
                }
        });

        //   choices
        client_ContractsF_CHOICE.setOnAction(event ->
        {
            if (client_ContractsF_CHOICE.getValue() != null && client_ContractsF_CHOICE.getValue().equals(""))
                client_ContractsF_CHOICE.setValue(null);
        });

        status_ContractsF_CHOICE.setOnAction(event ->
        {
            if (status_ContractsF_CHOICE.getValue() != null && status_ContractsF_CHOICE.getValue().equals(""))
                status_ContractsF_CHOICE.setValue(null);
        });

        //   control
        use_ContractsF_BTN.setOnAction(event ->
        {
            switch (actionType)
            {
                case "add" ->
                        {
                            if (!name_ContractsF_FIELD           .getText().equals("") &&
                                 client_ContractsF_CHOICE        .getValue() != null   &&
                                !preparationDate_ContractsF_FIELD.getText().equals("") &&
                                !startDate_ContractsF_FIELD      .getText().equals("") &&
                                 status_ContractsF_CHOICE        .getValue() != null)
                            {
                                try {
                                    String tempStr = client_ContractsF_CHOICE.getValue();
                                    AppCore.statement = AppCore.connection.createStatement();
                                    AppCore.statement.executeUpdate(
                                            String.format(QrsContracts.ADD_RECORD,
                                                    name_ContractsF_FIELD.getText(),
                                                    tempStr.substring(tempStr.indexOf('[') + 1, tempStr.indexOf(']')),
                                                    preparationDate_ContractsF_FIELD.getText(),
                                                    startDate_ContractsF_FIELD.getText(),
                                                    status_ContractsF_CHOICE.getValue(),
                                                    !endDate_ContractsF_FIELD.getText().equals("") ? endDate_ContractsF_FIELD.getText() : "null"
                                            ));
                                    AppCore.showAlert("Новая запись добавлена");
                                    recordsCounter_FIELD.setText("Всего записей: " + ++recordsCount);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                    AppCore.showAlert("Не удалось добавить запись");
                                }
                                try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                                catch (Exception e) { e.printStackTrace(); }
                            }
                            else { AppCore.showAlert("Не все поля заполнены\nДобавление невозможно"); }
                        }
                case "choice_change" -> changeRecord_ContractsF();
                case "change" ->
                        {
                            try {
                                String tempInputted = client_ContractsF_CHOICE.getValue();
                                tempInputted = tempInputted.substring(tempInputted.indexOf('[') + 1, tempInputted.indexOf(']'));
                                String tempCur = records.get(curRecord - 1).get(1);
                                tempCur      = tempCur     .substring(tempCur     .indexOf('[') + 1, tempCur     .indexOf(']'));

                                AppCore.statement = AppCore.connection.createStatement();
                                AppCore.statement.executeUpdate(String.format(
                                        QrsContracts.UPDATE_RECORD,
                                        name_ContractsF_FIELD.getText(),
                                        tempInputted,
                                        preparationDate_ContractsF_FIELD.getText(),
                                        startDate_ContractsF_FIELD.getText(),
                                        status_ContractsF_CHOICE.getValue(),
                                        endDate_ContractsF_FIELD.getText(),
                                        records.get(curRecord - 1).get(0),
                                        tempCur,
                                        records.get(curRecord - 1).get(2),
                                        records.get(curRecord - 1).get(3),
                                        records.get(curRecord - 1).get(4),
                                        records.get(curRecord - 1).get(5)
                                ));
                                AppCore.showAlert("Запись обновлена");
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                                AppCore.showAlert("Не удалось обновить запись");
                            }
                            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                            catch (Exception e) { e.printStackTrace(); }
                        }
                case "choice_delete" -> deleteRecord_ContractsF();
                case "search" -> searchRecord_Contracts();
            }
        });

        cancel_ContractsF_BTN.setOnAction(event -> show_Contracts("asTable"));

        //   cur control
        prev_ContractsF_BTN.setOnAction(event ->
        {
            curRecord--;
            if (curRecord == 0) curRecord = records.size();
            showRecord_ContractsF();
        });

        cur_ContractsF_FIELD.setOnAction(event ->
        {
            if (curRecord_changed)
            {
                int newValue = -1;
                try { newValue = Integer.parseInt(cur_ContractsF_FIELD.getText()); } catch (Exception ignored) { }
                if (newValue > 0 && newValue <= records.size()) curRecord = newValue;
                showRecord_ContractsF();
            }
        });
        cur_ContractsF_FIELD.textProperty().addListener((observable, oldValue, newValue) -> curRecord_changed = true);

        next_ContractsF_BTN.setOnAction(event ->
        {
            curRecord++;
            if (curRecord > records.size()) curRecord = 1;
            showRecord_ContractsF();
        });

        //  FinOps BTNs
        //   limits
        sum_FinOpsF_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
        {   try {
            if (sum_FinOpsF_FIELD.isEditable())
                if (!newValue.equals(""))
                {
                    float parsed = Float.parseFloat(newValue);
                    if (parsed < 10 || parsed > 100000)
                    { sum_FinOpsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                      use_FinOpsF_BTN.setDisable(true); }
                    else { sum_FinOpsF_FIELD.setStyle(null);
                           if (!operationDate_FinOpsF_FIELD.getStyle().contains("#ffbb99")) use_FinOpsF_BTN.setDisable(false); }
                }
            } catch (NumberFormatException ignored) {}
        });
        operationDate_FinOpsF_FIELD.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (operationDate_FinOpsF_FIELD.isEditable())
                if (!newValue.equals("")) {String[] date = newValue.split("[-./]+");
                    if (date.length != 3 || (date[0].length() != 4 && date[2].length() != 4) ||
                       ((date[0].length() == 4 && ((Integer.parseInt(date[0]) < 1980) || (Integer.parseInt(date[0]) > 2025) || (Integer.parseInt(date[1]) < 1) || (Integer.parseInt(date[1]) > 12) || (Integer.parseInt(date[2]) < 1) || (Integer.parseInt(date[2]) > 31))) ||
                        (date[2].length() == 4 && ((Integer.parseInt(date[2]) < 1980) || (Integer.parseInt(date[2]) > 2025) || (Integer.parseInt(date[1]) < 1) || (Integer.parseInt(date[1]) > 12) || (Integer.parseInt(date[0]) < 1) || (Integer.parseInt(date[0]) > 31)))))
                    {
                        operationDate_FinOpsF_FIELD.setStyle("-fx-background-color: #ffbb99;");
                        use_FinOpsF_BTN.setDisable(true);   }
                    else { operationDate_FinOpsF_FIELD.setStyle(null);
                           if (!sum_FinOpsF_FIELD.getStyle().contains("#ffbb99")) use_FinOpsF_BTN.setDisable(false); }
                }
        });

        //   choices
        bill_FinOpsF_CHOICE.setOnAction(event ->
        {
            if (bill_FinOpsF_CHOICE.getValue() != null && bill_FinOpsF_CHOICE.getValue().equals(""))
                bill_FinOpsF_CHOICE.setValue(null);
        });

        transactionType_FinOpsF_CHOICE.setOnAction(event ->
        {
            if (transactionType_FinOpsF_CHOICE.getValue() != null && transactionType_FinOpsF_CHOICE.getValue().equals(""))
                transactionType_FinOpsF_CHOICE.setValue(null);
        });

        contractPart_FinOpsF_CHOICE.setOnAction(event ->
        {
            if (contractPart_FinOpsF_CHOICE.getValue() != null && contractPart_FinOpsF_CHOICE.getValue().equals(""))
                contractPart_FinOpsF_CHOICE.setValue(null);
        });

        //   control
        use_FinOpsF_BTN.setOnAction(event ->
        {
            switch (actionType)
            {
                case "add" ->
                        {
                            if (bill_FinOpsF_CHOICE.getValue() != null &&
                                transactionType_FinOpsF_CHOICE.getValue() != null &&
                                !sum_FinOpsF_FIELD.getText().equals("") &&
                                !operationDate_FinOpsF_FIELD.getText().equals(""))
                            {
                                try {
                                    String tempBill = bill_FinOpsF_CHOICE.getValue();
                                    String tempContractPart = contractPart_FinOpsF_CHOICE.getValue();
                                    AppCore.statement = AppCore.connection.createStatement();
                                    AppCore.statement.executeUpdate(
                                            String.format(QrsFinOps.ADD_RECORD,
                                                    tempBill.substring(tempBill.indexOf('[') + 1, tempBill.indexOf(']')),
                                                    transactionType_FinOpsF_CHOICE.getValue(),
                                                    sum_FinOpsF_FIELD.getText(),
                                                    operationDate_FinOpsF_FIELD.getText(),
                                                    tempContractPart != null ? tempContractPart.substring(tempContractPart.indexOf('[') + 1, tempContractPart.indexOf(']')) : "null",
                                                    !comment_FinOpsF_FIELD.getText().equals("") ? comment_FinOpsF_FIELD.getText() : ""
                                            ));
                                    AppCore.showAlert("Новая запись добавлена");
                                    recordsCounter_FIELD.setText("Всего записей: " + ++recordsCount);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                    AppCore.showAlert("Не удалось добавить запись");
                                }
                                try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                                catch (Exception e) { e.printStackTrace(); }
                            }
                            else { AppCore.showAlert("Не все поля заполнены\nДобавление невозможно"); }
                        }
                case "choice_change" -> changeRecord_FinOpsF();
                case "change" ->
                        {
                            try {
                                String inputtedBill = bill_FinOpsF_CHOICE.getValue();
                                inputtedBill = inputtedBill.substring(
                                        inputtedBill.indexOf('[') + 1, inputtedBill.indexOf(']'));
                                String inputtedContractPart = contractPart_FinOpsF_CHOICE.getValue();
                                inputtedContractPart = inputtedContractPart.substring(
                                        inputtedContractPart.indexOf('[') + 1, inputtedContractPart.indexOf(']'));
                                String curBill = records.get(curRecord - 1).get(0);
                                curBill = curBill.substring(
                                        curBill.indexOf('[') + 1, curBill.indexOf(']'));
                                String curContractPart = records.get(curRecord - 1).get(4);
                                curContractPart = curContractPart.substring(
                                        curContractPart.indexOf('[') + 1, curContractPart.indexOf(']'));

                                AppCore.statement = AppCore.connection.createStatement();
                                AppCore.statement.executeUpdate(String.format(
                                        QrsFinOps.UPDATE_RECORD,
                                        inputtedBill,
                                        transactionType_FinOpsF_CHOICE.getValue(),
                                        sum_FinOpsF_FIELD.getText(),
                                        operationDate_FinOpsF_FIELD.getText(),
                                        inputtedContractPart,
                                        comment_FinOpsF_FIELD.getText(),
                                        curBill,
                                        records.get(curRecord - 1).get(1),
                                        records.get(curRecord - 1).get(2),
                                        records.get(curRecord - 1).get(3),
                                        curContractPart,
                                        records.get(curRecord - 1).get(5)
                                ));
                                AppCore.showAlert("Запись обновлена");
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                                AppCore.showAlert("Не удалось обновить запись");
                            }
                            try { AppCore.resultSet.close(); AppCore.statement.close(); AppCore.connection.commit(); }
                            catch (Exception e) { e.printStackTrace(); }
                        }
                case "choice_delete" -> deleteRecord_FinOpsF();
                case "search" -> searchRecord_FinOps();
            }
        });

        cancel_FinOpsF_BTN.setOnAction(event -> show_FinOps("asTable"));

        //   cur control
        prev_FinOpsF_BTN.setOnAction(event ->
        {
            curRecord--;
            if (curRecord == 0) curRecord = records.size();
            showRecord_FinOpsF();
        });

        cur_FinOpsF_FIELD.setOnAction(event ->
        {
            if (curRecord_changed)
            {
                int newValue = -1;
                try { newValue = Integer.parseInt(cur_FinOpsF_FIELD.getText()); } catch (Exception ignored) { }
                if (newValue > 0 && newValue <= records.size()) curRecord = newValue;
                showRecord_FinOpsF();
            }
        });
        cur_FinOpsF_FIELD.textProperty().addListener((observable, oldValue, newValue) -> curRecord_changed = true);

        next_FinOpsF_BTN.setOnAction(event ->
        {
            curRecord++;
            if (curRecord > records.size()) curRecord = 1;
            showRecord_FinOpsF();
        });
// endregion
// region MENU group
        //  dictionaries =========================================
        transactionTypes_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "transaction_types";
            show_CommonCatalog(curTable);
        });
        services_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "services";
            show_CommonCatalog(curTable);
        });
        paymentTypes_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "charge_types";
            show_CommonCatalog(curTable);
        });
        tariffs_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "tariffs";
            show_CommonCatalog(curTable);
        });
        contractStatuses_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "contract_statuses";
            show_CommonCatalog(curTable);
        });
        clientCities_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "client_cities";
            show_CommonCatalog(curTable);
        });

        //  main tables =============================================
        finOps_BTN.setOnAction(event ->
        {
            curTable = "financial_operations";
            show_FinOps("asTable");
        });
        clients_BTN.setOnAction(event ->
        {
            curTable = "clients";
            show_Clients("asTable");
        });

        //  extra tables =================================
        contractParts_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "contract_parts";
            show_CommonCatalog(curTable);
        });
        contracts_BTN.setOnAction(event ->
        {
            curTable = "contracts";
            show_Contracts("asTable");
        });
        techInf_BTN.setOnAction(event ->
        {
            curTable = "technical_information";
            show_TechInf("asTable");
        });
        bills_BTN.setOnAction(event ->
        {
            tableShowType_BTN.setSelected(false);
            recordsShowType_BTN.setSelected(false);

            curTable = "bills";
            show_CommonCatalog(curTable);
        });

        //  special queries
        INNER_WHERE_FK_Tariffs_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите название услуги,\nтарифы с которой будут найдены");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Наименование:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"INNER_WHERE_FK_Tariffs", value});
                AppCore.stages.get("Queries").show();
            });
        });
        INNER_WHERE_FK_Contracts_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите наименование клиента,\nконтракты которого буду отобраны");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Наименование:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"INNER_WHERE_FK_Contracts", value});
                AppCore.stages.get("Queries").show();
            });
        });
        INNER_WHERE_DATE_FinOps_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите дату искомых финансовых операций");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Дата:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"INNER_WHERE_DATE_FinOps", value});
                AppCore.stages.get("Queries").show();
            });
        });
        INNER_WHERE_DATE_Contracts_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите год завершения искомых контрактов");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Год:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"INNER_WHERE_DATE_Contracts", value});
                AppCore.stages.get("Queries").show();
            });
        });
        //  ===============
        INNER_no_WHERE_Clients_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"INNER_no_WHERE_Clients"});
            AppCore.stages.get("Queries").show(); });
        INNER_no_WHERE_Tariffs_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"INNER_no_WHERE_Tariffs"});
            AppCore.stages.get("Queries").show(); });
        INNER_no_WHERE_ContractParts_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"INNER_no_WHERE_ContractParts"});
            AppCore.stages.get("Queries").show(); });
        //  ===============
        LEFT_OUTER_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"LEFT_OUTER"});
            AppCore.stages.get("Queries").show(); });
        RIGHT_OUTER_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите наименование клиента, о котором\nбудет выведена более подробная информация");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Наименование:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"RIGHT_OUTER", value});
                AppCore.stages.get("Queries").show();
            });
        });
        SELECT_$_FROM_SELECT_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"SELECT_$_FROM_SELECT"});
            AppCore.stages.get("Queries").show(); });
        //  ===============
        AGGREGATE_no_WHERE_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"AGGREGATE_no_WHERE"});
            AppCore.stages.get("Queries").show(); });
        AGGREGATE_WHERE_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите название услуги,\nтарифы с которой будут оценены");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Услуга:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"AGGREGATE_WHERE", value});
                AppCore.stages.get("Queries").show();
            });
        });
        AGGREGATE_HAVING_BTN.setOnAction(event ->
        {
            AppCore.queriesController.callQuery(new String[] {"AGGREGATE_HAVING"});
            AppCore.stages.get("Queries").show();
        });
        AGGREGATE_WHERE_HAVING_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите наименование проверяемого клиента");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Наименование:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"AGGREGATE_WHERE_HAVING", value});
                AppCore.stages.get("Queries").show();
            });
        });
        AGGREGATE_$_FROM_SELECT_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"AGGREGATE_$_FROM_SELECT"});
            AppCore.stages.get("Queries").show(); });
        SELECT_$_WHERE_SELECT_BTN.setOnAction(event ->
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите часть наименования искомых клиентов");
            dialog.setTitle("Данные для запроса");
            dialog.setContentText("Часть наименования:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(value -> {
                AppCore.queriesController.callQuery(new String[] {"SELECT_$_WHERE_SELECT", value});
                AppCore.stages.get("Queries").show();
            });
        });
        //  ===============
        SPECIAL_QR_1_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"SPECIAL_QR_1"});
            AppCore.stages.get("Queries").show(); });
        SPECIAL_QR_2_BTN.setOnAction(event -> {
            AppCore.queriesController.callQuery(new String[] {"SPECIAL_QR_2"});
            AppCore.stages.get("Queries").show(); });
        SPECIAL_QR_3_BTN.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setGraphic(null);
            dialog.setHeaderText("Введите даты границ промежутка\nсовершения финансовых операций\nдля отображения к-ва клиентов");
            dialog.setTitle("Данные для запроса");

            GridPane insideArea = new GridPane();
            Label startDate_LBL = new Label("Начальная дата:"); TextField startDate_FIELD = new TextField("");
            Label endDate_LBL = new Label("Конечная дата:"); TextField endDate_FIELD = new TextField("");
            GridPane.setConstraints(startDate_LBL, 0, 0); GridPane.setConstraints(startDate_FIELD, 1, 0);
            GridPane.setConstraints(endDate_LBL, 0, 1); GridPane.setConstraints(endDate_FIELD, 1, 1);
            insideArea.getChildren().addAll(startDate_LBL, endDate_LBL, startDate_FIELD, endDate_FIELD);
            dialog.getDialogPane().setContent(insideArea);

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(none -> {
                AppCore.queriesController.callQuery(new String[]
                        {"SPECIAL_QR_3", startDate_FIELD.getText(), endDate_FIELD.getText()});
                AppCore.stages.get("Queries").show();
            });
        });

        //  diagrams
        dimension_1_BTN.setOnAction(event -> {
            AppCore.diagramsController.callDiagram("dimension_1");
            AppCore.stages.get("Diagrams").show(); });
        dimension_2_BTN.setOnAction(event -> {
            AppCore.diagramsController.callDiagram("dimension_2");
            AppCore.stages.get("Diagrams").show(); });
        dimension_3_BTN.setOnAction(event -> {
            AppCore.diagramsController.callDiagram("dimension_3");
            AppCore.stages.get("Diagrams").show(); });
// endregion
// region SUB MENU
        //  add group
        handAdd_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "clients" -> use_Record_ClientsF(
                    "Введите информацию, на основании которой\nбудет создана новая запись",
                    "add");
                case "technical_information" -> use_Record_TechInfF(
                    "Введите информацию, на основании которой\nбудет создана новая запись",
                    "add");
                case "contracts" -> use_Record_ContractsF(
                        "Введите информацию, на основании которой\nбудет создана новая запись",
                        "add");
                case "financial_operations" -> use_Record_FinOpsF(
                        "Введите информацию, на основании которой\nбудет создана новая запись",
                        "add");
                case "contract_parts" -> addRecord_ContractParts();
                case "bills" -> addRecord_Bills();
                case "tariffs" -> addRecord_Tariffs();
                //easier
                case "client_cities" -> addRecord_Cities();
                case "transaction_types" -> addRecord_TransactionTypes();
                case "services" -> addRecord_Services();
                case "charge_types" -> addRecord_ChargeTypes();
                case "contract_statuses" -> addRecord_ContractStatuses();
            }
        });

        //  change group
        fieldsChange_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "clients" -> use_Record_ClientsF(
                    "Введите информацию, на основании которой\nбудут найдены записи для изменения",
                    "choice_change");
                case "technical_information" -> use_Record_TechInfF(
                    "Введите информацию, на основании которой\nбудут найдены записи для изменения",
                    "choice_change");
                case "contracts" -> use_Record_ContractsF(
                        "Введите информацию, на основании которой\nбудут найдены записи для изменения",
                        "choice_change");
                case "financial_operations" -> use_Record_FinOpsF(
                        "Введите информацию, на основании которой\nбудут найдены записи для изменения",
                        "choice_change");
            }
        });

        choseChange_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "bills" -> changeRecord_Bills();
                case "contract_parts" -> changeRecord_ContractParts();
                case "tariffs" -> changeRecord_Tariffs();
                //easier
                case "client_cities" -> changeRecord_Cities();
                case "transaction_types" -> changeRecord_TransactionTypes();
                case "services" -> changeRecord_Services();
                case "charge_types" -> changeRecord_ChargeTypes();
                case "contract_statuses" -> changeRecord_ContractStatuses();
            }
        });

        //  delete group
        fieldsDelete_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "clients" -> use_Record_ClientsF(
                    "Введите информацию, на основании которой\nбудут найдены записи для удаления",
                    "choice_delete");
                case "technical_information" -> use_Record_TechInfF(
                    "Введите информацию, на основании которой\nбудут найдены записи для удаления",
                    "choice_delete");
                case "contracts" -> use_Record_ContractsF(
                        "Введите информацию, на основании которой\nбудут найдены записи для удаления",
                        "choice_delete");
                case "financial_operations" -> use_Record_FinOpsF(
                        "Введите информацию, на основании которой\nбудут найдены записи для удаления",
                        "choice_delete");
            }
        });

        choseDelete_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "bills" -> deleteRecord_Bills();
                case "contract_parts" -> deleteRecord_ContractParts();
                case "tariffs" -> deleteRecord_Tariffs();
                //easier
                case "client_cities" -> deleteRecord_Cities();
                case "transaction_types" -> deleteRecord_TransactionTypes();
                case "services" -> deleteRecord_Services();
                case "charge_types" -> deleteRecord_ChargeTypes();
                case "contract_statuses" -> deleteRecord_ContractStatuses();
            }
        });

        //  search records
        searchRows_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "clients" -> use_Record_ClientsF(
                        "Введите информацию, на основании которой\nбудут найдены записи",
                        "search");
                case "technical_information" -> use_Record_TechInfF(
                        "Введите информацию, на основании которой\nбудут найдены записи",
                        "search");
                case "contracts" -> use_Record_ContractsF(
                        "Введите информацию, на основании которой\nбудут найдены записи",
                        "search");
                case "financial_operations" -> use_Record_FinOpsF(
                        "Введите информацию, на основании которой\nбудут найдены записи",
                        "search");
                case "bills" -> searchRecord_Bills();
                case "contract_parts" -> searchRecord_ContractParts();
                case "tariffs" -> searchRecord_Tariffs();
                //easier
                case "client_cities" -> searchRecord_Cities();
                case "transaction_types" -> searchRecord_TransactionTypes();
                case "services" -> searchRecord_Services();
                case "charge_types" -> searchRecord_ChargeTypes();
                case "contract_statuses" -> searchRecord_ContractStatuses();

            }
        });

        //  table show type changer
        tableShowType_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "clients" -> show_Clients("asTable");
                case "technical_information" -> show_TechInf("asTable");
                case "contracts" -> show_Contracts("asTable");
                case "financial_operations" -> show_FinOps("asTable");
            }
        });

        recordsShowType_BTN.setOnAction(event ->
        {
            switch (curTable)
            {
                case "clients" -> show_Clients("byRecords");
                case "technical_information" -> show_TechInf("byRecords");
                case "contracts" -> show_Contracts("byRecords");
                case "financial_operations" -> show_FinOps("byRecords");
            }
        });
// endregion

        //////////////////////////////// QUIT group //////////////////////////////////
        quitAccount_BTN.setOnAction(event ->
        { AppCore.stages.get("Main").hide(); AppCore.stages.get("Authorization").show(); });

        quitApp_BTN.setOnAction(event -> Platform.exit());
    }
// endregion
}