package warmer.star.blog.service;

import java.util.List;

import warmer.star.dto.CategorySubmitItem;
import warmer.star.entity.Category;

public interface CategoryService {

    List<Category> getCategoryList(Integer parentId);

    List<Category> getAll();

    boolean saveCategory(CategorySubmitItem submitItem);

    boolean updateCategory(CategorySubmitItem submitItem);

    boolean deleteCategoryById(int cateId);

    Category getById(int cateId);
}
