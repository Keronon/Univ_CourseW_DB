package DBTables;

public class GenerateQrsData
{
    public static final String truncate =
    "TRUNCATE technical_information, clients, bills, contracts, tariffs, contract_parts, financial_operations RESTART IDENTITY";
    // region TechInf
    public static final String insertHeader_TechInf =
            "INSERT INTO technical_information (\"dr/sr\", server_id, \"port/sap\", \"speed(mb/s)\", ip, scheme, pm) VALUES\n";
    public static final String insertData_TechInf = """
            ('ASR1654',5022,5127,'50','208.151.89.10','-','STP'),
            ('ASR2798',3192,3901,'100','34.142.128.8','±','ВОЛС/МК'),
            ('ASR1785',9825,3523,'50','83.198.187.103','±','S/FTP'),
            ('ASR1785',3748,9016,'300','222.215.179.90','-','S/FTP'),
            ('ASR1785',8199,2605,'400','164.127.124.192','+','STP'),
            ('ASR1654',6741,1066,'10','76.69.43.94','-','FTP'),
            ('ASR1654',9153,5253,'100','142.142.49.69','-','ВОЛС/МК'),
            ('ASR2841',6328,3269,'300','244.250.98.220','+','S/FTP'),
            ('ASR1654',9723,3434,'50','89.121.115.44','±','STP'),
            ('ASR1654',2207,9767,'10','107.40.123.175','±','S/FTP'),""";
    // endregion
    // region Clients
    public static final String insertHeader_Clients =
            "INSERT INTO clients (name, id_technical_information, id_city, address, contact_information) VALUES\n";
    public static final String insertData_Clients = """
            ('Razdor Inc.', 1, 1, 'ул. Первой Войны', '+66(666)666-66-66'),
            ('FilgWam Corp.', 15, 2, 'пр-т Культи', '+8(800)555-35-35'),
            ('Rookie Firm.', 24, 3, 'м-н Забытый', '+2(320)789-39-35'),
            ('TenSec Org.', 38, 4, 'ул. Железных светлячков', '+7(357)753-73-53'),
            ('RainbowHell Inc.', 5, 2, 'переулок Нетудык', '+1(234)567-89-10'),
            ('SaintSofie Org.', 15, 6, 'ул. Даимон-Д', '+2(666)626-66-22'),
            ('Apple Corp.', 23, 5, 'переулок Давн', '+8(350)587-38-35'),
            ('Cookisch Firm.', 11, 3, 'пр-т Пары', '+2(420)769-39-35'),
            ('RedBeard Org.', 1, 2, 'область ХолиВара', '+25(333)779-70-53'),
            ('Amerish Inc.', 64, 7, 'ул. Санбер', '+4(234)566-23-10'),""";
    // endregion
    // region Bills
    public static final String insertHeader_Bills =
            "INSERT INTO bills (id_client, balance) VALUES\n";
    public static final String insertData_Bills = """
            (52,0),(43,0),(42,0),(21,0),(11,0),(40,0),(67,0),(43,0),(30,0),(22,0),""";
    // endregion
    // region Contracts
    public static final String insertHeader_Contracts =
            "INSERT INTO contracts (name, id_client, preparation_date, start_date, id_status, end_date) VALUES\n";
    public static final String insertData_Contracts = """
            ('Loot#5755.23.g3 47.346',34,'28/10/2017','28/03/2018',2,'16/04/2022'),
            ('Rock#3465.45.2f 32.234',48,'29/10/2017','12/09/2019',1,'17/01/2022'),
            ('Mein#4567.24.v2 345.3',51,'26/10/2017','02/11/2018',1, null),
            ('Vait#4563.45.n4 457.465',34,'28/10/2017','27/04/2018',2,'27/07/2022'),
            ('Lein#2357.57.m7 43.3',9,'29/10/2017','26/05/2019',2,'11/12/2021'),
            ('Boor#4797.56.b5 236.345',33,'27/10/2017','15/10/2018',1, null),
            ('Derf#5466.56.4n 32.3',6,'28/10/2017','28/03/2018',2,'04/01/2020'),
            ('Grah#4564.34.b4 32.4',34,'26/10/2017','06/10/2019',1,'17/01/2022'),
            ('Wasd#4357.45.5n 5869.3',23,'29/10/2017','14/08/2019',1, null),
            ('Qert#4754.57.nn 32.5',47,'27/10/2017','13/08/2018',1,'04/12/2025'),""";
    // endregion
    // region Tariffs
    public static final String insertHeader_Tariffs =
            "INSERT INTO tariffs (name, id_service, id_charge_type, cost) VALUES\n";
    public static final String insertData_Tariffs = """
            ('Поделись своими данными',1,1,'500'),
            ('Бесплатные медецинские маски по 20 руб.',2,2,'500'),
            ('Шанс выиграть телевизор 1 на Млн',3,3,'200'),
            ('Вы не поверите!',4,2,'300'),
            ('Первый международный',5,1,'100'),
            ('Подайте пожалуйста',5,3,'500'),
            ('СПАСИТЕ!!!',4,2,'100'),
            ('Я УСТАЛ!!!',3,1,'200'),
            ('ХОЧУ 5-ку!',1,1,'200'),
            ('Сдача в придачу',2,2,'100'),""";
    // endregion
    // region ContractParts
    public static final String insertHeader_ContractParts =
            "INSERT INTO contract_parts (id_contract, id_tariff) VALUES\n";
    public static final String insertData_ContractParts = """
            (33,42),(1,2),(48,1),(16,3),(12,34),(30,6),(12,3),(12,47),(26,5),(24,4),""";
    // endregion
    // region FinOps
    public static final String insertHeader_FinOps =
            "INSERT INTO financial_operations (id_bill, id_transaction_type, sum, operation_date, id_contract_part, comment) VALUES\n";
    public static final String insertData_FinOps = """
            (4,1,825,'09/07/2020',10, 'It is our time'),
            (17,2,218,'11/12/2018',30, null),
            (11,1,643,'06/06/2020',15, 'No smoking'),
            (10,2,951,'03/04/2019',51, 'You must die.. mb.'),
            (3,1,351,'24/02/2020',null, 'Oh...'),
            (11,2,67,'22/04/2020',102, 'We at world hole'),
            (7,1,655,'06/06/2020',15, 'Вспомнил..'),
            (10,1,113,'19/04/2019',131, 'Говорили на русском писать.'),
            (20,1,281,'18/08/2020',null, 'Ладно уж. Вот вам чутка русского...'),
            (8,2,700,'23/02/2019',null, null),""";
    // endregion
}
