package test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.UserBean;
import test.dao.Dao;
import test.model.User;


@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private Dao dao;
	
	@Override  
	public boolean saveData(UserBean user) {
		return this.dao.saveData(user);
	}

	@Override
	public List<UserBean> fetchUser() {
		List<UserBean> userBeanList=new ArrayList<UserBean>();
		List<User> list=this.dao.fetchUser();
		if(!list.isEmpty() || list !=null) {
			for(User user:list) {
				UserBean userBean=new UserBean();
				userBean.setuName(user.getuName());
				userBean.setuEmail(user.getuEmail());
				userBeanList.add(userBean);
				
			}
		}
		return userBeanList;
	}
	
	
}
