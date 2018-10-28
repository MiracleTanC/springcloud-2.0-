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
public class Category implements Serializable {

    private Integer id;

    public String categoryCode;

    private String categoryName; // 分类名称

    private String fullName; // 分类全称

    private Integer sort;

    public Integer parentId;


    public Integer isParent;

    public String path;

    public Integer level;

    public Integer status;

    public Date createOn;

    public Date updateOn;

    
}
