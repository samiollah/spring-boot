package jersey;

import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/test")
public class EndPoints {

    @GET
    public String test(){
        return "test is ok";
    }
}
