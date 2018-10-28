package warmer.star.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class CategorySubmitItem implements Serializable {

    private Integer id;

    private String name; //分类名

    private String code;   //分类别名

    private Integer sort;
    private Integer status;

    private Integer parentId;
    private Date createon;
    private Date updateon;


}
