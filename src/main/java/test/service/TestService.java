package test.service;

import java.util.List;

import test.bean.UserBean;
import test.model.User;

public interface TestService {
	public boolean saveData(UserBean userBean);
	public List<UserBean> fetchUser();
}
