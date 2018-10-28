
package warmer.star.dto;

import warmer.star.util.BaseQueryItem;

public class LoggerQueryItem extends BaseQueryItem {
    private String title;
    private String sortCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
}
