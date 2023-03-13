package tp_spring_jpa_pablo.dao;

public class MySqlConnection {
	private static final String DATABASEURL = "jdbc:mysql://localhost:3306?useSSL=false";
    private static final String DATABASEUSER = "root";
    private static final String DATABASEPASWORD = "Pelicano3344!!";
    private static final String ROWSETDATABASEURL = "jdbc:mysql://localhost:3306/a?useSSL=false";

    public static final String getDatabaseUrl() {
        return DATABASEURL;
    }
    
    public static final String getDatabaseUser() {
        return DATABASEUSER;
    }

    public static final String getDatabasePasword() {
        return DATABASEPASWORD;
    }
    public static final String getRowSetDatabaseUrl() {
        return ROWSETDATABASEURL;
    }
}
