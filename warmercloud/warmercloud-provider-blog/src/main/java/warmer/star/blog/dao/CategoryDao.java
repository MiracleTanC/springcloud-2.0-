package warmer.star.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import warmer.star.dto.CategorySubmitItem;
import warmer.star.entity.Category;
@Mapper
public interface CategoryDao {
    List<Category> getCategoryList(@Param("parentId" ) Integer parentId);

    List<Category> getAll();

    Category getById(int cateId);

    boolean saveCategory(CategorySubmitItem submitItem);

    boolean updateCategory(CategorySubmitItem submitItem);

    boolean deleteCategoryById(@Param("cateId" ) int cateId);
}
