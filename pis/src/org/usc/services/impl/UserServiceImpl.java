package org.usc.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.usc.beans.User;
import org.usc.daos.base.BaseDaoSupport;
import org.usc.services.IUserService;

/**
 *
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-10<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Service("org.usc.services.userService")
public class UserServiceImpl extends BaseDaoSupport<User> implements IUserService {

	public void saveUserWithImage(User user, File image) throws Exception  {
		if (image != null) {
			FileInputStream fin = new FileInputStream(image);// File 转 InputStream
			Blob blob =Hibernate.getLobCreator(getSession()).createBlob(fin, image.length());
			user.setPicture(blob);
		}

		save(user);

	}

}
