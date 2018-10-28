package warmer.star.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class ArticleTag implements Serializable {

    private Integer articleId;  //文章id

    private Integer tagId;  //标签id

    private String tagName;  //标签名

   
}
