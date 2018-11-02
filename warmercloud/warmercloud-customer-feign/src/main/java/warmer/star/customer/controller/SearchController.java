package warmer.star.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warmer.star.service.SearchClientService;

@RestController
public class SearchController {
	@Autowired
	private  SearchClientService blogService;  

	@RequestMapping(value = "/search/getsearchlist")
	public Object getsearchlist(){
		return blogService.getsearchlist();
	}
}
