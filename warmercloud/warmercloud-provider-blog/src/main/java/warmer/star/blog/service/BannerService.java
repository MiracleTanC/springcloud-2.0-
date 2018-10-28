package warmer.star.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import warmer.star.dto.BannerItem;
import warmer.star.dto.BannerQueryItem;
import warmer.star.dto.BannerSubmitItem;

public interface BannerService {
    List<BannerItem> getBannerList(BannerQueryItem queryItem);

    BannerItem getById(@Param("bannerId" ) int bannerId);

    boolean saveBanner(BannerSubmitItem submitItem);

    boolean updateBanner(BannerSubmitItem submitItem);

    boolean deleteBanner(@Param("bannerId" ) int bannerId);
}
