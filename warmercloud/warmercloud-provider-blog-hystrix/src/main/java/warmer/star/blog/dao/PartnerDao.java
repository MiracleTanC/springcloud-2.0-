package warmer.star.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import warmer.star.entity.Partner;
@Mapper
public interface PartnerDao {
    List<Partner> getAll();

    int savePartner(Partner submitItem);

    boolean updatePartner(Partner submitItem);

    boolean deletePartner(@Param("partnerId" ) int partnerId);
}
