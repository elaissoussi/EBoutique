package com.melaisso.melaisso;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOTest {

	@Test
	public void test() {

		try {
			ClassPathXmlApplicationContext app=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
		
	}

}
