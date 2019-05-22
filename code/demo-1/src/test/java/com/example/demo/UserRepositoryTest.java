package com.example.demo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repo.UserRepository;
import org.springframework.util.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
//	private User user;
//	
//	@Before
//	public void setUp() {
//		user= new  User(2,"ioana@yahoo.com","ioana","Bostan Ioana","Ale. Parcului");
//
//	}
//	
//	@Test
//	public void saveUserAndFindById() {
//		user= userRepository.save(user);
//		assertThat(userRepository.findById(user.getIduser())).isEqualTo((user));
//
//	}
//	@Test
//	public void findAllUsers() {
//
//		//User firstUser = new User(2,"ioana@yahoo.com","ioana","Bostan Ioana","Ale. Parcului");
//		List <User> list=userRepository.findAll();
//		System.out.println(list);
//		assertThat(list.size()).isEqualTo(1);
//	}
	@SuppressWarnings("deprecation")
	@Test
	public void findAllTeachers_notEmpty() {
		
		List<User> teacherList = userRepository.findAll();
		
		Assert.notEmpty(teacherList);
	}
}
