package cxfrest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-3-24
 * Time: 下午5:32
 * To change this template use File | Settings | File Templates.
 */
public class TestOutInterceptor extends AbstractPhaseInterceptor{

    public TestOutInterceptor(String phase) {
        super(phase);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        System.out.println("hello out interceptor\n");
    }

}
