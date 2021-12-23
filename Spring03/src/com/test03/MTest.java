package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Emp hong = factory.getBean("hong",Emp.class);
		Emp lee = factory.getBean("lee",Emp.class);
		
		System.out.println(hong);
		System.out.println(lee);
	}

}
