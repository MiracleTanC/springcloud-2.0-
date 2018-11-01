package warmer.star.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//服务发现
@EnableFeignClients(basePackages= {"warmer.star"})
@ComponentScan("warmer.star")
public class BlogCustomer_FeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogCustomer_FeignApplication.class, args);
	}
}
