package warmer.star.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Partner implements Serializable {

	private Integer id;

	private String siteName; // 友链名称

	private String siteUrl; // 友链URL

	private String siteDesc; // 友链描述

	private Integer sort; // 排序

}
