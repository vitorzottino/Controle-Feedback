package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93360", "100903");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
