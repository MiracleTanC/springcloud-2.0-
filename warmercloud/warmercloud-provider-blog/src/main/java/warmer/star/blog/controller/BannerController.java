package warmer.star.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.BannerService;
import warmer.star.dto.BannerItem;
import warmer.star.dto.BannerQueryItem;
import warmer.star.dto.BannerSubmitItem;
import warmer.star.util.DateTimeHelper;
import warmer.star.util.PageRecord;
import warmer.star.util.R;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController {
	@Autowired
	private BannerService bannerService;

	@GetMapping("/getBannerlist")
	public R getBannerlist(BannerQueryItem query) {
		PageHelper.startPage(query.getPageIndex(), query.getPageSize(), true);
		List<BannerItem> BannerList = bannerService.getBannerList(query);
		PageInfo<BannerItem> pageInfo = new PageInfo<BannerItem>(BannerList);
		long total = pageInfo.getTotal();
		int pages = pageInfo.getPages();
		PageRecord<BannerItem> pageRecord = new PageRecord<BannerItem>();
		pageRecord.setRows(BannerList);
		pageRecord.setCurrentPage(query.getPageIndex());
		pageRecord.setCurrentPageSize(query.getPageSize());
		pageRecord.setTotalCount(total);
		pageRecord.setTotalPage(pages);
		return R.success().put("data", pageRecord);
	}

	@GetMapping("/getBanner/{bannerId}")
	public BannerItem getBanner(@PathVariable("bannerId") int bannerId) {
		BannerItem banner = bannerService.getById(bannerId);
		return banner;
	}

	@PostMapping("/saveBanner")
	public R saveBanner(BannerSubmitItem submitItem) {
		boolean result = false;
		try {
			if (submitItem.getId() == 0) {
				submitItem.setCreateOn(DateTimeHelper.getNowDate());
				submitItem.setUpdateOn(DateTimeHelper.getNowDate());
				submitItem.setIsDeleted(0);
				result = bannerService.saveBanner(submitItem);
			} else {
				submitItem.setUpdateOn(DateTimeHelper.getNowDate());
				result = bannerService.updateBanner(submitItem);
			}

		} catch (Exception e) {
			log.error("操作失败:{0}", e);
			log.error(e.getMessage());
			result = false;
		}
		if (result) {
			return R.success("操作成功");
		}
		return R.error("操作失败");
	}

	@GetMapping("/deleteBanner/{bannerId}")
	public R deleteBanner(@PathVariable("bannerId") int bannerId) {
		boolean result = false;
		try {
			result = bannerService.deleteBanner(bannerId);
		} catch (Exception e) {
			log.error("操作失败:{0}", e);
			log.error(e.getMessage());
			result = false;
		}
		if (result) {
			return R.success("操作成功");
		}
		return R.error("操作失败");
	}
}