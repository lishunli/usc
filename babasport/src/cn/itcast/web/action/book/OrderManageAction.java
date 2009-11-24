package cn.itcast.web.action.book;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.book.Message;
import cn.itcast.bean.book.Order;
import cn.itcast.bean.book.OrderContactInfo;
import cn.itcast.bean.book.OrderDeliverInfo;
import cn.itcast.bean.book.OrderItem;
import cn.itcast.service.book.MessageService;
import cn.itcast.service.book.OrderContactInfoService;
import cn.itcast.service.book.OrderDeliverInfoService;
import cn.itcast.service.book.OrderItemService;
import cn.itcast.service.book.OrderService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.utils.WebUtil;
import cn.itcast.web.action.privilege.Permission;
import cn.itcast.web.formbean.book.OrderForm;

@Controller("/control/order/manage")
public class OrderManageAction extends DispatchAction {
	@Resource OrderContactInfoService contactInfoService;
	@Resource OrderDeliverInfoService deliverInfoService;
	@Resource OrderService orderService;
	@Resource OrderItemService itemService;
	@Resource MessageService messageService;
	
	/**
	 * Ա���������Խ���
	 */
	public ActionForward addMessageUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("addMessage");
	}
	/**
	 * ���Ա����������
	 */
	public ActionForward addMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		Message msg = new Message();
		msg.setContent(formbean.getMessage());
		msg.setOrder(new Order(formbean.getOrderid()));
		msg.setUsername(WebUtil.getEmployee(request).getUsername());
		messageService.save(msg);
		
		request.setAttribute("message", "������ӳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	
	
	public ActionForward employeeUnlockOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.unLock(formbean.getOrderid());
		request.setAttribute("directUrl", SiteUrl.readUrl("control.order.list"));
		return mapping.findForward("directUrl");
	}
	/**
	 * ������������ϵ��Ϣ�޸Ľ���
	 */
	@Permission(model="order",privilegeValue="modifyContactInfo")
	public ActionForward modifyContactInfoUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		OrderContactInfo contact = contactInfoService.find(formbean.getContactid());
		formbean.setBuyer(contact.getBuyerName());
		formbean.setBuyer_address(contact.getAddress());
		formbean.setBuyer_gender(contact.getGender());
		formbean.setBuyer_mobile(contact.getMobile());
		formbean.setBuyer_postalcode(contact.getPostalcode());
		formbean.setBuyer_tel(contact.getTel());
		formbean.setOrderid(contact.getOrder().getOrderid());
		
		return mapping.findForward("contactInfo");
	}
	/**
	 * �޸Ķ�����������ϵ��Ϣ
	 */
	@Permission(model="order",privilegeValue="modifyContactInfo")
	public ActionForward modifyContactInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		//1>��ȡ������ϵ����Ϣ����,Ȼ����������������,Ȼ�����ҵ��bean��update()�������и���
		OrderContactInfo contact = contactInfoService.find(formbean.getContactid());
		contact.setBuyerName(formbean.getBuyer());
		contact.setAddress(formbean.getBuyer_address());
		contact.setGender(formbean.getBuyer_gender());
		contact.setMobile(formbean.getBuyer_mobile());
		contact.setPostalcode(formbean.getBuyer_postalcode());
		contact.setTel(formbean.getBuyer_tel());
		this.contactInfoService.update(contact);
		
		request.setAttribute("message", "�޸ĳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ contact.getOrder().getOrderid());
		return mapping.findForward("message");
	}
	
	/**
	 * �ջ�����ϵ��Ϣ�޸Ľ���
	 */
	@Permission(model="order",privilegeValue="modifyDeliverInfo")
	public ActionForward modifyDeliverInfoUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		OrderDeliverInfo info = this.deliverInfoService.find(formbean.getDeliverid());
		formbean.setAddress(info.getAddress());
		formbean.setEmail(info.getEmail());
		formbean.setGender(info.getGender());
		formbean.setMobile(info.getMobile());
		formbean.setTel(info.getTel());
		formbean.setRecipients(info.getRecipients());
		formbean.setPostalcode(info.getPostalcode());
		//1>�����������deliverid����ҵ��bean deliverInfoService�����ջ�����Ϣ����.Ȼ����ջ�����Ϣ���������ֵ����formbean.
		return mapping.findForward("deliverInfo");
	}
	/**
	 * �޸Ķ����ջ�����ϵ��Ϣ
	 */
	@Permission(model="order",privilegeValue="modifyDeliverInfo")
	public ActionForward modifyDeliverInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		OrderDeliverInfo info = this.deliverInfoService.find(formbean.getDeliverid());
		info.setAddress(formbean.getAddress());
		info.setEmail(formbean.getEmail());
		info.setGender(formbean.getGender());
		info.setMobile(formbean.getMobile());
		info.setTel(formbean.getTel());
		info.setRecipients(formbean.getRecipients());
		info.setPostalcode(formbean.getPostalcode());
		this.deliverInfoService.update(info);
		
		request.setAttribute("message", "�޸ĳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ info.getOrder().getOrderid());
		return mapping.findForward("message");
	}
	/**
	 * �޸Ķ���֧����ʽ�޸Ľ���
	 */
	@Permission(model="order",privilegeValue="modifyPaymentWay")
	public ActionForward modifyPaymentWayUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		Order order = orderService.find(formbean.getOrderid());
		formbean.setPaymentWay(order.getPaymentWay());
		return mapping.findForward("editpaymentWay");
	}
	/**
	 * �޸Ķ���֧����ʽ
	 */
	@Permission(model="order",privilegeValue="modifyPaymentWay")
	public ActionForward modifyPaymentWay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.updatePaymentWay(formbean.getPaymentWay() ,formbean.getOrderid());		
		request.setAttribute("message", "֧����ʽ�޸ĳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	
	/**
	 * �������ͷ�ʽ�޸Ľ���
	 */
	@Permission(model="order",privilegeValue="modifyDeliverWay")
	public ActionForward modifyDeliverWayUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		Order order = orderService.find(formbean.getOrderid());
		formbean.setDeliverWay(order.getOrderDeliverInfo().getDeliverWay());
		return mapping.findForward("modifyDeliverWay");
	}
	/**
	 * �޸Ķ������ͷ�ʽ
	 */
	@Permission(model="order",privilegeValue="modifyDeliverWay")
	public ActionForward modifyDeliverWay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.updateDeliverWay(formbean.getDeliverWay() ,formbean.getOrderid());		
		request.setAttribute("message", "���ͷ�ʽ�޸ĳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	/**
	 * �޸Ĳ�Ʒ�Ĺ�����������
	 */
	@Permission(model="order",privilegeValue="modifyProductAmount")
	public ActionForward modifyProductAmountUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		OrderItem item = itemService.find(formbean.getOrderitemid());
		formbean.setAmount(item.getAmount());
		formbean.setOrderid(item.getOrder().getOrderid());
		return mapping.findForward("modifyAmount");
	}
	/**
	 * �޸Ĳ�Ʒ�Ĺ�������
	 */
	@Permission(model="order",privilegeValue="modifyProductAmount")
	public ActionForward modifyProductAmount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		itemService.updateAmount(formbean.getAmount(), formbean.getOrderitemid());
		request.setAttribute("message", "���������޸ĳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	/**
	 * ɾ��������
	 */
	@Permission(model="order",privilegeValue="deleteOrderItem")
	public ActionForward deleteOrderItem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		itemService.delete((Serializable)formbean.getOrderitemid());
		request.setAttribute("message", "ɾ��������ɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	/**
	 * �޸����ͷ�
	 */
	@Permission(model="order",privilegeValue="modifyDeliverFee")
	public ActionForward modifyDeliverFeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		Order order = orderService.find(formbean.getOrderid());
		formbean.setFee(order.getDeliverFee());
		return mapping.findForward("modifyDeliverFee");
	}
	/**
	 * �޸����ͷ�
	 */
	@Permission(model="order",privilegeValue="modifyDeliverFee")
	public ActionForward modifyDeliverFee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.updateDeliverFee(formbean.getFee(), formbean.getOrderid());
		
		request.setAttribute("message", "�޸����ͷѳɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	/**
	 * ��ӡ������
	 */
	public ActionForward printOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		Order order = orderService.find(formbean.getOrderid());		
		request.setAttribute("order", order);
		return mapping.findForward("printOrder");
	}
	
	/**
	 * ȡ������
	 */
	@Permission(model="order",privilegeValue="cancelOrder")
	public ActionForward cancelOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.cancelOrder(formbean.getOrderid());		
		request.setAttribute("message", "�����ѳɹ�ȡ��");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return mapping.findForward("message");
	}
	/**
	 * ���ͨ������
	 */
	@Permission(model="order",privilegeValue="confirmOrder")
	public ActionForward confirmOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.confirmOrder(formbean.getOrderid());		
		request.setAttribute("message", "���������ͨ��");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return mapping.findForward("message");
	}
	/**
	 * ȷ�϶�����֧��
	 */
	@Permission(model="order",privilegeValue="confirmPayment")
	public ActionForward confirmPayment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.confirmPayment(formbean.getOrderid());		
		request.setAttribute("message", "������ȷ��֧��");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.view")+"?orderid="+ formbean.getOrderid());
		return mapping.findForward("message");
	}
	/**
	 * �Ѷ���תΪ�ȴ�����״̬
	 */
	@Permission(model="order",privilegeValue="turnWaitdeliver")
	public ActionForward turnWaitdeliver(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.turnWaitdeliver(formbean.getOrderid());		
		request.setAttribute("message", "������תΪ�ȴ�����״̬");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return mapping.findForward("message");
	}
	/**
	 * �Ѷ���תΪ�ѷ���״̬
	 */
	@Permission(model="order",privilegeValue="turnDelivered")
	public ActionForward turnDelivered(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.turnDelivered(formbean.getOrderid());		
		request.setAttribute("message", "����תΪ�ѷ���״̬");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return mapping.findForward("message");
	}
	/**
	 * �Ѷ���תΪ���ջ�״̬
	 */
	@Permission(model="order",privilegeValue="turnReceived")
	public ActionForward turnReceived(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm) form;
		orderService.turnReceived(formbean.getOrderid());		
		request.setAttribute("message", "����תΪ���ջ�״̬");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
		return mapping.findForward("message");
	}
	
}
