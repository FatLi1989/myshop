package novli.nacos.myshop.service.provider.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "novli.nacos.myshop")
@MapperScan(basePackages = "novli.nacos.myshop.commons.mapper")
public class MyshopServiceProviderItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceProviderItemApplication.class, args);
    }

}
