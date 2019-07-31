package novli.nacos.myshop.service.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "novli.nacos.myshop")
@EnableDiscoveryClient
@MapperScan(basePackages = "novli.nacos.myshop.commons.mapper")
public class MyshopServiceRegApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceRegApplication.class, args);
    }

}
