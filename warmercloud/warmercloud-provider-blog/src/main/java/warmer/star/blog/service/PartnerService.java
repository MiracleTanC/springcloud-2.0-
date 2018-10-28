package warmer.star.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import warmer.star.entity.Partner;

public interface PartnerService {
    List<Partner> getAll();

    int savePartner(Partner submitItem);

    boolean updatePartner(Partner submitItem);

    boolean deletePartner(@Param("partnerId" ) int partnerId);
}
