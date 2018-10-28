
package warmer.star.dto;

import java.util.Date;

import warmer.star.util.BaseQueryItem;

public class ArticleQueryItem extends BaseQueryItem {

    private Integer categoryId;
    private Integer sort;
    private String sortfield;
    private Date startdate;
    private Date enddate;

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getSortfield() {
        return sortfield;
    }

    public void setSortfield(String sortfield) {
        this.sortfield = sortfield;
    }

    public Integer status;
    public String title;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
