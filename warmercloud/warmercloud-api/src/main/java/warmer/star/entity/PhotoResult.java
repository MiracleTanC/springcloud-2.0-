package warmer.star.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class PhotoResult implements Serializable{

    private int success;    //成功标准 0失败 1成功
    private String url;     //图片url
    private String message; //错误信息
}
