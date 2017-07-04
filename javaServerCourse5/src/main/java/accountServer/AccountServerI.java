package accountServer;

/**
 * Created by clr on 23.11.2016.
 */
public interface AccountServerI {

    void addNewUser();

    void removeUser();

    void setUsersLimit(int usersLimit);

    int getUsersCount();

    int getUsersLimit();
}
