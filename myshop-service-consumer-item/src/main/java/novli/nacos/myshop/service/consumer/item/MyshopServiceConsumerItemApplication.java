package novli.nacos.myshop.service.consumer.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "novli.nacos.myshop", exclude = {DataSourceAutoConfiguration.class})
public class MyshopServiceConsumerItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceConsumerItemApplication.class, args);
    }

}
