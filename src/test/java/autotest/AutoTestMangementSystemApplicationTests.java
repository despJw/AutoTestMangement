package autotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.crc.bean.User;
import com.crc.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoTestMangementSystemApplicationTests {
 @Autowired
 UserMapper userDao;
	@Test
	public void contextLoads() {
	  User resultUser1 = userDao.getUserById(1);
	  
	}

}
