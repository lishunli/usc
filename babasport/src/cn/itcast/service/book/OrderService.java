package cn.itcast.service.book;

import cn.itcast.bean.BuyCart;
import cn.itcast.bean.book.DeliverWay;
import cn.itcast.bean.book.Order;
import cn.itcast.bean.book.PaymentWay;
import cn.itcast.service.base.DAO;

public interface OrderService extends DAO<Order> {
	/**
	 * ��������
	 * @param orderid ������
	 */
	public void unLock(String orderid);
	/**
	 * ������ȡ����
	 * @param orderid ������
	 * @param employee Ա���˺�
	 * @return
	 */
	public Order getLockOrder(String orderid, String employee);
	/**
	 * ȡ������
	 * @param orderid ������
	 */
	public void cancelOrder(String orderid);
	/**
	 * ���ͨ������
	 * @param orderid ������
	 */
	public void confirmOrder(String orderid);
	/**
	 * ȷ�϶�����֧��
	 * @param orderid ������
	 */
	public void confirmPayment(String orderid);
	/**
	 * �Ѷ���תΪ�ȴ�����״̬
	 * @param orderid ������
	 */
	public void turnWaitdeliver(String orderid);
	/**
	 * �Ѷ���תΪ�ѷ���״̬
	 * @param orderid ������
	 */
	public void turnDelivered(String orderid);
	/**
	 * �Ѷ���תΪ���ջ�״̬
	 * @param orderid ������
	 */
	public void turnReceived(String orderid);
	/**
	 * �������ͷ���
	 * @param deliverFee ���ͷ�
	 * @param orderid ������
	 */
	public void updateDeliverFee(Float deliverFee, String orderid);
	/**
	 * ��������
	 * @param cart ���ﳵ
	 * @param username �˿��û���
	 */
	public Order createOrder(BuyCart cart, String username);
	/**
	 * ����֧����ʽ
	 * @param paymentWay ֧����ʽ
	 * @param orderid ������
	 */
	public void updatePaymentWay(PaymentWay paymentWay, String orderid);
	/**
	 * �������ͷ�ʽ
	 * @param deliverWay ���ͷ�ʽ
	 * @param orderid ������
	 */
	public void updateDeliverWay(DeliverWay deliverWay, String orderid);
}
