package warmer.star.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warmer.star.blog.dao.BannerDao;
import warmer.star.blog.service.BannerService;
import warmer.star.dto.BannerItem;
import warmer.star.dto.BannerQueryItem;
import warmer.star.dto.BannerSubmitItem;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<BannerItem> getBannerList(BannerQueryItem queryItem) {

        List<BannerItem> list = bannerDao.getBannerList(queryItem);
        int i = 1;
        for (BannerItem bannerItem : list) {
            int num = (queryItem.getPageIndex() - 1) * queryItem.getPageSize() + i;
            bannerItem.setSerialNumber(num);
            i++;
        }
        return list;
    }


    @Override
    public BannerItem getById(int bannerId) {

        return bannerDao.getById(bannerId);
    }

    @Override
    public boolean saveBanner(BannerSubmitItem submitItem) {
        return bannerDao.saveBanner(submitItem);
    }

    @Override
    public boolean updateBanner(BannerSubmitItem submitItem) {
        return bannerDao.updateBanner(submitItem);
    }

    @Override
    public boolean deleteBanner(int bannerId) {
        return bannerDao.deleteBanner(bannerId);
    }

}
