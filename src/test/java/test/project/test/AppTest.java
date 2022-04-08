package test.project.test;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import test.bean.UserBean;
import test.dao.Dao;
import test.model.User;
import test.service.TestServiceImpl;

public class AppTest{
	@InjectMocks
	TestServiceImpl testService;
	
	@Mock
	Dao dao;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEmployeesTest()
	{
		List<User> listUser= new ArrayList<User>();
		User user=new User();
		user.setuName("Mohan");
		user.setuEmail("mohan@gmail.com");
		User user1=new User();
		user1.setuName("shyam");
		user1.setuEmail("shyam@gmail.com");
		
		listUser.add(user);
		listUser.add(user1);
		
		when(dao.fetchUser()).thenReturn(listUser);
		
		List<UserBean> userList=testService.fetchUser();
		assertEquals(2,userList.size());
		verify(dao, times(1)).fetchUser();
	}
	
	@Test
	public void createUser() {
		
		UserBean userBean=new UserBean();
		userBean.setuName("Mohan");
		userBean.setuEmail("mohan@gmail.com");
		testService.saveData(userBean);
		verify(dao,times(1)).saveData(userBean);
	}
}