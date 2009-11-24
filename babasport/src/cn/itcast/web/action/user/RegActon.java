package cn.itcast.web.action.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.user.Buyer;
import cn.itcast.service.user.BuyerService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.user.BuyerForm;


@Controller("/user/reg")
public class RegActon extends DispatchAction {
	@Resource(name="buyerServiceBean") BuyerService buyerService;
	
	public ActionForward regUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("reg");
	}
	
	public ActionForward reg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BuyerForm formbean = (BuyerForm) form;
		if(!buyerService.exsit(formbean.getUsername())){
			Buyer buyer = new Buyer(formbean.getUsername(),formbean.getPassword(), formbean.getEmail());
			buyerService.save(buyer);
			request.getSession().setAttribute("user", buyer);		
			request.setAttribute("message", "�û�ע��ɹ�");
			request.setAttribute("urladdress", "/customer/shopping/deliver.do");
			return mapping.findForward("message");
		}else{
			request.setAttribute("message", "�û��Ѿ�����");
			return mapping.findForward("reg");
		}
	}

	public ActionForward isUserExsit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BuyerForm formbean = (BuyerForm) form;
		if(buyerService.exsit(formbean.getUsername())){
			request.setAttribute("message", "�û��Ѿ�����");
		}else{
			request.setAttribute("message", "�û�����ʹ��");
		}
		return mapping.findForward("checkuser");
	}
}
