package accounts;

/**
 * Created by clr on 06.11.2016.
 */
public class UserProfiles {
    private final String login;
    private final String password;

    public UserProfiles (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserProfiles (String login) {
        this.login = login;
        this.password = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
