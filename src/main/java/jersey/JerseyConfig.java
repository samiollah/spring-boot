package jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/cavandish")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(EndPoints.class);
    }

}
