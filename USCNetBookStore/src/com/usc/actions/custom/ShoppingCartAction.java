package com.usc.actions.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.BookExtra;
import com.usc.daos.Custom;
import com.usc.daos.Shoppingcart;
import com.usc.daos.ShoppingcartDAO;
import com.usc.daos.ShoppingcartExtra;
import com.usc.services.back.Impl.SystemAdminImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ShoppingCartAction extends ActionSupport {

	//商品名  定价  优惠价  数量
	private ShoppingcartDAO shoppingcartdao;
	
	private List<ShoppingcartExtra>  shoppingcartExtra =  new ArrayList<ShoppingcartExtra>();

	private SystemAdminImpl admin;
	
	@Override
	public String execute() throws Exception {
		shoppingcartExtra.clear();
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		for(Shoppingcart shoppingcart:shoppingcartdao.findByCustomName(custom.getCustomName())){
			ShoppingcartExtra s = new ShoppingcartExtra();
			BeanUtils.copyProperties(s,shoppingcart );
			s.setPublishedPrice(admin.getPublishedPrice(shoppingcart.getCommodityId()));			
			s.setCommodityName(admin.getCommodityName(shoppingcart.getCommodityId()));		
			shoppingcartExtra.add(s);
		}
		
		Map request = (Map)ActionContext.getContext().get("request"); 
		request.put("Shoppingcart", shoppingcartExtra);
		return "success";		
	}



	public ShoppingcartDAO getShoppingcartdao() {
		return shoppingcartdao;
	}



	public void setShoppingcartdao(ShoppingcartDAO shoppingcartdao) {
		this.shoppingcartdao = shoppingcartdao;
	}



	public List<ShoppingcartExtra> getShoppingcartExtra() {
		return shoppingcartExtra;
	}

	public void setShoppingcartExtra(List<ShoppingcartExtra> shoppingcartExtra) {
		this.shoppingcartExtra = shoppingcartExtra;
	}



	public SystemAdminImpl getAdmin() {
		return admin;
	}



	public void setAdmin(SystemAdminImpl admin) {
		this.admin = admin;
	}

	
	

	
}
