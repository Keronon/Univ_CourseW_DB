package DBTables;

public class QrsTechInf
{
    /* FIELDS
       drSR_TechInfF_FIELD
       serverID_TechInfF_FIELD
       portSAP_TechInfF_FIELD
       speed_TechInfF_FIELD
       ip_TechInfF_FIELD
       scheme_TechInfF_FIELD
       pm_TechInfF_FIELD

       COLUMNS
       "dr/sr"
       server_id
       "port/sap"
       "speed(mb/s)"
       ip
       scheme
       pm
    */

    // SELECT-s
    public static final String SELECT_ALL = """
                                                    SELECT "dr/sr",
                                                           server_id,
                                                           "port/sap",
                                                           "speed(mb/s)",
                                                           ip,
                                                           scheme,
                                                           pm
                                                    FROM technical_information
                                                    ORDER BY id
                                                    """;
    public static final String SELECT_BYid = """
                                                    SELECT "dr/sr",
                                                           server_id,
                                                           "port/sap",
                                                           "speed(mb/s)",
                                                           ip,
                                                           scheme,
                                                           pm
                                                    FROM technical_information
                                                    WHERE id IN (%s)
                                                    """;
    public static final String SELECT_4CLIENTS  =
            "SELECT id, server_id, \"port/sap\", \"speed(mb/s)\" FROM technical_information ORDER BY id";
    public static final String SELECT_2CHANGE = """
                                                SELECT "dr/sr",
                                                       server_id,
                                                       "port/sap",
                                                       "speed(mb/s)",
                                                       ip,
                                                       scheme,
                                                       pm
                                                FROM technical_information
                                                WHERE id = id%s
                                                """;
    public static final String SELECT_2DELETE = """
                                                SELECT COUNT(*)
                                                FROM technical_information
                                                WHERE id = id%s
                                                """;

    // ADD
    public static final String ADD_RECORD = """
                                                    INSERT INTO technical_information
                                                        ("dr/sr", server_id, "port/sap", "speed(mb/s)", ip, scheme, pm)
                                                    VALUES
                                                    ('%s', %s, '%s', '%s', '%s', '%s', '%s')
                                                    """;

    // UPDATE
    public static final String UPDATE_RECORD = """
            UPDATE technical_information SET
                "dr/sr" = '%s',
                server_id = %s,
                "port/sap" = '%s',
                "speed(mb/s)" = '%s',
                ip = '%s',
                scheme = '%s',
                pm = '%s'
            WHERE
                "dr/sr" = '%s' AND
                server_id = %s AND
                "port/sap" = '%s' AND
                "speed(mb/s)" = '%s' AND
                ip = '%s' AND
                scheme = '%s' AND
                pm = '%s'
            """;
}
