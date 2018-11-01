package warmer.star.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import warmer.star.entity.UserInfo;

@RestController
//@RequestMapping(value="/")
public class UserController {
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://WARMERCLOUD-SEARCH";
	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/user/getuser/{code}")
	public UserInfo getuser(@PathVariable("code") String code)
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/user/getUser/"+code, UserInfo.class);
	}
	@RequestMapping(value = "/user/serverdiscovery")
	public Object serverdiscovery()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/blog/discovery",Object.class);
	}
	@RequestMapping(value = "/search/getsearchlist")
	public Object getsearchlist()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/search/getsearchlist",Object.class);
	}
}
