package warmer.star.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warmer.star.blog.dao.PartnerDao;
import warmer.star.blog.service.PartnerService;
import warmer.star.entity.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerDao partnerDao;

    @Override
    public List<Partner> getAll() {
        return partnerDao.getAll();
    }

    @Override
    public int savePartner(Partner submitItem) {
        return partnerDao.savePartner(submitItem);
    }

    @Override
    public boolean updatePartner(Partner submitItem) {
        return partnerDao.updatePartner(submitItem);
    }

    @Override
    public boolean deletePartner(int PartnerId) {
        return partnerDao.deletePartner(PartnerId);
    }


}
