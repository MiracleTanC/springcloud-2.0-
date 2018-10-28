package warmer.star.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.blog.service.TagService;
import warmer.star.dto.TagItem;
import warmer.star.entity.Tag;
import warmer.star.util.R;

@RestController
@RequestMapping("/tag")
public class TagController extends BaseController {

	// 文章service
	@Autowired
	private TagService tagService;

	@GetMapping("/getTaglist")
	public R getTaglist() {
		List<HashMap<String, String>> maps = new ArrayList<HashMap<String, String>>();
		List<Tag> tagList = tagService.getAll();
		for (Tag tag : tagList) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("value", tag.getTagName());
			map.put("alia", tag.getAliasName());
			map.put("color", tag.getColor());
			map.put("id", tag.getId().toString());
			maps.add(map);
		}
		return R.success().put("data", maps);
	}

	@PostMapping("/saveTag")
	public R saveTag(TagItem submitItem) {
		int id = 0;
		try {
			if (submitItem.getId() == 0) {
				tagService.saveTag(submitItem);
				id = submitItem.getId();
			} else {
				boolean result = tagService.updateTag(submitItem);
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

	@GetMapping("/deleteTag/{tagId}")
	public R deleteTag(@PathVariable("tagId")int tagId) {
		boolean result = false;
		try {
			if (tagId > 0) {
				result = tagService.deleteTag(tagId);
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