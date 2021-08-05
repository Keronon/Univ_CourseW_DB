package DBTables;

public class QrsCommonCatalogs
{
    // CLIENT CITIES
    public static final String SELECT_CLIENT_CITIES = "SELECT name FROM client_cities ORDER BY id";
    public static final String SELECT_CLIENT_CITIES_2SEARCH = "SELECT name FROM client_cities WHERE name = '%s' ORDER BY id";
    public static final String ADD_CLIENT_CITIES = "INSERT INTO client_cities (name) VALUES ('%s')";
    public static final String CHANGE_CLIENT_CITIES = "UPDATE client_cities SET name = '%s' WHERE name = '%s'";
    public static final String DELETE_CLIENT_CITIES = "DELETE FROM client_cities WHERE name = '%s'";

    // TRANSACTION TYPES
    public static final String SELECT_TRANSACTION_TYPES = "SELECT name FROM transaction_types ORDER BY id";
    public static final String SELECT_TRANSACTION_TYPES_2SEARCH = "SELECT name FROM transaction_types WHERE name = '%s' ORDER BY id";
    public static final String ADD_TRANSACTION_TYPES = "INSERT INTO transaction_types (name) VALUES ('%s')";
    public static final String CHANGE_TRANSACTION_TYPES = "UPDATE transaction_types SET name = '%s' WHERE name = '%s'";
    public static final String DELETE_TRANSACTION_TYPES = "DELETE FROM transaction_types WHERE name = '%s'";

    // SERVICES
    public static final String SELECT_SERVICES = "SELECT name FROM services ORDER BY id";
    public static final String SELECT_SERVICES_2SEARCH = "SELECT name FROM services WHERE name = '%s' ORDER BY id";
    public static final String ADD_SERVICES = "INSERT INTO services (name) VALUES ('%s')";
    public static final String CHANGE_SERVICES = "UPDATE services SET name = '%s' WHERE name = '%s'";
    public static final String DELETE_SERVICES = "DELETE FROM services WHERE name = '%s'";

    // CHARGE TYPES
    public static final String SELECT_CHARGE_TYPES = "SELECT name FROM charge_types ORDER BY id";
    public static final String SELECT_CHARGE_TYPES_2SEARCH = "SELECT name FROM charge_types WHERE name = '%s' ORDER BY id";
    public static final String ADD_CHARGE_TYPES = "INSERT INTO charge_types (name) VALUES ('%s')";
    public static final String CHANGE_CHARGE_TYPES = "UPDATE charge_types SET name = '%s' WHERE name = '%s'";
    public static final String DELETE_CHARGE_TYPES = "DELETE FROM charge_types WHERE name = '%s'";

    // CONTRACT STATUSES
    public static final String SELECT_CONTRACT_STATUSES = "SELECT name FROM contract_statuses ORDER BY id";
    public static final String SELECT_CONTRACT_STATUSES_2SEARCH = "SELECT name FROM contract_statuses WHERE name = '%s' ORDER BY id";
    public static final String ADD_CONTRACT_STATUSES = "INSERT INTO contract_statuses (name) VALUES ('%s')";
    public static final String CHANGE_CONTRACT_STATUSES = "UPDATE contract_statuses SET name = '%s' WHERE name = '%s'";
    public static final String DELETE_CONTRACT_STATUSES = "DELETE FROM contract_statuses WHERE name = '%s'";

