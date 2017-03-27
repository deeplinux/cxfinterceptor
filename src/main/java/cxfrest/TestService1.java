package cxfrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-3-22
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */

@Path("/calc1")
public class TestService1 {

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
        return (a + b) + "";
    }
}
