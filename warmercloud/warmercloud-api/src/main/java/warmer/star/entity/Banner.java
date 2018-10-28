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
public class Banner implements Serializable {
    private Integer id;
    private String title;
    private String imgSrc;
    private String linkUrl;
    private Integer sortCode;
    private Integer isDeleted;
    private Date createOn;
    private Date updateOn;
    private Integer isShow;


}
