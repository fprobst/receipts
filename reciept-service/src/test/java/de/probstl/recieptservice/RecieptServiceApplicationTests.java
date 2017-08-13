package de.probstl.recieptservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.probstl.recieptservice.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecieptServiceApplicationTests {

	@Autowired
	private AccountRepository m_AccountRepository;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(m_AccountRepository);
		m_AccountRepository.findAll();
	}

}
