package com.DevCraftLab.QuickMail;

import com.DevCraftLab.QuickMail.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class QuickMailApplicationTests {
	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() {
		System.out.println("Sending Email!!!");
		// emailService.sendEmail("almamun613@gmail.com","abdullah@mislbd.com","Testing Spring Boot","This is my first test, please Allah help!");
		//String html = ""+ "<h1 style='color:red;border:1px solid pink;'>Hello World From Mail Server!</h1>"+"";
		//emailService.sendEmailWithHTML("almamun613@gmail.com","Testing HTML Mail",html);
		//emailService.sendEmailWithFile("almamun613@gmail.com","Testing file","I am sending this message with file", new File("/Users/abdullahalmamun/Downloads/My_Image (1).jpg"));
		File file = new File("/Users/abdullahalmamun/Downloads/My_Image (1).jpg");
		try {
			InputStream inputStream = new FileInputStream(file);
			emailService.sendEmailWithFile("almamun613@gmail.com","Testing Input Steam file","I am sending this message with file",inputStream);

		}catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}
