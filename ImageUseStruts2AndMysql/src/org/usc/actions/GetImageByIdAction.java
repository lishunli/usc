package org.usc.actions;

import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.services.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Access : get-image-by-id.action
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-13<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */

@Controller
@Scope("prototype")
@Results( { @Result(type = "stream", params = { "contentType", "image/jpeg", "inputName", "image" }) })
public class GetImageByIdAction extends ActionSupport {

	private static final long serialVersionUID = 207987943720580274L;

	private Integer id;

	@Resource(name = "org.usc.services.userService")
	private IUserService userService;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 注意这里的方法名，和上面配置params中inputName是一致的，Struts会调用此方法（也可以使用Method配置其他方法）
	 * @return
	 * @throws Exception
	 */
	public InputStream getImage() throws Exception {
		InputStream imageStream = userService.find(id).getPicture().getBinaryStream();
		
		return imageStream;
	}

}
