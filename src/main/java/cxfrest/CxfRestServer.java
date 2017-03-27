package cxfrest;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.phase.Phase;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-3-22
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
public class CxfRestServer {
    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        //配置两个自定义的服务TestService1和TestService2
        factory.setResourceClasses(TestService1.class, TestService2.class);
        //设置TestService1为单例
        factory.setResourceProvider(TestService1.class,
                new SingletonResourceProvider(new TestService1()));
        factory.setResourceProvider(new SingletonResourceProvider(new TestService1()));
        //设置访问地址，必须为本机可用的ip或者host name(如localhost)
        factory.setAddress("http://localhost:9999/");
        //增加过滤器
        factory.getInInterceptors().add(new TestInInterceptor(Phase.RECEIVE));
        //增加过滤器
        factory.getOutInterceptors().add(new TestOutInterceptor(Phase.MARSHAL));
        //创建服务
        factory.create();
    }

}
