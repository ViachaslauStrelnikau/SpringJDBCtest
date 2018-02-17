import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodsDAOimpl implements GoodsDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void selectall() {
        String sql_st="select * from goods";
        Connection con = null;
        try {
            con=dataSource.getConnection();
             Statement st= con.createStatement();
             st.execute(sql_st);
            ResultSet rs= st.getResultSet();
            while (rs.next())
            {
                System.out.println(rs.getString("name"));
            }
            con.close();

        } catch (SQLException e) {
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
