package DBTables;

public class QrsClients
{
    // SELECT
    public static final String SELECT_TABLE = """
                                                    SELECT cl.name,
                                                           ti.server_id,
                                                           ti."port/sap",
                                                           ti."speed(mb/s)",
                                                           ci.name,
                                                           cl.address,
                                                           cl.contact_information,
                                                           cl.id_technical_information
                                                    FROM clients AS cl,
                                                         technical_information AS ti,
                                                         client_cities AS ci
                                                    WHERE ti.id = cl.id_technical_information AND
                                                          ci.id = cl.id_city
                                                    ORDER BY cl.id
                                                    """;
    public static final String SELECT_NAMES = "SELECT id, name FROM clients ORDER BY id";
    public static final String SELECT_2CHANGE = """
                                                    SELECT cl.name,
                                                           ti.server_id,
                                                           ti."port/sap",
                                                           ti."speed(mb/s)",
                                                           ci.name,
                                                           cl.address,
                                                           cl.contact_information,
                                                           cl.id_technical_information
                                                    FROM clients AS cl,
                                                         technical_information AS ti,
                                                         client_cities AS ci
                                                    WHERE ti.id = cl.id_technical_information AND
                                                          ci.id = cl.id_city%s
                                                    ORDER BY cl.id
                                                    """;
    public static final String SELECT_2DELETE = """
                                                    SELECT COUNT(*)
                                                    FROM clients AS cl,
                                                         technical_information AS ti,
                                                         client_cities AS ci
                                                    WHERE ti.id = cl.id_technical_information AND
                                                          ci.id = cl.id_city%s
                                                    """;

    // ADD
    public static final String ADD_RECORD = """
                                              INSERT INTO clients
                                              (name, id_technical_information, id_city, address, contact_information)
                                              VALUES
                                              ('%s', %s, (SELECT id FROM client_cities WHERE name = '%s'), '%s', '%s')
                                              """;

    // UPDATE
    public static final String UPDATE_RECORD = """
            UPDATE clients SET
                name = '%s',
                id_technical_information = %s,
                id_city = (SELECT id FROM client_cities WHERE name = '%s'),
                address = '%s',
                contact_information = '%s'
            WHERE
                name = '%s' AND
                id_technical_information = %s AND
                id_city = (SELECT id FROM client_cities WHERE name = '%s') AND
                address = '%s' AND
                contact_information = '%s'
            """;
}
