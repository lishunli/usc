package cn.itcast.service.product;

import cn.itcast.bean.QueryResult;
import cn.itcast.bean.product.ProductInfo;
/**
 * ��Ʒȫ������
 *
 */
public interface ProductSearchService {
	public QueryResult<ProductInfo> search(String key, int startIndex, int maxResult);
}
