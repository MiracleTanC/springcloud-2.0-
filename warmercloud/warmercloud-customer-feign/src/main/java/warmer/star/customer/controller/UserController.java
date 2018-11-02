package warmer.star.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.entity.UserInfo;
import warmer.star.service.BlogClientService;

@RestController
public class UserController {
	@Autowired
	private  BlogClientService blogService;  
	@RequestMapping(value = "/user/getuser/{code}")
	public UserInfo getuser(@PathVariable("code") String code)
	{
		return blogService.getuser(code);
	}
	@RequestMapping(value = "/user/serverdiscovery")
	public Object serverdiscovery(){
		return blogService.serverdiscovery();
	}

}
