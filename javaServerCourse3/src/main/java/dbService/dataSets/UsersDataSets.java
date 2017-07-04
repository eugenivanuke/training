package dbService.dataSets;

/**
 * Created by clr on 08.11.2016.
 */
public class UsersDataSets {
    private long id;
    private String name;
    private String password;

    public UsersDataSets(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name +
                ", password='" + password +
                "\'" +
                "}";
    }
}
