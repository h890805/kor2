package sist.com.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sist.com.bean.AdminProductBean;
 
import sist.com.dao.CartDao;
import sist.com.dao.adminCartBeans;
import twitter4j.HttpResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private CartDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="clientList.do")
	public String goshoping() {
		
		return "";
	}
	@RequestMapping(value="boardList.do")
	public String goboard() {
		
		return "board/board";
	}
	
	@RequestMapping(value="loginPro.do")
	public String loginCheckPro(String id, String pw, HttpSession session) {	 
		session.setAttribute("id", id);
		return dao.adminLoginCheck(id, pw)?"redirect:adminProductList.do":
			"redirect:admin/jsp/adminLogin.jsp";
	}
	
 
	@RequestMapping(value="adminProductList.do")
	public String ProductListPro(Model model, HttpSession session) {
		
		if(dao.selectAdmin((String) session.getAttribute("id"))!=null) {
			model.addAttribute("adminList",dao.selectAdmin((String) session.getAttribute("id")));//session에 담긴 id가져오기 || 꼭 로그인하고 와야함
		}else {
			return null;
		}
		 
		
		
		return "cart/productAdd";
} 
	
	@RequestMapping(value="productInsert.do")
	public String insertProductAdmin(AdminProductBean bean, @RequestParam(value="file",required=false)MultipartFile file ) {//multipart있으면 인코딩안해도 된다. action-servlet에 선언해둬야함.
		 
		String locations="C:\\workWeb\\Cart\\web\\src\\main\\webapp\\cartUp\\";
		FileOutputStream fos=null;
		String fileName=file.getOriginalFilename();
		if(fileName.length()>0) {
			try {
				fos=new FileOutputStream(locations.concat(fileName)); //업로드경로와 파일명 concat
				fos.write(file.getBytes());
				bean.setFileName(fileName);
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
					try {
						if(fos!=null)fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		System.out.println(bean);
	    
		  dao.insertProduct(bean);
		  
		return "redirect:adminProductList.do";
	}
	
	 
	 @RequestMapping(value="deleteAdminProduct.do")
	 public String deleteAdminProduct(int pk) {
		  
		 dao.deleteAdminProduct(pk);
		 
		 return "redirect:adminProductList.do";
	 }
	 
	/* @RequestMapping(value="adminModify.do")
	 public String modifyProductAdmin(AdminProductBean bean, @RequestParam(value="file",required=false)MultipartFile file ) {
		 System.out.println(bean);
		 System.out.println(file);
		 return "redirect:adminProductList.do";
	 }
*/
	 
	 @RequestMapping(value="adminModify.do")
		public String modifyProductAdmin(AdminProductBean bean,@RequestParam(value="file",required=false)MultipartFile file) {
			System.out.println(bean);
			System.out.println(file);
			return "redirect:adminProductList.do";
	 }
}
