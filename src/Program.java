import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

/**
 * This class corresponds to the main program. It allows interaction between the
 * user and the database. The purpose of this program is to allow the user to
 * access the database and perform predefined queries.
 * <p>
 * INF201 : Java project
 *
 * @author loladenet
 */

public class Program {
    /**
     * This method runs the main menu allowing the user to enter the program.
     *
     * @param args : list of string arguments
     */
    public static void main(String[] args) {
        DataBase db = new DataBase();
        while (true) {
            showMenu();
            int answer = integerInput();
			switch (answer) {
				case 1 -> createNewConnection();
				case 2 -> openConnectionAndExecute(db);
				case 0 -> {
					System.out.println("\n Au revoir\n");
					System.exit(0);
				}
				default -> System.out.println("Vous devez saisir 1 pour Oui ou 2 pour non. Recommencer");
			}
        }
    }

    /**
     * This method opens the connection to the database, adds the parameters to the
     * query and executes it.
     *
     * @param db : DataBase object
     */
    public static void openConnectionAndExecute(DataBase db) {
        while (true) {
            Query query = chooseQuery();
            // Open a connection
            try {
                Connection conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
                PreparedStatement pst = conn.prepareStatement(query.getQuery());
                ArrayList<Integer> intParams = query.getIntParameters();
                ArrayList<String> stringParams = query.getStringParameters();
                System.out.println("\nConnexion réussie\n");

                // Integrate the parameters into the query
                for (int i = 1; i < intParams.size() - 1; i++) {
                    if (intParams.get(i) != null) {
                        pst.setInt(i, intParams.get(i));
                    }
                    if (stringParams.get(i) != null) {
                        pst.setString(i, stringParams.get(i));
                    }
                }

                ResultSet rs = pst.executeQuery();
                // Extract data from result set
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                while (rs.next()) {
                    // The column count starts from 1
                    for (int i = 1; i <= columnCount; i++) {
                        String name = rsmd.getColumnName(i);
                        // Retrieve by column name
                        System.out.println(name + " : " + rs.getString(name));
                    }
                }

            } catch (SQLException e) {
                System.out.println("\nConnexion échouée\n");
                e.printStackTrace();
                break;

            }
        }

    }

    /**
     * This method proposes queries and allows you to choose the parameters.
     *
     * @return Query : Returns the selected query with the parameters.
     */
    public static Query chooseQuery() {
        Query q1 = new Query("SELECT * FROM tab_patient WHERE ID_PATIENT = ?;");
        Query q2 = new Query("SELECT * FROM tab_hospitalisation WHERE ID_PATIENT = ?;");
        Query q3 = new Query(
                "SELECT tab_patient.ID_PATIENT FROM tab_patient INNER JOIN tab_hospitalisation ON tab_patient.ID_PATIENT WHERE SEXE = ? AND DATE_ENTREE = ?;");
        while (true) {
            System.out.println("\nTaper 1 : Afficher les informations d'un patient");
            System.out.println("Taper 2 : Afficher les hospitalisations d'un patient");
            System.out.println(
                    "Taper 3 : Afficher les id des patients de sexe féminin ou masculin hospitalisés à une certaine date\n");
            System.out.println("Taper 0 : quitter le programme");
            int answer = integerInput();

            int intParam;
            int position;
            String stringParam;

			switch (answer) {
				case 1 -> {
					System.out.println("Entrer l'id du patient (6 chiffres) : ");
					intParam = integerInput();
					position = 1;
					q1.addIntParameter(position, intParam);
					return q1;
				}
				case 2 -> {
					System.out.println("Entrer l'id du patient (6 chiffres): ");
					intParam = integerInput();
					position = 1;
					q2.addIntParameter(position, intParam);
					return q2;
				}
				case 3 -> {
					System.out.println("Entrer le sexe du patient (1 ou 2) : ");
					intParam = integerInput();
					position = 1;
					q3.addIntParameter(position, intParam);
					System.out.println("Entrer la date d'hospitalisation (au format AAAA-MM-JJ) : ");
					stringParam = stringInput();
					position = 2;
					q3.addStringParameter(position, stringParam);
					return q3;
				}
				case 0 -> {
					System.out.println("\n Au revoir\n");
					System.exit(0);
				}
				default -> System.out.println("Votre saisie doit faire partie des propositions. Recommencer");
			}
        }

    }

    /**
     * This method allows you to create a new connection by choosing the url, the
     * user and his connection password.
     */
    public static void createNewConnection() {
        System.out.println("Saisir l'hôte : ");
        String host = stringInput();

        System.out.println("Saisir le port : ");
        int port = integerInput();

        System.out.println("Saisir le nom de la base de données : ");
        String dbName = stringInput();

        System.out.println("Saisir le nom d'utilisateur : ");
        String userName = stringInput();

        System.out.println("Saisir le mot de passe utilisateur : ");
        String userPass = stringInput();

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        DataBase db = new DataBase();
        db.setDB_URL(url);
        db.setUSER(userName);
        db.setPASS(userPass);

        openConnectionAndExecute(db);

    }

    /**
     * This method only allows the display of the main menu.
     */
    public static void showMenu() {
        System.out.println("\n\nBienvenue dans le programme de requêtage du PMSI\n");
        System.out.println("L'URL par défaut est : jdbc:mysql://localhost:3306/bd_projet");
        System.out.println("L'utilisateur part défaut est : root\n");
        System.out.println("Souhaitez-vous changer ces informations ?");
        System.out.println("Taper 1 : oui");
        System.out.println("Taper 2 : non\n");
        System.out.println("Taper 0 pour quitter le programme.\n");
    }

    /**
     * This method allows you to retrieve the keyboard input of integers.
     *
     * @return Integer : returns the integer entered by the user.
     */
    public static int integerInput() {
        while (true) {
            try {
                BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                String str = buff.readLine();
				return Integer.parseInt(str);
            } catch (NumberFormatException monexception) {
                System.out.println("Vous devez saisir un nombre");
                System.out.println("Recomencez");
            } catch (IOException e) {
                System.out.println(" Erreur " + e);
                return -1;
            }
        }
    }

    /**
     * This method allows you to retrieve the keyboard input of strings.
     *
     * @return String : returns the string entered by the user.
     */
    public static String stringInput() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			return buff.readLine();
        } catch (IOException e) {
            System.out.println(" Erreur" + e);
            return null;
        }
    }

}
