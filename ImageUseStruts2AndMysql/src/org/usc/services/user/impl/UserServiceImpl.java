package org.usc.services.user.impl;

import org.springframework.stereotype.Service;
import org.usc.beans.User;
import org.usc.daos.base.BaseDaoSupport;
import org.usc.services.user.IUserService;

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
@Service("org.usc.services.user.userService")
public class UserServiceImpl extends BaseDaoSupport<User> implements IUserService
{


}