    // region MORE HARD
    // region CONTRACT PARTS
    public static final String SELECT_CONTRACT_PARTS = """
                                                        SELECT c.name, t.name, cp.id, c.id, t.id
                                                        FROM contract_parts AS cp,
                                                             contracts AS c,
                                                             tariffs AS t
                                                        WHERE c.id = cp.id_contract AND
                                                              t.id = cp.id_tariff
                                                        ORDER BY cp.id
                                                        """;
    public static final String SELECT_CONTRACT_PARTS_2SEARCH = """
                                             SELECT c.name, t.name, cp.id, c.id, t.id
                                             FROM contract_parts AS cp,
                                                  contracts AS c,
                                                  tariffs AS t
                                             WHERE c.id = cp.id_contract AND
                                                   t.id = cp.id_tariff%s
                                             ORDER BY cp.id
                                             """;
    public static final String ADD_CONTRACT_PARTS = "INSERT INTO contract_parts (id_contract, id_tariff) VALUES ('%s', '%s')";
    public static final String CHANGE_CONTRACT_PARTS = """
                                                        UPDATE contract_parts
                                                        SET id_contract = '%s', id_tariff = '%s'
                                                        WHERE id_contract IN (SELECT id FROM contracts WHERE name = '%s') AND
                                                              id_tariff IN (SELECT id FROM tariffs WHERE name = '%s')
                                                        """;
    public static final String DELETE_CONTRACT_PARTS = """
                                                        DELETE FROM contract_parts
                                                        WHERE
                                                            id_contract = (SELECT id FROM contracts WHERE name = '%s') AND
                                                            id_tariff = (SELECT id FROM tariffs WHERE name = '%s')
                                                        """;
    // endregion
    // region BILLS
    public static final String SELECT_BILLS = """
                                                SELECT cl.name, b.balance, b.id, cl.id
                                                FROM bills AS b,
                                                     clients AS cl
                                                WHERE cl.id = b.id_client
                                                ORDER BY b.id
                                                """;
    public static final String SELECT_BILLS_2SEARCH = """
                                                SELECT cl.name, b.balance, b.id, cl.id
                                                FROM bills AS b,
                                                     clients AS cl
                                                WHERE cl.id = b.id_client%s
                                                ORDER BY b.id
                                                """;
    public static final String ADD_BILLS = "INSERT INTO bills (id_client, balance) VALUES ('%s', '%s')";
    public static final String CHANGE_BILLS = """
                                              UPDATE bills SET id_client = '%s', balance = '%s'
                                              WHERE id_client IN (SELECT id FROM clients WHERE name = '%s') AND
                                                    balance = '%s'
                                              """;
    public static final String DELETE_BILLS = """
                                              DELETE FROM bills
                                              WHERE
                                                  id_client = (SELECT id FROM clients WHERE name = '%s') AND
                                                  balance = '%s'
                                              """;
    // endregion
    // region TARIFFS
    public static final String SELECT_TARIFFS = """
                                                SELECT t.name, s.name, cht.name, cost
                                                FROM tariffs AS t,
                                                     services AS s,
                                                     charge_types AS cht
                                                WHERE s.id = t.id_service AND
                                                      cht.id = t.id_charge_type
                                                ORDER BY t.id
                                                """;
    public static final String SELECT_TARIFFS_2SEARCH = """
                                                SELECT t.name, s.name, cht.name, cost
                                                FROM tariffs AS t,
                                                     services AS s,
                                                     charge_types AS cht
                                                WHERE s.id = t.id_service AND
                                                      cht.id = t.id_charge_type%s
                                                ORDER BY t.id
                                                """;
    public static final String ADD_TARIFFS =
            """
            INSERT INTO tariffs (name, id_service, id_charge_type, cost)
            VALUES ('%s', (SELECT id FROM services WHERE name = '%s'), (SELECT id FROM charge_types WHERE name = '%s'), '%s')
            """;
    public static final String CHANGE_TARIFFS =
            """
            UPDATE tariffs
            SET name = '%s',
                id_service = (SELECT id FROM services WHERE name = '%s'),
                id_charge_type = (SELECT id FROM charge_types WHERE name = '%s'),
                cost = '%s'
            WHERE name = '%s' AND
                  id_service IN (SELECT id FROM services WHERE name = '%s') AND
                  id_charge_type IN (SELECT id FROM charge_types WHERE name = '%s') AND
                  cost = '%s'
            """;
    public static final String DELETE_TARIFFS = """
                                              DELETE FROM tariffs
                                              WHERE name = '%s' AND
                                                    id_service IN (SELECT id FROM services WHERE name = '%s') AND
                                                    id_charge_type IN (SELECT id FROM charge_types WHERE name = '%s') AND
                                                    cost = '%s'
                                              """;
    // endregion
    // endregion
}
