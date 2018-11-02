package warmer.star.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(value="WARMERCLOUD-SEARCH")
public interface SearchClientService {
	@RequestMapping(value = "/search/getsearchlist")
	public Object getsearchlist();
}
