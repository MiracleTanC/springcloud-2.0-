package warmer.star.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class BannerItem implements Serializable {
    private Integer serialNumber;
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
