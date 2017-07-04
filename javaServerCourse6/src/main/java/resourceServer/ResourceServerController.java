package resourceServer;

/**
 * Created by clr on 06.12.2016.
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServer resourceServer;

    public ResourceServerController (ResourceServer resourceServer){
        this.resourceServer = resourceServer;
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }
}
