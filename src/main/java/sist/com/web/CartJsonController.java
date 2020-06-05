package sist.com.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sist.com.dao.CartDao;

@RestController
public class CartJsonController {
    @Inject
	private CartDao dao;
	
	@RequestMapping(value="admininfo.do")
	public Object admininfo(int pk) {
		return dao.adminProductInfo(pk);
	}

}
