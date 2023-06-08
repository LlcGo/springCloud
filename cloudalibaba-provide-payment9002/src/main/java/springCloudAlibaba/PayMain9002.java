package springCloudAlibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Lc
 * @Date 2023/6/8
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain9002.class,args);
    }
}
