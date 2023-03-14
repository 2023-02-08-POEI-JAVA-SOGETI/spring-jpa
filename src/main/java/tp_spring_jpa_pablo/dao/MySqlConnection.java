package tp_spring_jpa_pablo.dao;

public class MySqlConnection {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306?useSSL=false";
    private static final String DATABASE_USER = "root";
    private static final String DATABASEP_ASSWORD = "Pelicano3344!!";
    private static final String ROWSET_DATABASE_URL = "jdbc:mysql://localhost:3306/a?useSSL=false";

    public static final String getDatabaseUrl() {
        return DATABASE_URL;
    }
    
    public static final String getDatabaseUser() {
        return DATABASE_USER;
    }

    public static final String getDatabasePasword() {
        return DATABASEP_ASSWORD;
    }
    public static final String getRowSetDatabaseUrl() {
        return ROWSET_DATABASE_URL;
    }
}
