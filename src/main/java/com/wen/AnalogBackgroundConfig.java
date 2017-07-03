package com.wen;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author awlwen
 * @since 2017/6/9.
 */
@Configuration
public class AnalogBackgroundConfig {
    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory()
    {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.setPort(Integer.valueOf(8081));
        tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer(){
            public void customize(Connector connector)
            {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                //设置最大连接数
                protocol.setMaxConnections(Integer.valueOf(2000));
                //设置最大线程数
                protocol.setMaxThreads(Integer.valueOf(2000));
                protocol.setConnectionTimeout(Integer.valueOf(2000));
            }
        });
        return tomcatFactory;
    }
}
