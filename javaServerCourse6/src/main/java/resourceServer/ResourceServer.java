package resourceServer;

/**
 * Created by clr on 06.12.2016.
 */
public interface ResourceServer {
    int getAge();
    String getName();
    void setAge(int age);
    void setName(String name);
    void saveParsedFrom(String path);
}
