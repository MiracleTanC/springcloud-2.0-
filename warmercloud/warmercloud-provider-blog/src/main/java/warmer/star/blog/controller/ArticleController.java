package warmer.star.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.ArticleService;
import warmer.star.dto.ArticleItem;
import warmer.star.dto.ArticleQueryItem;
import warmer.star.dto.ArticleSubmitItem;
import warmer.star.util.DateTimeHelper;
import warmer.star.util.PageRecord;
import warmer.star.util.R;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/article" )
public class ArticleController extends BaseController {

    // 文章service
    @Autowired
    private ArticleService articleService;

    @GetMapping("/getArticlelist" )
    public R getArticlelist(ArticleQueryItem query) {
        PageHelper.startPage(query.getPageIndex(), query.getPageSize(), true);
        // 获取文章列表
        List<ArticleItem> articleList = articleService.getArticleList(query);
        PageInfo<ArticleItem> pageInfo = new PageInfo<ArticleItem>(articleList);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        PageRecord<ArticleItem> pageRecord = new PageRecord<ArticleItem>();
        pageRecord.setRows(articleList);
        pageRecord.setCurrentPage(query.getPageIndex());
        pageRecord.setCurrentPageSize(query.getPageSize());
        pageRecord.setTotalCount(total);
        pageRecord.setTotalPage(pages);
        return R.success().put("data", pageRecord);
    }


    @GetMapping("/getArticleDetail/{articleId}" )
    public ArticleItem getArticleDetail(@PathVariable("articleId" ) int articleId) {
        ArticleItem articleItem = articleService.getById(articleId);
        return articleItem;
    }

    @GetMapping("/deleteArticle/{articleId}" )
    public R deleteArticle(@PathVariable("articleId" ) int articleId) {
        boolean result = false;
        try {
            result = articleService.deleteArticle(articleId);
        } catch (Exception e) {
            log.error("操作失败:{0}", e);
            log.error(e.getMessage());
            result = false;
        }
        if (result) {
            return R.success("操作成功" );
        }
        return R.error("操作失败" );
    }

    @PostMapping("/saveArticle" )
    public R saveArticle(ArticleSubmitItem submitItem) {
        boolean result = false;
        try {
            if (submitItem.getId() == 0) {
                submitItem.setCreateTime(DateTimeHelper.getNowDate());
                submitItem.setUpdateTime(DateTimeHelper.getNowDate());
                submitItem.setContent(submitItem.getContent());
                result = articleService.saveArticle(submitItem);
            } else {
                submitItem.setUpdateTime(DateTimeHelper.getNowDate());
                submitItem.setContent(submitItem.getContent());
                result = articleService.updateArticle(submitItem);
            }

        } catch (Exception e) {
            log.error("操作失败:{0}", e);
            log.error(e.getMessage());
            result = false;
        }
        if (result) {
            return R.success("操作成功" );
        }
        return R.error("操作失败" );
    }
    @GetMapping("/getRecommendArticlelist" )
    public R getRecommendArticlelist() {
        List<ArticleItem> articleList = articleService.getRecommendArticleList();
        return R.success().put("data", articleList);
    }

    @GetMapping("/getTopReadArticleList" )
    public R getTopReadArticleList() {
        List<ArticleItem> articleList = articleService.getTopReadArticleList();
        return R.success().put("data", articleList);
    }
}