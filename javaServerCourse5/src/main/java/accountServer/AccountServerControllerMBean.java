package accountServer;

/**
 * Created by clr on 23.11.2016.
 */
public interface AccountServerControllerMBean {
    public int getUsers();
    public int getUsersLimit();
    public void setUsersLimit(int usersLimit);
}
