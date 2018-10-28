package warmer.star.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.CategoryService;
import warmer.star.dto.CategorySubmitItem;
import warmer.star.entity.Category;
import warmer.star.util.DateTimeHelper;
import warmer.star.util.R;

@RestController
@RequestMapping("/category" )
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/getCategoryDropdownlist", method = RequestMethod.GET )
    public R getCategoryDropdownlist() {

        List<Category> categoryList = categoryService.getCategoryList(0);
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> cateModeldefault = new HashMap<String, Object>();
        cateModeldefault.put("id", 0);
        cateModeldefault.put("name", "全部" );
        maps.add(cateModeldefault);
        for (Category cate : categoryList) {
            HashMap<String, Object> cateModel = new HashMap<String, Object>();
            cateModel.put("id", cate.getId().toString());
            cateModel.put("name", cate.getCategoryName());
            maps.add(cateModel);
        }
        return R.success().put("data", maps);
    }

    @GetMapping("/getCategorylist" )
    public R getCategorylist(int parentId) {

        List<Category> categoryList = categoryService.getCategoryList(parentId);
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
        for (Category cate : categoryList) {
            HashMap<String, Object> cateModel = new HashMap<String, Object>();
            cateModel.put("id", cate.getId().toString());
            cateModel.put("name", cate.getCategoryName());
            cateModel.put("sort", cate.getSort());
            cateModel.put("level", cate.getLevel().toString());
            cateModel.put("isLeaf", cate.isParent == 0);
            cateModel.put("children", new ArrayList<HashMap<String, Object>>());
            maps.add(cateModel);
        }
        return R.success().put("data", maps);
    }

    @GetMapping("/getTreelist" )
    public R getTreelist(int parentId) {
        List<Category> data = categoryService.getAll();
        List<HashMap<String, Object>> maps = getTree(parentId, data);
        return R.success().put("data", maps);

    }

    private List<HashMap<String, Object>> getTree(int parentId, List<Category> nodelList) {
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
        Iterator<Category> treeList = nodelList.stream().filter(m -> m.parentId == parentId).iterator();
        while (treeList.hasNext()) {
            Category cate = (Category) treeList.next();
            HashMap<String, Object> cateModel = new HashMap<String, Object>();
            cateModel.put("id", cate.getId().toString());
            cateModel.put("name", cate.getCategoryName());
            cateModel.put("sort", cate.getSort());
            cateModel.put("level", cate.getLevel().toString());
            cateModel.put("isLeaf", cate.getIsParent() == 0);
            cateModel.put("parentId", cate.getParentId().toString());
            List<HashMap<String, Object>> childrenList = getTree(cate.getId(), nodelList);
            if (!childrenList.isEmpty()) {
                cateModel.put("children", childrenList);
            }
            maps.add(cateModel);
        }
        return maps;
    }

    @GetMapping("/saveCate" )
    public R saveCate(CategorySubmitItem submitItem) {
        boolean result = false;
        try {
            if (submitItem.getId() == 0) {
                submitItem.setStatus(1);
                submitItem.setCreateon(DateTimeHelper.getNowDate());
                submitItem.setUpdateon(DateTimeHelper.getNowDate());
                result = categoryService.saveCategory(submitItem);
            } else {
                submitItem.setUpdateon(DateTimeHelper.getNowDate());
                result = categoryService.updateCategory(submitItem);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (result) {
            return R.success("操作成功" );
        }
        return R.error("操作失败" );
    }

    @GetMapping("/deleteCategory" )
    public R deleteCategory(int id) {
        boolean result = false;
        try {
            result = categoryService.deleteCategoryById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (result) {
            return R.success("操作成功" );
        }
        return R.error("操作失败" );
    }
}