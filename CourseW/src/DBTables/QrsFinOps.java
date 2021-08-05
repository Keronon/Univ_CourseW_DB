package DBTables;

public class QrsFinOps
{
    // SELECT
    public static final String SELECT_TABLE = """
                         SELECT cl.name, b.balance, tt.name, f.sum, TO_CHAR(f.operation_date, 'dd.mm.yyyy'), c.name, t.name, f.comment, f.id_bill, f.id_contract_part
                         FROM financial_operations AS f
                         LEFT OUTER JOIN bills AS b ON b.id = f.id_bill
                         LEFT OUTER JOIN clients AS cl ON cl.id = b.id_client
                         LEFT OUTER JOIN transaction_types AS tt ON tt.id = f.id_transaction_type
                         LEFT OUTER JOIN contract_parts AS cp ON cp.id = f.id_contract_part
                         LEFT OUTER JOIN contracts AS c ON c.id = cp.id_contract
                         LEFT OUTER JOIN tariffs AS t ON t.id = cp.id_tariff
                         ORDER BY f.id""";
    public static final String SELECT_2CHANGE = """
                         SELECT cl.name, b.balance, tt.name, f.sum, TO_CHAR(f.operation_date, 'dd.mm.yyyy'), c.name, t.name, f.comment, b.id, cp.id
                         FROM financial_operations AS f
                         LEFT OUTER JOIN bills AS b ON b.id = f.id_bill
                         LEFT OUTER JOIN clients AS cl ON cl.id = b.id_client
                         LEFT OUTER JOIN transaction_types AS tt ON tt.id = f.id_transaction_type
                         LEFT OUTER JOIN contract_parts AS cp ON cp.id = f.id_contract_part
                         LEFT OUTER JOIN contracts AS c ON c.id = cp.id_contract
                         LEFT OUTER JOIN tariffs AS t ON t.id = cp.id_tariff
                         WHERE f.id = f.id%s
                         ORDER BY f.id""";
    public static final String SELECT_2DELETE = """
                         SELECT COUNT(*)
                         FROM financial_operations AS f
                         LEFT OUTER JOIN bills AS b ON b.id = f.id_bill
                         LEFT OUTER JOIN clients AS cl ON cl.id = b.id_client
                         LEFT OUTER JOIN transaction_types AS tt ON tt.id = f.id_transaction_type
                         LEFT OUTER JOIN contract_parts AS cp ON cp.id = f.id_contract_part
                         LEFT OUTER JOIN contracts AS c ON c.id = cp.id_contract
                         LEFT OUTER JOIN tariffs AS t ON t.id = cp.id_tariff
                         WHERE f.id = f.id%s""";

    // ADD
    public static final String ADD_RECORD = """
        INSERT INTO financial_operations
            (id_bill, id_transaction_type, sum, operation_date, id_contract_part, comment)
        VALUES
            (%s, (SELECT id FROM transaction_types WHERE name = '%s'), '%s', '%s', %s, '%s')
        """;

    // UPDATE
    public static final String UPDATE_RECORD = """
            UPDATE financial_operations SET
                id_bill = %s,
                id_transaction_type = (SELECT id FROM transaction_types WHERE name = '%s'),
                sum = '%s',
                operation_date = '%s',
                id_contract_part = %s,
                comment = '%s'
            WHERE
                id_bill = %s AND
                id_transaction_type = (SELECT id FROM transaction_types WHERE name = '%s') AND
                sum = '%s' AND
                operation_date = '%s' AND
                id_contract_part = %s AND
                comment = '%s'
            """;
}
