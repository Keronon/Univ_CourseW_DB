package DBTables;

public class QrsContracts
{
    // SELECT
    public static final String SELECT_TABLE = """
                                              SELECT c.name,
                                                     cl.name,
                                                     TO_CHAR(c.preparation_date, 'dd.mm.yyyy'),
                                                     TO_CHAR(c.start_date, 'dd.mm.yyyy'),
                                                     cs.name,
                                                     TO_CHAR(c.end_date, 'dd.mm.yyyy'),
                                                     cl.id
                                              FROM contracts AS c,
                                                   clients AS cl,
                                                   contract_statuses AS cs
                                              WHERE cl.id = c.id_client AND
                                                    cs.id = c.id_status
                                              ORDER BY c.id
                                              """;
    public static final String SELECT_NAMES = "SELECT id, name FROM contracts ORDER BY id";
    public static final String SELECT_2CHANGE = """
                                                    SELECT c.name,
                                                           cl.name,
                                                           TO_CHAR(c.preparation_date, 'dd.mm.yyyy'),
                                                           TO_CHAR(c.start_date, 'dd.mm.yyyy'),
                                                           cs.name,
                                                           TO_CHAR(c.end_date, 'dd.mm.yyyy'),
                                                           cl.id
                                                    FROM contracts AS c,
                                                         clients AS cl,
                                                         contract_statuses AS cs
                                                    WHERE cl.id = c.id_client AND
                                                          cs.id = c.id_status%s
                                                    ORDER BY cl.id
                                                    """;
    public static final String SELECT_2DELETE = """
                                                    SELECT COUNT(*)
                                                    FROM contracts AS c,
                                                         clients AS cl,
                                                         contract_statuses AS cs
                                                    WHERE cl.id = c.id_client AND
                                                          cs.id = c.id_status%s
                                                    """;

    // ADD
    public static final String ADD_RECORD = """
        INSERT INTO contracts
            (name, id_client, preparation_date, start_date, id_status, end_date)
        VALUES
            ('%s', %s, '%s', '%s', (SELECT id FROM contract_statuses WHERE name = '%s'), '%s')
        """;

    // UPDATE
    public static final String UPDATE_RECORD = """
            UPDATE contracts SET
                name = '%s',
                id_client = %s,
                preparation_date = '%s',
                start_date = '%s',
                id_status = (SELECT id FROM contract_statuses WHERE name = '%s'),
                end_date = '%s'
            WHERE
                name = '%s' AND
                id_client = %s AND
                preparation_date = '%s' AND
                start_date = '%s' AND
                id_status = (SELECT id FROM contract_statuses WHERE name = '%s') AND
                end_date = '%s'
            """;
}
