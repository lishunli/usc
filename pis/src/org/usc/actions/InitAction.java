package org.usc.actions;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.beans.Product;
import org.usc.dto.ProductDto;
import org.usc.services.ProductService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * init.action
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-9<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Controller
@Scope("prototype")
@Results({ @Result(name = "success", location = "show.jsp"), @Result(name = "input", location = "init.jsp") })
public class InitAction extends ActionSupport {
	private static final long serialVersionUID = 6827855942969812414L;

	private String model;
	private BigDecimal amount;

	private ProductDto dto;

	@Resource(name = "org.usc.services.productService")
	private ProductService productService;

	@Value("${basePath}")
	private String basePath;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ProductDto getDto() {
		return dto;
	}

	public void setDto(ProductDto dto) {
		this.dto = dto;
	}

	@Validations(
			requiredFields = { @RequiredFieldValidator(fieldName = "model", shortCircuit = true)
			},
			requiredStrings = @RequiredStringValidator(fieldName = "model", message = "产品型号必填！", trim = false)
			)
			public String execute() throws Exception {
		if (amount == null) {
			this.addFieldError("amount", "产品数量不能为空！");
			return INPUT;
		}

		Product product = productService.findByModel(model);
		if (product == null) {
			this.addFieldError("model", "找不到对应的产品，请检查！");
			return INPUT;
		} else {
			BigDecimal injectionAmt = amount.multiply(product.getSamplingRatio()).setScale(0, 1);

			if (injectionAmt.signum() <= 0) {
				this.addFieldError("amount", "抽样的数量不足一个，请重新数量数量！");
				return INPUT;
			}

			dto = new ProductDto(
					product.getProductId(), product.getModel(),
					product.getName(),
					product.getSamplingRatio().multiply(new BigDecimal("1000")).stripTrailingZeros() + "‰",
					product.getStandardLength().stripTrailingZeros().toString(),
					product.getErrorRange().stripTrailingZeros().toString(),
					injectionAmt.intValue(),
					basePath + "/" + product.getDraw().getName());
		}

		// TODO
		/**
		 * 1. 显示这个product 详细信息，比如型号，名称，抽样比例，图纸（重要）等等 2. 根据抽象比例 显示 table 3. js 直接判断数量的 table 中 size 是否满足，直接得到结论 4. 有时间，可以尝试直接导出 table 数据 到 excel 中
		 */

		return SUCCESS;
	}
}
