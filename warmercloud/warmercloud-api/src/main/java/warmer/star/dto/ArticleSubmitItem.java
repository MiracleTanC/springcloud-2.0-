package warmer.star.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ArticleSubmitItem implements Serializable {
    private Integer id;
    private Integer categoryId; //分类id 
    private String title;   //标题
    private String content;  //内容
    private String abstractContent; //摘要内容
    private String publishTime; //显示时间
    private String coverImage; //封面图片
    private String[] coverImageList; //封面图片
    private String articleTags; //文章标签
    private Integer openComment; //打开评论
    private Integer isRecommend; //是否推荐
    private Integer status;  //状态
    private Integer showStyle;  //显示样式
    private Integer articleType;
    private String author; //作者
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间
}
