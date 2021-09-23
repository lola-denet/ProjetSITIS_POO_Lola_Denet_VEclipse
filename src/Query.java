import java.util.ArrayList;

/**
 * The attributes used to create a Query object are composed of a string
 * constituting the query and two ArrayLists containing the parameters to be
 * included in the query. The position of the parameter in the ArrayList
 * corresponds to the position of the parameter in the query.
 * <p>
 * INF201 : Java project
 *
 * @author loladenet
 */
public class Query {
    private final String q;
    private final ArrayList<String> stringParams = new ArrayList<>(10);
    private final ArrayList<Integer> intParams = new ArrayList<>(10);

    /**
     * The constructor receives the base query and sets both ArrayLists to null.
     *
     * @param q : String, initial query
     */
    public Query(String q) {
        super();
        this.q = q;
        for (int i = 0; i < 10; i++) {
            stringParams.add(null);
            intParams.add(null);
        }
    }

    /**
     * @return String : returns the query.
     */
    public String getQuery() {
        return this.q;
    }

    /**
     * Adds a parameter to the ArrayList storing the string parameters. The
     * insertion position corresponds to the position passed in argument (position
     * in the query).
     *
     * @param position : int, position of the parameter in the query
     * @param param    : String parameter
     */
    public void addStringParameter(int position, String param) {
        this.stringParams.add(position, param);
    }

    /**
     * @return ArrayList : returns the ArrayList that contains string parameters.
     */
    public ArrayList<String> getStringParameters() {
        return this.stringParams;
    }

    /**
     * Adds a parameter to the ArrayList storing the integer parameters. The
     * insertion position corresponds to the position passed in argument (position
     * in the query).
     *
     * @param position : int, position of the parameter in the query
     * @param param    : integer parameter
     */
    public void addIntParameter(int position, int param) {
        this.intParams.add(position, param);
    }

    /**
     * @return ArrayList : returns the ArrayList that contains integer parameters.
     */
    public ArrayList<Integer> getIntParameters() {
        return this.intParams;
    }

}
