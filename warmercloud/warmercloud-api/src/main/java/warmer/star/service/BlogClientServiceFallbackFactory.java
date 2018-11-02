package warmer.star.service;

import org.springframework.stereotype.Component;

import warmer.star.entity.UserInfo;
import feign.hystrix.FallbackFactory;

@Component
public class BlogClientServiceFallbackFactory implements FallbackFactory<BlogClientService>{

	@Override
	public BlogClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new BlogClientService() {
			
			@Override
			public Object serverdiscovery() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public UserInfo getuser(String code) {
				// TODO Auto-generated method stub
				return new UserInfo().setUsername("服务降级不可用,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
			}
		};
	}

}
