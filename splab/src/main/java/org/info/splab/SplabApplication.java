package org.info.splab;

import org.info.splab.difexamples.ClientComponent;
import org.info.splab.difexamples.SingletonComponent;
import org.info.splab.difexamples.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SplabApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(SplabApplication.class, args);

        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent)context.getBean("clientComponent");
        c.operation();
    }

}
