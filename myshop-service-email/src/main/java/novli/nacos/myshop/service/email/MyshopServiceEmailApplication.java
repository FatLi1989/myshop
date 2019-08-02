package novli.nacos.myshop.service.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@EnableDiscoveryClient
@ComponentScan(basePackages = "novli.nacos.myshop")
@SpringBootApplication
public class MyshopServiceEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceEmailApplication.class, args);
    }

}
