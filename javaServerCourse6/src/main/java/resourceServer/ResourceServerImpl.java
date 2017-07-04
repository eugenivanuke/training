package resourceServer;

import resource.Resource;
import sax.ReadXMLFileSAX;

/**
 * Created by clr on 06.12.2016.
 */
public class ResourceServerImpl implements ResourceServer {
    private final Resource resource;

    public ResourceServerImpl (Resource resource) {
        this.resource = resource;
    }

    @Override
    public int getAge() {
        return resource.getAge();
    }

    @Override
    public String getName() {
        return resource.getName();
    }

    @Override
    public void setAge(int age) {
        resource.setAge(age);
    }

    @Override
    public void setName(String name) {
        resource.setName(name);
    }

    public void saveParsedFrom (String path) {
        Resource parsed = (Resource)ReadXMLFileSAX.readXML(path);
        resource.setName(parsed.getName());
        resource.setAge(parsed.getAge());
    }
}
