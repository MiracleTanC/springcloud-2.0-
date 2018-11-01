package warmer.star.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import warmer.star.balancerule.CustomRule;
@SpringBootApplication
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//服务发现
@RibbonClient(name="WARMERCLOUD-SEARCH",configuration=CustomRule.class)
public class BlogCustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogCustomerApplication.class, args);
	}
}
