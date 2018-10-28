package warmer.star.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import warmer.star.entity.User;
import warmer.star.entity.UserInfo;
@Mapper
public interface UserDao {
    /**
     * 获取用户凭证
     *
     * @param username 账号
     * @return
     */
    User getUser(@Param("username" ) String username);

    /**
     * 获取所有的用户
     *
     * @return
     */
    List<User> allUser();

    UserInfo getUserInfo(@Param("username" ) String username);

    void updateAvatar(@Param("url" ) String url, @Param("username" ) String username);

    void updatePassword(User user);

    void updateUserInfo(UserInfo userInfo);
}
