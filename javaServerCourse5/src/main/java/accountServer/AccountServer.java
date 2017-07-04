package accountServer;

/**
 * Created by clr on 23.11.2016.
 */
public class AccountServer implements AccountServerI {
    private int usersLimit;
    private int usersCount;

    public AccountServer(int usersLimit) {
        this.usersLimit = usersLimit;
        this.usersCount = usersCount;
    }

    @Override
    public void addNewUser() {
        usersCount += 1;
    }

    @Override
    public void removeUser() {
        usersCount -= 1;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return usersCount;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }
}
