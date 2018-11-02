package warmer.star.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.UserService;
import warmer.star.entity.UserInfo;
import warmer.star.util.R;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getuser/{code}")
	public UserInfo getUser(@PathVariable("code") String code) {
		UserInfo userInfo = userService.getUserInfo(code);
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

}