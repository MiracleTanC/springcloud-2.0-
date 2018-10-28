package warmer.star.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.PartnerService;
import warmer.star.entity.Partner;
import warmer.star.util.R;

@RestController
@RequestMapping("/partner")
public class PartnerController extends BaseController {
	@Autowired
	private PartnerService partnerService;

	@GetMapping("/getPartnerlist")
	public R getPartnerlist() {
		List<Partner> partnerList = partnerService.getAll();
		return R.success().put("data", partnerList);
	}

	@PostMapping("/savePartner")
	public R savePartner(Partner submitItem) {
		int id = 0;
		try {
			if (submitItem.getId() == 0) {
				partnerService.savePartner(submitItem);
				id = submitItem.getId();
			} else {
				boolean result = partnerService.updatePartner(submitItem);
				id = result ? submitItem.getId() : 0;
			}
		} catch (Exception e) {
			log.error("操作失败:{0}", e);
			log.error(e.getMessage());
		}
		if (id > 0) {
			R r = R.success();
			r.put("id", id);
			r.put("msg", "操作成功");
			return r;
		}
		return R.error("操作失败");
	}

	@GetMapping("/deletePartner/{partnerId}")
	public R deletePartner(@PathVariable("partnerId") int partnerId) {
		boolean result = false;
		try {
			if (partnerId > 0) {
				result = partnerService.deletePartner(partnerId);
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
}