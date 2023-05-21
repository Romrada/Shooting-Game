
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Highscore {

    /**
     * @return the score
     */
    public ArrayList getScore() {
        return score;
    }
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/highscore?&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";
    private ArrayList score = new ArrayList();
    
    public void ini(){

        try {
            Class.forName(driver);
            String query = "SELECT PLAYER_NAME,SCORE FROM HIGHSCORES ORDER BY SCORE;";
            try ( Connection con = DriverManager.getConnection(url, user, password);
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query)) {
                int colNum = getColumnNames(rs);
                score.clear();
                if (colNum > 0)
                    while (rs.next()) {
                        for (int i = 0; i < colNum; i++) {
                            if (i + 1 == colNum) {
                                getScore().add(i, rs.getString(i+1));
                            } else {
                                getScore().add(i, rs.getString(i+1));
                            }
                            //endif
                        }//endfor
                    }//endwhile
                //endif
            } catch (SQLException e) {
                System.out.println(e);
            }//end try catch
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }//end try catch
    }
    public static int getColumnNames(ResultSet rs) throws SQLException {
        int numberOfColumns = 0;
        if (rs != null) {
            //create an object based on the Metadata of the result set
            ResultSetMetaData rsMetaData = rs.getMetaData();
            //Use the getColumn method to get the number of columns returned
            numberOfColumns = rsMetaData.getColumnCount();
            //get and print the column names, column indexes start from 1
            for (int i = 1; i < numberOfColumns + 1; i++) {
                String columnName = rsMetaData.getColumnName(i);
            }//endfor
        }//endif
        //place the cursor on a new line in the console
        System.out.println();
        return numberOfColumns;
    }//end method getColumnNames
    public void add(String id, String name, double score){
         try {
            Class.forName(driver);
            String query = "INSERT INTO HIGHSCORES (HIGHSCORE_ID, PLAYER_NAME,SCORE) VALUES ("+ id + ", '" + name + "', " + score + ");";
            try { Connection con = DriverManager.getConnection(url, user, password);
                  Statement st = con.createStatement();
                    st.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println(e);
            }//end try catch
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }//end try catch
    }
}
