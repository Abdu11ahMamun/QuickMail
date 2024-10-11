package com.DevCraftLab.QuickMail;

import com.DevCraftLab.QuickMail.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuickMailApplicationTests {
	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() {
		System.out.println("Sending Email!!!");
		emailService.sendEmail("almamun613@gmail.com","Testing Spring Boot","This is my first test, please Allah help!");

	}

}
