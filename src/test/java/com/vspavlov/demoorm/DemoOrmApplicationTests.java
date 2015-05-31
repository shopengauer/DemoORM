package com.vspavlov.demoorm;

import com.vspavlov.demoorm.domain.users.MdbRole;
import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.dto.MdbUserCreateForm;

import com.vspavlov.demoorm.service.MdbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.function.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoOrmApplication.class)
@WebAppConfiguration
public class DemoOrmApplicationTests {



	private MdbUserService mdbUserService;


	@Test
	public void testInsertMdbUser() throws Exception {

		MdbUserCreateForm form = new MdbUserCreateForm();
		form.setUsername("Vasiliy");
		form.setPassword("qwasw");

		form.setPasswordRepeated("qwasw");
		form.setRole(MdbRole.ADMIN_USER);
        mdbUserService.create(form);
	}

	@Test
	public void testFindUser() throws Exception {
		MdbUser mdbUser = mdbUserService.getMdbUserByUsername("Vasiliy").orElseThrow(new Supplier<UsernameNotFoundException>() {
			@Override
			public UsernameNotFoundException get() {
				return new UsernameNotFoundException(String.format("User with userName=%s was not found", "Vasiliy"));
			}
		});

		System.out.println(mdbUser.getPasswordHash());
		System.out.println(mdbUser.getMdbRole().toString());

	}


}
