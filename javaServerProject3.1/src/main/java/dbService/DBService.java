package dbService;

import dbService.dataSets.UsersDataSets;

/**
 * Created by clr on 19.11.2016.
 */
public interface DBService {

    UsersDataSets getUser(long id) throws DBException;
    UsersDataSets getUser(String name) throws DBException;
    long addUser(String name, String password) throws DBException;

}
