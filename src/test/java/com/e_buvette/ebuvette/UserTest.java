package com.e_buvette.ebuvette;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.e_buvette.ebuvette.models.User;
import com.e_buvette.ebuvette.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.e_buvette.ebuvette.EbuvetteApplication.class)
public class UserTest {
 
	 @MockBean 
	 private UserRepository userRepository;
 
    @Test
    public void userManagement()
      throws Exception {
    	//assertTrue(userRepository .findAll().isEmpty());
        User user = new User(11,"ilham","123","CLIENT",true);
        userRepository.save(user);
        
        assertEquals(user.getUsername(),"ilham");
     
    }
}