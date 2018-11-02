package warmer.star.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warmer.star.blog.dao.CategoryDao;
import warmer.star.blog.service.CategoryService;
import warmer.star.dto.CategorySubmitItem;
import warmer.star.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoryList(Integer parentId) {
        return categoryDao.getCategoryList(parentId);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public boolean saveCategory(CategorySubmitItem submitItem) {
        return categoryDao.saveCategory(submitItem);
    }

    @Override
    public boolean updateCategory(CategorySubmitItem submitItem) {
        return categoryDao.updateCategory(submitItem);
    }

    @Override
    public boolean deleteCategoryById(int cateId) {
        return categoryDao.deleteCategoryById(cateId);
    }

    @Override
    public Category getById(int cateId) {
        return categoryDao.getById(cateId);
    }

}
