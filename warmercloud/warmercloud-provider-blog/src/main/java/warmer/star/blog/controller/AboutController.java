package warmer.star.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.UserService;
import warmer.star.entity.UserInfo;

@RestController
@RequestMapping("/about" )
public class AboutController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAbout/{code}", method = RequestMethod.GET)
    public UserInfo getAbout(@PathVariable("code") String code) {
        UserInfo userInfo = userService.getUserInfo(code);
        return userInfo;
    }


}