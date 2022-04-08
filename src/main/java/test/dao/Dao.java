package test.dao;

import java.util.List;

import test.bean.UserBean;
import test.model.User;

public interface Dao {
	public boolean saveData(UserBean user);
	public List<User> fetchUser();
}
