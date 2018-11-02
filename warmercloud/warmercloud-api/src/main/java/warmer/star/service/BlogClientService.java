package warmer.star.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import warmer.star.entity.UserInfo;
//@FeignClient(value="WARMERCLOUD-BLOG")
@FeignClient(value = "WARMERCLOUD-BLOG",fallbackFactory=BlogClientServiceFallbackFactory.class)
public interface BlogClientService {
	@RequestMapping(value = "/user/getuser/{code}")
	public UserInfo getuser(@PathVariable("code") String code);
	@RequestMapping(value = "/user/serverdiscovery")
	public Object serverdiscovery();

}
