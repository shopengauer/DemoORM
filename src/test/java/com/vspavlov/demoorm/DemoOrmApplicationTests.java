package com.vspavlov.demoorm;

import com.vspavlov.demoorm.domain.User;
import com.vspavlov.demoorm.domain.users.MdbRole;
import com.vspavlov.demoorm.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoOrmApplication.class)
@WebAppConfiguration
public class DemoOrmApplicationTests {


	@Autowired
	private UserRepository repository;

	@Test
	public void contextLoads() {



//
//		User user1 = repository.findAll().get(0);
//		System.out.println(user1.getUsername());
//		System.out.println(user1.getPassword());
//	List<User> users = repository.findAll();
//		for (User user : users) {
//			System.out.println(user.getUsername());
//			System.out.println(user.getPassword());
//		}

		System.out.println(MdbRole.fromString("Administrator"));
		System.out.println(MdbRole.fromString("Viewer"));
		System.out.println(MdbRole.fromString("Editor"));
	}


	@Test
	public void test1() throws Exception {

		System.out.println(MdbRole.fromString("Administrator"));
		System.out.println(MdbRole.fromString("Viewer"));
		System.out.println(MdbRole.fromString("Editor"));

	}

	@Test
	public void test2() throws Exception {

	}
}
