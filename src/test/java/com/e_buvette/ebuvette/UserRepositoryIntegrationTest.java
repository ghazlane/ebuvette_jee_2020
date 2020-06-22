package com.e_buvette.ebuvette;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.e_buvette.ebuvette.models.User;
import com.e_buvette.ebuvette.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.e_buvette.ebuvette.EbuvetteApplication.class)
public class UserRepositoryIntegrationTest {
 
    @MockBean
    private UserRepository userRepository;
 
    @Test
    public void userManagement()
      throws Exception {
    	//assertTrue(userRepository .findAll().isEmpty());
        User user1 = new User(11,"ilham","123","CLIENT",true);
        User user2 = new User(15,"wiam","145","ADMIN",true);
        
        userRepository.save(user1);
        userRepository.save(user2);
        
        assertEquals(2, userRepository.findAll().size());
        
        userRepository.delete(user1);
    
        assertEquals(1, userRepository.findAll().size());
     
    }
}