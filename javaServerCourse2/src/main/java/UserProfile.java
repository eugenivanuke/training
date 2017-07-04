/**
 * Created by clr on 26.10.2016.
 */
public class UserProfile {
    private final String login;
    private final String password;

    public UserProfile(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
