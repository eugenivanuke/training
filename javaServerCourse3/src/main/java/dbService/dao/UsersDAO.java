package dbService.dao;

import dbService.dataSets.UsersDataSets;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by clr on 08.11.2016.
 */
public class UsersDAO {
    private Executor executor;


    public UsersDAO (Connection conn) {
        this.executor = new Executor(conn);
    }

    public UsersDataSets get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, resultSet -> {
            resultSet.next();
            return new UsersDataSets(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
        });
    }

    public long getUsersId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", resultSet -> {
            resultSet.next();
            return resultSet.getLong(1);
        });
    }

    public void insertUser(String name, String password) throws SQLException {
        executor.execUpdate("insert into users (user_name, user_password) values ('" + name + "', '" + password + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), user_password varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
