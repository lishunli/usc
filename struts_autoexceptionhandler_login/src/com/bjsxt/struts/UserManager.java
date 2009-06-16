package com.bjsxt.struts;

public class UserManager {

	private static UserManager instance = new UserManager();
	
	private UserManager() {}
	
	public static UserManager getInstance() {
		return instance;
	}
	
//	public void login(String username, String password) {
//		if (!"admin".equals(username)) {
//			throw new UserNotFoundException(username);
//		}
//		if (!"admin".equals(password)) {
//			throw new PasswordErrorException();
//		}
//	}

//	public void login(String username, String password) {
//		if (!"admin".equals(username)) {
//			throw new ErrorCodeException("user.not.found", username);
//		}
//		if (!"admin".equals(password)) {
//			throw new ErrorCodeException("user.password.error");
//		}
//	}

	public void login(String username, String password) {
		if (!"admin".equals(username)) {
			throw new AppException("用户不能找到，用户=【" + username + "】");
		}
		if (!"admin".equals(password)) {
			throw new AppException("密码不正确!");
		}
	}
	
}
