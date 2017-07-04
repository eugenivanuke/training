package dbService.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by clr on 08.11.2016.
 */
public class Executor {
    private final Connection conn;

    public Executor (Connection conn) {
        this.conn = conn;
    }

    public void execUpdate (String update) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.execute(update);
        stmt.close();
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute(query);
        ResultSet resultSet = stmt.getResultSet();
        T value = handler.handle(resultSet);
        resultSet.close();
        stmt.close();
        return value;
    }
}