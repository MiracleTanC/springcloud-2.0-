package warmer.star.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class User implements Serializable {
	private long id;

    private String username;    //用户名

    private String password;    //密码

    private boolean expired; //过期

    private boolean locked; //被锁

    private boolean credential;  //凭证

    private boolean enabled;  //禁用

    private Date createTime;    //创建时间
}
