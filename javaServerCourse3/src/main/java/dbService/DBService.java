package dbService;

import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSets;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by clr on 08.11.2016.
 */
public class DBService {
    private final Connection conn;

    public DBService () {
        this.conn = getMySqlConnection();
    }

    public static Connection getMySqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("mysql1488?").
                    append("user=root&").
                    append("password=cooler");

            System.out.println("URL: " + url + "\n");

            Connection conn = DriverManager.getConnection(url.toString());
            return conn;
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UsersDataSets getUser(long id) throws DBException {
        try {
            return (new UsersDAO(conn).get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public UsersDataSets getUser(String name) throws DBException {
        try {
            return (getUser(new UsersDAO(conn).getUsersId(name)));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public long addUser(String name, String password) throws DBException {
        try {
            conn.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(conn);
            dao.insertUser(name, password);
            conn.commit();
            return dao.getUsersId(name);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public void cleanUp() throws DBException {
        UsersDAO dao = new UsersDAO(conn);
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void createTable() throws  DBException {
        UsersDAO dao = new UsersDAO(conn);
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void printConnectInfo() {
        try {
            System.out.println("DB name: " + conn.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + conn.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + conn.getMetaData().getDriverName());
            System.out.println("Autocommit: " + conn.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
