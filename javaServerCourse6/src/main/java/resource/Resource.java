package resource;

/**
 * Created by clr on 06.12.2016.
 */
public class Resource {
    private String name;
    private int age;

    public Resource () {
        this.age = 0;
        this.name = "";
    }
    public Resource (int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
