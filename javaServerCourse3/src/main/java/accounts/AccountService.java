package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSets;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by clr on 06.11.2016.
 */
public class AccountService {
    private DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }

    public void addNewUser(UserProfiles userProfiles) throws DBException{
            long userId = dbService.addUser(userProfiles.getLogin(), userProfiles.getPassword());
            System.out.println("Added user ID: " + userId);
            UsersDataSets usersDataSets = dbService.getUser(userId);
            System.out.println("User data: " + usersDataSets);
    }

    public UserProfiles getByLogin(String login) throws  DBException{
        UsersDataSets userDataSets = (dbService.getUser(login));
        return new UserProfiles(userDataSets.getName(), userDataSets.getPassword());
    }
}