package cn.itcast.service.book;

import cn.itcast.bean.book.OrderItem;
import cn.itcast.service.base.DAO;

public interface OrderItemService extends DAO<OrderItem> {
	/**
	 * �޸Ķ�����Ĺ�������
	 * @param amount ��������
	 * @param itemid ������ID
	 */
	public void updateAmount(Integer amount, Integer itemid);
}
