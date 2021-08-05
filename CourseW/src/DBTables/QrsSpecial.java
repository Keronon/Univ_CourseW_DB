package DBTables;

public class QrsSpecial {
    public static final String INNER_WHERE_FK_Tariffs = """
            SELECT t.name, t.cost
                FROM tariffs AS t
                INNER JOIN services AS s ON s.id = t.id_service
                WHERE s.name = '%s'
                ORDER BY t.name""";
    public static final String INNER_WHERE_FK_Contracts = """
            SELECT c.name, cl.name, TO_CHAR(c.preparation_date, 'dd.mm.yyyy'), s.name
                FROM contracts AS c
                INNER JOIN clients AS cl ON cl.id = c.id_client
                INNER JOIN contract_statuses AS s ON s.id = c.id_status
                WHERE cl.name = '%s'
                ORDER BY c.name, cl.name, s.name""";
    public static final String INNER_WHERE_DATE_FinOps = """
            SELECT t.name, f.sum, TO_CHAR(f.operation_date, 'dd.mm.yyyy'), f.comment
                FROM financial_operations AS f
                INNER JOIN transaction_types AS t ON t.id = f.id_transaction_type
                WHERE f.operation_date = '%s'
                ORDER BY t.name, f.operation_date""";
    public static final String INNER_WHERE_DATE_Contracts = """
            SELECT c.name, cs.name, TO_CHAR(c.start_date, 'dd.mm.yyyy'), TO_CHAR(c.end_date, 'dd.mm.yyyy')
                FROM contracts AS c
                INNER JOIN contract_statuses AS cs ON cs.id = c.id_status
                WHERE TO_CHAR(c.end_date, 'yyyy') = '%s'
                ORDER BY cs.name, c.name""";
    //////////////////////////////////////////////////////
    public static final String INNER_no_WHERE_Clients = """
            SELECT cl.name, c.name, cl.address, cl.contact_information
                FROM clients AS cl
                INNER JOIN client_cities AS c ON c.id = cl.id_city
                ORDER BY c.name, cl.name""";
    public static final String INNER_no_WHERE_Tariffs = """
            SELECT t.name, s.name, c.name, t.cost
                FROM tariffs AS t
                INNER JOIN charge_types AS c ON c.id = t.id_charge_type
                INNER JOIN services AS s ON s.id = t.id_service
                ORDER BY c.name, t.name""";
    public static final String INNER_no_WHERE_ContractParts = """
            SELECT c.name, t.name
                FROM contract_parts AS cp
                INNER JOIN contracts AS c ON c.id = cp.id_contract
                INNER JOIN tariffs AS t ON t.id = cp.id_tariff
                ORDER BY c.name, t.name""";
    //////////////////////////////////////////////////////
    public static final String LEFT_OUTER = """
            SELECT t.name, f.sum, f.comment, c.name
                FROM financial_operations AS f
                LEFT OUTER JOIN transaction_types AS t ON t.id = f.id_transaction_type
                LEFT OUTER JOIN contract_parts AS cp ON cp.id = f.id_contract_part
                LEFT OUTER JOIN contracts AS c ON c.id = cp.id_contract
                WHERE f.id_contract_part ISNULL
                ORDER BY c.name, f.operation_date""";
    public static final String RIGHT_OUTER = """
            SELECT c.name, c.address, c.contact_information, b.balance
                FROM bills AS b
                RIGHT OUTER JOIN clients AS c ON c.id = b.id_client AND c.name = '%s'
                ORDER BY b.balance, c.name""";
    public static final String SELECT_$_FROM_SELECT = """
            SELECT DISTINCT f_1, f_2
                FROM (SELECT t.name AS f_1, f.sum AS f_2, f.comment, c.name
                        FROM financial_operations AS f
                        LEFT OUTER JOIN transaction_types AS t ON t.id = f.id_transaction_type
                        LEFT OUTER JOIN contract_parts AS cp ON cp.id = f.id_contract_part
                        LEFT OUTER JOIN contracts AS c ON c.id = cp.id_contract
                        WHERE f.id_contract_part ISNULL
                        ORDER BY c.name, f.operation_date) AS f
            ORDER BY 1, 2""";
    //////////////////////////////////////////////////////
    public static final String AGGREGATE_no_WHERE = """
            SELECT COUNT(c.id), t."speed(mb/s)"
                FROM clients AS c
                INNER JOIN technical_information AS t ON t.id = c.id_technical_information
                GROUP BY t."speed(mb/s)"
                ORDER BY 1, 2""";
    public static final String AGGREGATE_WHERE = """
            SELECT ROUND(AVG(cost::numeric), 2), s.name
                FROM tariffs AS t
                INNER JOIN services AS s ON s.id = t.id_service
                WHERE s.name = '%s'
                GROUP BY s.name
                ORDER BY 1, 2""";
    public static final String AGGREGATE_HAVING = """
            SELECT COUNT(f.id) AS counter, f.sum
                FROM financial_operations AS f
                INNER JOIN transaction_types AS t ON t.id = f.id_transaction_type
                GROUP BY f.sum
                HAVING f.sum::numeric > 500
                ORDER BY 2, 1""";
    public static final String AGGREGATE_WHERE_HAVING = """
            SELECT c.name, SUM(balance::numeric)
                FROM bills AS b
                INNER JOIN clients AS c ON c.id = b.id_client
                WHERE balance::numeric < 0
                GROUP BY c.name
                HAVING c.name = '%s'
                ORDER BY 1, 2""";
    public static final String AGGREGATE_$_FROM_SELECT = """
            SELECT (SELECT COUNT(c.id)
                    FROM clients AS c
                    INNER JOIN technical_information AS t ON t.id = c.id_technical_information
                    WHERE c.id_technical_information = t_i.id) AS count, "speed(mb/s)"
                FROM technical_information AS t_i
                ORDER BY 1 DESC, 2""";
    public static final String SELECT_$_WHERE_SELECT = """
            SELECT c.name, b.balance
                FROM bills AS b, clients AS c
                WHERE c.id = b.id_client AND b.id_client IN
                    (SELECT id FROM clients WHERE name LIKE '""";
    // region SPECIAL
    public static final String SPECIAL_QR_1 = """
            SELECT '=== СРЕДИ ВСЕХ ===', null, '===', '==='
            UNION ALL (
            	SELECT c.name, COUNT(f.id), (SELECT name FROM client_cities WHERE id = c.id_city), c.contact_information
            	FROM financial_operations AS f
            	INNER JOIN bills AS b ON b.id = f.id_bill
            	INNER JOIN clients AS c ON c.id = b.id_client
            	GROUP BY c.id ORDER BY 2 DESC LIMIT 3)
            UNION ALL ( SELECT '=== ПО ГОРОДАМ ===', null, '===', '===' )
            UNION ALL (
            	SELECT c.name, COUNT(f.id), (SELECT name FROM client_cities WHERE id = c.id_city), c.contact_information
            	FROM financial_operations AS f
            	INNER JOIN bills AS b ON b.id = f.id_bill
            	INNER JOIN clients AS c ON c.id = b.id_client
            	GROUP BY c.id_city, c.id ORDER BY 3, 2 DESC)""";
    public static final String SPECIAL_QR_2 = """
            SELECT 'для клиентов', ROUND(AVG(from_1.count)) FROM (
            	SELECT COUNT(f.id) AS count
            	FROM financial_operations AS f
            	INNER JOIN bills AS b ON b.id = f.id_bill
            	INNER JOIN clients AS c ON c.id = b.id_client
            	GROUP BY c.id) AS from_1
            UNION ALL (
            SELECT 'для городов', ROUND(AVG(from_2.count)) AS "avg count" FROM (
            	SELECT COUNT(f.id) AS count
            	FROM financial_operations AS f
            	INNER JOIN bills AS b ON b.id = f.id_bill
            	INNER JOIN clients AS c ON c.id = b.id_client
            	INNER JOIN client_cities AS cc ON cc.id = c.id_city
            	GROUP BY cc.id) AS from_2 ) ORDER BY 1""";
    public static final String SPECIAL_QR_3 = """
            SELECT f.operation_date, COUNT(c.id), COUNT(b.id), SUM(f.sum)
            FROM financial_operations AS f
            INNER JOIN bills AS b ON b.id = f.id_bill
            INNER JOIN clients AS c ON c.id = b.id_client
            WHERE f.operation_date > '%s' AND f.operation_date < '%s'
            GROUP BY f.operation_date
            ORDER BY 1""";
    // endregion
}