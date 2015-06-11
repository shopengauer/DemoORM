package com.vspavlov.demoorm;

import com.vspavlov.demoorm.domain.users.MdbRole;
import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.dto.MdbUserCreateForm;

import com.vspavlov.demoorm.service.MdbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.function.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoOrmApplication.class)
@WebAppConfiguration
public class DemoOrmApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(getClass());


	private MdbUserService mdbUserService;
	@Autowired
	private JavaMailSender javaMailSender;


	//@Test
	public void testInsertMdbUser() throws Exception {

		MdbUserCreateForm form = new MdbUserCreateForm();
		form.setUsername("Vasiliy");
		form.setPassword("qwasw");

		form.setPasswordRepeated("qwasw");
		form.setRole(MdbRole.ADMIN_USER);
        mdbUserService.create(form);
	}

	//@Test
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

	@Test
	public void initMdbUser(){

		MdbUser user = new MdbUser();
		System.out.println(user.isEnabled());
	}

    @Test
	public void sendEmail(){
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo("vpavlov79@yandex.ru");
		email.setFrom("vspavlov79@gmail.com");
		email.setSubject("Test");
		email.setText("Test email");
      //  logger.info(javaMailSender);
	 	javaMailSender.send(email);

	}


}
