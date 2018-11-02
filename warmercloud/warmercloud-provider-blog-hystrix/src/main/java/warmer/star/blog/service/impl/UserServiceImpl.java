package warmer.star.blog.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import warmer.star.blog.dao.UserDao;
import warmer.star.blog.service.UserService;
import warmer.star.entity.User;
import warmer.star.entity.UserInfo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUser(username);
    }

    @Override
    public UserInfo getUserInfo(String username) {
        return userDao.getUserInfo(username);
    }

    @Override
    public void updateAvatar(String url, String username) {
        userDao.updateAvatar(url, username);
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userDao.updateUserInfo(userInfo);
    }

    @Override
    public User getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        return (User) session.getAttribute("user" );
    }
}


