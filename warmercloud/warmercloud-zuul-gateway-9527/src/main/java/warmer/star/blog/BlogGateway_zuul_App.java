package warmer.star.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//服务发现ss
@EnableZuulProxy
public class BlogGateway_zuul_App {
	public static void main(String[] args) {
		SpringApplication.run(BlogGateway_zuul_App.class, args);
	}

}
