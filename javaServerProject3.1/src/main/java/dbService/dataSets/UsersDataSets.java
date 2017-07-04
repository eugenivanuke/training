package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clr on 14.11.2016.
 */
@Entity
@Table(name = "users")
public class UsersDataSets implements Serializable{
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "password")
    private String password;

    public UsersDataSets(long id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public UsersDataSets (String name, String password) {
        this.setId(-1);
        this.setName(name);
        this.setPassword(password);
    }

    public UsersDataSets() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
