package warmer.star.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import warmer.star.dto.ArticleItem;
import warmer.star.dto.ArticleQueryItem;
import warmer.star.dto.ArticleSubmitItem;
@Mapper
public interface ArticleDao {
    List<ArticleItem> getArticleList(ArticleQueryItem queryItem);

    List<ArticleItem> getRecommendArticleList();

    List<ArticleItem> getTopReadArticleList();

    ArticleItem getById(@Param("articleId" ) int articleId);

    boolean saveArticle(ArticleSubmitItem submitItem);

    boolean updateArticle(ArticleSubmitItem submitItem);

    boolean deleteArticle(@Param("articleId" ) int articleId);
}
