package org.usc.services.impl;

import org.springframework.stereotype.Service;
import org.usc.beans.Product;
import org.usc.daos.base.BaseDaoSupport;
import org.usc.services.ProductService;

/**
 *
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-8<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Service("org.usc.services.productService")
public class ProductServiceImpl extends BaseDaoSupport<Product> implements ProductService {

}
