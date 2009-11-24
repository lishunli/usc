package cn.itcast.bean;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.bean.book.OrderContactInfo;
import cn.itcast.bean.book.OrderDeliverInfo;
import cn.itcast.bean.book.PaymentWay;

/**
 * ���ﳵ
 */
public class BuyCart {
	/* ������ */
	private List<BuyItem> items = new ArrayList<BuyItem>();
	/* ������Ϣ */
	private OrderDeliverInfo deliverInfo;
	/* ��������ϵ��Ϣ */
	private OrderContactInfo contactInfo;
	/* ֧����ʽ */
	private PaymentWay paymentWay;
	/* ���������ջ����Ƿ���ͬ */
	private Boolean buyerIsrecipients;
	/* ���ͷ� */
	private float deliveFee = 10f;
	/* ���� */
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getDeliveFee() {
		return deliveFee;
	}

	public void setDeliveFee(float deliveFee) {
		this.deliveFee = deliveFee;
	}

	public PaymentWay getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(PaymentWay paymentWay) {
		this.paymentWay = paymentWay;
	}

	public Boolean getBuyerIsrecipients() {
		return buyerIsrecipients;
	}

	public void setBuyerIsrecipients(Boolean buyerIsrecipients) {
		this.buyerIsrecipients = buyerIsrecipients;
	}

	public OrderContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(OrderContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public OrderDeliverInfo getDeliverInfo() {
		return deliverInfo;
	}

	public void setDeliverInfo(OrderDeliverInfo deliverInfo) {
		this.deliverInfo = deliverInfo;
	}

	public List<BuyItem> getItems() {
		return items;
	}

	/**
	 * ��ӹ�����
	 * @param item ������
	 */
	public void add(BuyItem item){
		if(this.items.contains(item)){
			for(BuyItem it : this.items){
				if(it.equals(item)){
					it.setAmount(it.getAmount()+1);
					break;
				}
			}
		}else{
			this.items.add(item);
		}
	}
	/**
	 * ɾ��ָ��������
	 * @param item ������
	 */
	public void delete(BuyItem item){
		if(this.items.contains(item)) this.items.remove(item);
	}
	/**
	 * ��չ�����
	 */
	public void deleteAll(){
		this.items.clear();
	}
	
	/**
	 * ������Ʒ�����ۼ�
	 * @return
	 */
	public float getTotalSellPrice(){
		float totalprice = 0F;
		for(BuyItem item : this.items){
			totalprice += item.getProduct().getSellprice() * item.getAmount();
		}
		return totalprice;
	}
	/**
	 * ������Ʒ���г���
	 * @return
	 */
	public float getTotalMarketPrice(){
		float totalprice = 0F;
		for(BuyItem item : this.items){
			totalprice += item.getProduct().getMarketprice() * item.getAmount();
		}
		return totalprice;
	}
	/**
	 * �����ܽ�ʡ���
	 * @return
	 */
	public float getTotalSavedPrice(){
		return this.getTotalMarketPrice() - this.getTotalSellPrice();
	}
	/**
	 * ���㶩�����ܷ���
	 * @return
	 */
	public float getOrderTotalPrice(){
		return this.getTotalSellPrice()+ this.deliveFee;
	}
}
