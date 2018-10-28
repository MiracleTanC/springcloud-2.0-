package warmer.star.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warmer.star.blog.dao.ArticleDao;
import warmer.star.blog.service.ArticleService;
import warmer.star.dto.ArticleItem;
import warmer.star.dto.ArticleQueryItem;
import warmer.star.dto.ArticleSubmitItem;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<ArticleItem> getArticleList(ArticleQueryItem queryItem) {
        List<ArticleItem> list = articleDao.getArticleList(queryItem);
        int i = 1;
        for (ArticleItem articleItem : list) {
            int num = (queryItem.getPageIndex() - 1) * queryItem.getPageSize() + i;
            articleItem.setSerialNumber(num);
            i++;
        }
        return list;
    }

    @Override
    public ArticleItem getById(int articleId) {
        return articleDao.getById(articleId);
    }


    @Override
    public boolean saveArticle(ArticleSubmitItem submitItem) {
        return articleDao.saveArticle(submitItem);
    }

    @Override
    public boolean updateArticle(ArticleSubmitItem submitItem) {
        return articleDao.updateArticle(submitItem);
    }

    @Override
    public boolean deleteArticle(int articleId) {
        return articleDao.deleteArticle(articleId);
    }

    @Override
    public List<ArticleItem> getRecommendArticleList() {
        return articleDao.getRecommendArticleList();
    }

    @Override
    public List<ArticleItem> getTopReadArticleList() {
        return articleDao.getTopReadArticleList();
    }


}
