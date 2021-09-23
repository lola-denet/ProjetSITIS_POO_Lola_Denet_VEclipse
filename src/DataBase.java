/**
 * The attributes used to create a DataBase object are made up of the url to
 * access the database and user information.
 * <p>
 * INF201 : Java project
 *
 * @author loladenet
 */
public class DataBase {
    private String db_url = "jdbc:mysql://localhost:3306/bd_projet";
    private String user = "root";
    private String pass = "root";

    /**
     * @return String : returns the database url.
     */
    public String getDB_URL() {
        return db_url;
    }

    /**
     * Modifies the url to access the database.
     *
     * @param db_url : String, database url
     */
    public void setDB_URL(String db_url) {
        this.db_url = db_url;
    }

    /**
     * @return String : returns the user id.
     */
    public String getUSER() {
        return user;
    }

    /**
     * Modifies the user id.
     *
     * @param user : String, user id
     */
    public void setUSER(String user) {
        this.user = user;
    }

    /**
     * @return String : returns the user password.
     */
    public String getPASS() {
        return pass;
    }

    /**
     * Modifies the user password.
     *
     * @param pass : String, user password
     */
    public void setPASS(String pass) {
        this.pass = pass;
    }

}
