package cxfrest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-3-24
 * Time: 下午5:32
 * To change this template use File | Settings | File Templates.
 */
public class TestInInterceptor extends AbstractPhaseInterceptor{

    public TestInInterceptor(String phase) {
        super(phase);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        //message包含请求的参数和path等信息
        String path = (String) message.get(Message.REQUEST_URI);

        System.out.println("hello in interceptor");

        //这里让访问TestService2的请求不经过TestService2，提前返回
        if(path.indexOf("calc1")!=-1) {
            System.out.println("跳过");
        } else {
            buildRspMessage(message, Response.Status.OK,"提前返回");
        }
    }

    private void buildRspMessage(Message message, Response.Status status, Object content) {
        Response response = Response
                .status(Response.Status.OK)
                .entity(content)
                .type(MediaType.TEXT_PLAIN)
                .build();
        message.getExchange().put(Response.class,response);
    }

}
