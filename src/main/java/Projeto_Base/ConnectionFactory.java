package Projeto_Base;

import java.sql.*;

public class ConnectionFactory
{
    private static final String url = "jdbc:mysql://sa-diego2-80f1.d.aivencloud.com:12675/SA_PROJETO";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_B-s0a1jGg_ik3viwPtJ";

    private static Connection conn;

    public static Connection getConn()
    {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            else
            {
                return conn;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ConnectionFactory() throws SQLException
    {
        conn = DriverManager.getConnection(url,user,password);
    }
}
