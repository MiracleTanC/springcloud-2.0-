package warmer.star.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import warmer.star.dto.TagItem;
import warmer.star.entity.Tag;
@Mapper
public interface TagDao {
    List<Tag> getAll();

    int saveTag(TagItem submitItem);

    boolean updateTag(TagItem submitItem);

    boolean deleteTag(@Param("tagId" ) int tagId);
}
