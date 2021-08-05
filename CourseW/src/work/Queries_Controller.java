package work;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import DBTables.FullTableRow;
import DBTables.QrsSpecial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Queries_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    // region FXML
    @FXML
    private TitledPane columns_4_BOX;

    @FXML
    private TableView<FullTableRow> columns_4_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> on4_1_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> on4_2_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> on4_3_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> on4_4_COLUMN;

    @FXML
    private TitledPane columns_2_BOX;

    @FXML
    private TableView<FullTableRow> columns_2_TABLE;

    @FXML
    private TableColumn<FullTableRow, String> on2_1_COLUMN;

    @FXML
    private TableColumn<FullTableRow, String> on2_2_COLUMN;

    @FXML
    private Label recordsCounter_FIELD;
    // endregion
    // region CODE
    // common VARIABLES
    private int recordsCount;

    // common FUNCTIONS
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void callQuery(String[] queryData)
    {
        switch (queryData[0])
        {
            case "INNER_WHERE_FK_Tariffs" ->     show_Columns_2_TABLE(String.format(
                    QrsSpecial.INNER_WHERE_FK_Tariffs,     queryData[1]), "Отбор ТАРИФОВ по услуге",
                    "название", "стоимость");
            case "INNER_WHERE_FK_Contracts" ->   show_Columns_4_TABLE(String.format(
                    QrsSpecial.INNER_WHERE_FK_Contracts,   queryData[1]), "Отбор КОНТРАКТОВ по клиенту",
                    "наименование", "клиент", "дата заключения", "статус");
            case "INNER_WHERE_DATE_FinOps" ->    show_Columns_4_TABLE(String.format(
                    QrsSpecial.INNER_WHERE_DATE_FinOps,    queryData[1]), "Отбор ФИНАНСОВЫХ ОПЕРАЦИЙ по дате операции",
                    "тип транзакции", "сумма", "дата операции", "комментарий");
            case "INNER_WHERE_DATE_Contracts" -> show_Columns_4_TABLE(String.format(
                    QrsSpecial.INNER_WHERE_DATE_Contracts, queryData[1]), "Отбор КОНТРАКТОВ по дате завершения",
                    "наименование", "статус", "дата начала", "дата завершения");
            //////////////////////////////////////////////////////
            case "INNER_no_WHERE_Clients" ->       show_Columns_4_TABLE(
                    QrsSpecial.INNER_no_WHERE_Clients,       "Спец. представление КЛИЕНТОВ",
                    "наименование", "город", "адрес", "контактная информация");
            case "INNER_no_WHERE_Tariffs" ->       show_Columns_4_TABLE(
                    QrsSpecial.INNER_no_WHERE_Tariffs,       "Спец. представление ТАРИФОВ",
                    "название", "услуга", "тип оплаты", "стоимость");
            case "INNER_no_WHERE_ContractParts" -> show_Columns_2_TABLE(
                    QrsSpecial.INNER_no_WHERE_ContractParts, "Спец. представление ЧАСТЕЙ КОНТРАКТОВ",
                    "контракт", "тариф");
            //////////////////////////////////////////////////////
            case "LEFT_OUTER" ->           show_Columns_4_TABLE(
                    QrsSpecial.LEFT_OUTER,                 "ФИНАНСОВЫЕ ОПЕРАЦИИ без частей контрактов",
                    "тип транзакции", "сумма", "комментарий", "часть контракта");
            case "RIGHT_OUTER" ->          show_Columns_4_TABLE(String.format(
                    QrsSpecial.RIGHT_OUTER, queryData[1]), "КЛИЕНТЫ с ограниченными подробностями",
                    "наименование", "адрес", "контактная информация", "баланс");
            case "SELECT_$_FROM_SELECT" -> show_Columns_2_TABLE(
                    QrsSpecial.SELECT_$_FROM_SELECT,       "Спец. представление ФИНАНСОВЫХ ОПЕРАЦИЙ",
                    "тип транзакции", "сумма");
            //////////////////////////////////////////////////////
            case "AGGREGATE_no_WHERE" ->      show_Columns_2_TABLE(
                    QrsSpecial.AGGREGATE_no_WHERE,                            "Количество КЛИЕНТОВ, сгруппированных по скорости интернета",
                    "количество клиентов", "скорость");
            case "AGGREGATE_WHERE" ->         show_Columns_2_TABLE(String.format(
                    QrsSpecial.AGGREGATE_WHERE, queryData[1]),                "Средняя стоимость ТАРИФОВ с указанной услугой",
                    "средняя стоимость", "услуга");
            case "AGGREGATE_HAVING" ->        show_Columns_2_TABLE(
                    QrsSpecial.AGGREGATE_HAVING, "Количество ФИНАНСОВЫХ ОПЕРАЦИЙ с проходящей суммой более 500 у.е.",
                    "количество", "сумма");
            case "AGGREGATE_WHERE_HAVING" ->  show_Columns_2_TABLE(String.format(
                    QrsSpecial.AGGREGATE_WHERE_HAVING, queryData[1]),         "Сумма отрицательных балансов СЧЕТОВ у указанного клиента",
                    "клиент", "баланс");
            case "AGGREGATE_$_FROM_SELECT" -> show_Columns_2_TABLE(
                    QrsSpecial.AGGREGATE_$_FROM_SELECT,                       "Спец. представление групп КЛИЕНТОВ",
                    "к-во клиентов", "скорость интернетоборудования");
            case "SELECT_$_WHERE_SELECT" ->   show_Columns_2_TABLE(QrsSpecial.SELECT_$_WHERE_SELECT + queryData[1] + "%') ORDER BY 1, 2",
                                                                              "СЧЕТА клиентов, наименования который начинаются на указанную часть",
                    "клиент", "баланс");
            //////////////////////////////////////////////////////
            case "SPECIAL_QR_1" -> {
                show_Columns_4_TABLE(QrsSpecial.SPECIAL_QR_1,
                        "Топ 3 КЛИЕНТА, с наибольшим к-вом фин.операций всего и по городам",
                        "наименование", "к-во операций", "город", "контактная инф.");
                show_Special_Alert();
            }
            case "SPECIAL_QR_2" ->   show_Columns_2_TABLE(QrsSpecial.SPECIAL_QR_2,
                    "Среднее к-во фин.операций по КЛИЕНТУ и по ГОРОДУ",
                    "группа", "к-во фин.операций");
            case "SPECIAL_QR_3" ->   show_Columns_4_TABLE(String.format(QrsSpecial.SPECIAL_QR_3, queryData[1], queryData[2]),
                    "К-во КЛИЕНТОВ, совершивших фин.операции за указанный промежуток, и прошедшая их сумма денег",
                    "дата", "к-во клиентов", "к-во счетов", "сумма");
        }
    }

    private void show_Columns_4_TABLE(String query, String boxTitle, String c_name_1, String c_name_2, String c_name_3, String c_name_4)
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(query);
            recordsCount = 0;
            while (AppCore.resultSet.next()) {
                FullTableRow row = new FullTableRow();
                row.setField_01(AppCore.resultSet.getString(1).trim());
                String temp = AppCore.resultSet.getString(2);
                row.setField_02(temp != null ? temp.trim() : "null");
                       temp = AppCore.resultSet.getString(3);
                row.setField_03(temp != null ? temp.trim() : "null");
                       temp = AppCore.resultSet.getString(4);
                row.setField_04(temp != null ? temp.trim() : "null");
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

        on4_1_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_01"));
        on4_1_COLUMN.setText(c_name_1);
        on4_2_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_02"));
        on4_2_COLUMN.setText(c_name_2);
        on4_3_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_03"));
        on4_3_COLUMN.setText(c_name_3);
        on4_4_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_04"));
        on4_4_COLUMN.setText(c_name_4);
        columns_4_TABLE.setItems(rows);

        columns_4_BOX.toFront();
        columns_4_BOX.setText(boxTitle);
    }
    private void show_Columns_2_TABLE(String query, String boxTitle, String c_name_1, String c_name_2)
    {
        ObservableList<FullTableRow> rows = FXCollections.observableArrayList();
        try {
            AppCore.statement = AppCore.connection.createStatement();
            AppCore.resultSet = AppCore.statement.executeQuery(query);
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

        on2_1_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_01"));
        on2_1_COLUMN.setText(c_name_1);
        on2_2_COLUMN.setCellValueFactory(new PropertyValueFactory<>("field_02"));
        on2_2_COLUMN.setText(c_name_2);
        columns_2_TABLE.setItems(rows);

        columns_2_BOX.toFront();
        columns_2_BOX.setText(boxTitle);
    }

    private void show_Special_Alert()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Сохранение");
        alert.setGraphic(null);
        alert.setHeaderText(null);
        alert.setContentText("""
Результаты данного запроса можно сохранить в файлах.
Необходимо ли вам данное действие?

(таблица отобразится после отказа от сохранения)""");

        ButtonType save_as_html_BTN = new ButtonType("Сохранить в формате HTML");
        ButtonType save_as_excel_BTN = new ButtonType("Сохранить в формате EXCEL");
        ButtonType cancel_BTN = new ButtonType("Отказаться");

        // Remove default ButtonTypes
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(save_as_html_BTN, save_as_excel_BTN, cancel_BTN);

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == save_as_html_BTN)
        {
            StringBuilder file_text = new StringBuilder("""
                            <!DOCTYPE html>
                            <html>
                                <body>
                                    <table border=2>
                                        <caption>Топ 3 КЛИЕНТА, с наибольшим к-вом фин.операций всего и по городам</caption>
                                        <tbody>
                                        <tr><th>наименование</th><th>к-во операций</th><th>город</th><th>контактная инф.</th></tr>""");
            for (FullTableRow record : columns_4_TABLE.getItems())
            {
                file_text.append(String.format("""
                                        <tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>""",
                        record.getField_01(), record.getField_02(), record.getField_03(), record.getField_04()));
            }
            file_text.append("""
                                        </tbody>
                                    </table>
                                </body>
                            </html>""");
            try(FileWriter writer = new FileWriter("D:/CourseW/resources/work_reports/table_as.html", false))
            {   // запись всей строки
                writer.write(file_text.toString()); writer.flush();
            } catch(IOException ex) { System.out.println(ex.getMessage()); }

            callQuery(new String[] {"SPECIAL_QR_1"});
        }
        else if (option.get() == save_as_excel_BTN)
        {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Table sheet");

            int rowNum = 0;
            Cell cell;
            Row row;

            HSSFCellStyle style = createStyleForTitle(workbook);
            row = sheet.createRow(rowNum);

            // наименование
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("наименование");
            cell.setCellStyle(style);
            // к-во операций
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("к-во операций");
            cell.setCellStyle(style);
            // город
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("город");
            cell.setCellStyle(style);
            // контактная инф.
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("контактная инф.");
            cell.setCellStyle(style);

            // Data
            for (FullTableRow record : columns_4_TABLE.getItems())
            {
                rowNum++;
                row = sheet.createRow(rowNum);

                // наименование
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(record.getField_01());
                // к-во операций
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(record.getField_02());
                // город
                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(record.getField_03());
                // контактная инф.
                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(record.getField_04());
            }
            try {
                File file = new File("D:/CourseW/resources/work_reports/table_as.xls");
                FileOutputStream outFile = new FileOutputStream(file);
                workbook.write(outFile);
            } catch (Exception ex) { System.err.println(ex.getMessage()); }

            callQuery(new String[] {"SPECIAL_QR_1"});
        }
    }

    // for FXML CODE
    @FXML
    void initialize() { AppCore.queriesController = this; }
    // endregion
}