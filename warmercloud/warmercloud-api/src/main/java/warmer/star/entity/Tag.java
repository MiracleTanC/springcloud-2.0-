package warmer.star.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Tag implements Serializable {
    private Integer id;

    private String tagName; //标签名

    private String aliasName;  //别名
    private String color;  //别名
}
