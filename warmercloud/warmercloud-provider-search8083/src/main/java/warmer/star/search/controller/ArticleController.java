package warmer.star.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.dto.ArticleItem;
import warmer.star.dto.ArticleQueryItem;
import warmer.star.util.PageRecord;
import warmer.star.util.R;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/search" )
public class ArticleController{

    @GetMapping("/getsearchlist" )
    public R getArticlelist(ArticleQueryItem query) {
        PageHelper.startPage(query.getPageIndex(), query.getPageSize(), true);
        // 获取文章列表
        ArticleItem item=new ArticleItem();
        item.setId(1);
        item.setTitle("测试8083");
        List<ArticleItem> articleList =new ArrayList<ArticleItem>();
        articleList.add(item);
        PageRecord<ArticleItem> pageRecord = new PageRecord<ArticleItem>();
        pageRecord.setRows(articleList);
        pageRecord.setCurrentPage(query.getPageIndex());
        pageRecord.setCurrentPageSize(query.getPageSize());
        pageRecord.setTotalCount(25);
        pageRecord.setTotalPage(3);
        return R.success().put("data", pageRecord);
    }


}