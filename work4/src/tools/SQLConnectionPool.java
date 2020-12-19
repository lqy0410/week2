package tools;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import static java.util.Collections.*;

public class SQLConnectionPool implements DataSource {

    private static LinkedList<Connection> connectionPool =
            (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());

    static {
        for (int index = 0; index < 10; index++) {
            connectionPool.add(JdbcUtil.getConnection());
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        Connection con = null;
        if(connectionPool.size() > 0){
            con = new MyConnection(connectionPool.removeFirst(),connectionPool);
        }else{
            throw new RuntimeException("服务器繁忙...");
        }
        return con;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {

        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
