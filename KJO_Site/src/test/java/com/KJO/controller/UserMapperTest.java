package com.KJO.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.KJO.mapper.UserMapper;
import com.KJO.model.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper UM;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/kjo?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PW = "1qa2ws!@";
	
	@Test
	public void testConnect() throws Exception {
		Class.forName(DRIVER);
		try (Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println("JDBC TEST : "+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testMemberAdd() throws Exception {
		UserVO UV = new UserVO();
		UV.setUserId("SpringTest");
		UV.setUserPw("1qa2ws");
		UV.setUserName("KJO");
		UV.setUserEmail("test@gmail.com");
		UV.setPwSearchAnswer("질문응답");
		
		System.out.println("complete Add");
		
		UM.MemberAdd(UV);
	}
}
