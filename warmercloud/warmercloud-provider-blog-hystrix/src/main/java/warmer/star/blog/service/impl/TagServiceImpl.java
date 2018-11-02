package warmer.star.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warmer.star.blog.dao.TagDao;
import warmer.star.blog.service.TagService;
import warmer.star.dto.TagItem;
import warmer.star.entity.Tag;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> getAll() {
        return tagDao.getAll();
    }

    @Override
    public int saveTag(TagItem submitItem) {
        return tagDao.saveTag(submitItem);
    }

    @Override
    public boolean updateTag(TagItem submitItem) {
        return tagDao.updateTag(submitItem);
    }

    @Override
    public boolean deleteTag(int tagId) {
        return tagDao.deleteTag(tagId);
    }


}
