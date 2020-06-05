package sist.com.dao;



 
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sist.com.bean.AdminProductBean;



@Component
public class CartDao extends SqlSessionDaoSupport {

	@Autowired
	protected void initDao(SqlSessionTemplate st) throws Exception {
		// TODO Auto-generated method stub
		this.setSqlSessionTemplate(st);
	}

	public boolean adminLoginCheck(String id, String pw) {
		String dbPass = this.getSqlSession().selectOne("adminLoginCheck",id);
		return dbPass!=null&&dbPass.equals(pw);
	}
	
	public List<AdminProductBean>selectAdmin(String id){
		//�ش� id�����ڰ� ���� ��ǰ��ϸ� �̾Ƴ���
		return this.getSqlSession().selectList("selectAdmin",id);
	}

	public void insertProduct(AdminProductBean bean) {
		this.getSqlSession().insert("insertProduct", bean);
	}
	 
	public void deleteAdminProduct(int pk) {
		this.getSqlSession().delete("deleteAdminProduct",pk);
	}
	 
	public Object adminProductInfo(int pk) {
		return this.getSqlSession().selectOne("adminProductInfo",pk);
	}
	
	public int updateProductInfO(int pk) {
		return this.getSqlSession().update("updateProductInfO",pk);
	}
	
}
