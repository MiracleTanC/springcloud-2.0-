package warmer.star.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import warmer.star.blog.service.UserService;
import warmer.star.entity.UserInfo;
import warmer.star.util.R;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getuser/{code}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public UserInfo getUser(@PathVariable("code") String code) {
		UserInfo userInfo = userService.getUserInfo(code);
		if (null == userInfo) {
			throw new RuntimeException("该name：" + code + "没有没有对应的信息");
		}
		return userInfo;
	}

	@PostMapping("/saveuserinfo")
	public R saveUserInfo(UserInfo submitItem) {
		try {
			if (submitItem.getUserId() <= 0) {
				return R.error("操作失败");
			}
			userService.updateUserInfo(submitItem);
			return R.success("操作成功");
		} catch (Exception e) {
			log.error("操作失败:{0}", e);
			log.error(e.getMessage());
		}

		return R.error("操作失败");
	}
	public UserInfo processHystrix_Get(@PathVariable("code") String code)
	{
		return new UserInfo().setUsername("该name：" + code + "没有没有对应的信息,null--@HystrixCommand");
	}
}