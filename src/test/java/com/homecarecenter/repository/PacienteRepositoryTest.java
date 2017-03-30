/*package com.homecarecenter.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.homecarecenter.model.paciente.PacienteGHC;
import com.homecarecenter.repository.paciente.IPacienteGHCRepository;
import com.ilion.application.db.JpaConfigGHC;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfigGHC.class})
@TransactionConfiguration
public class PacienteRepositoryTest {
   
	@Autowired
    private IPacienteGHCRepository productRepository;
 
    @Test
    @Transactional("homeCareCenterEntityManager")
    public void whenCreatingUser_thenCreated() {
        
 
        assertNotNull(productRepository.findOne(1002));
    }
 
    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUsersWithSameEmail_thenRollback() {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("john@test.com");
        user1.setAge(20);
        user1 = userRepository.save(user1);
        assertNotNull(userRepository.findOne(user1.getId()));
 
        User user2 = new User();
        user2.setName("Tom");
        user2.setEmail("john@test.com");
        user2.setAge(10);
        try {
            user2 = userRepository.save(user2);
        } catch (DataIntegrityViolationException e) {
        }
 
        assertNull(userRepository.findOne(user2.getId()));
    }
 
    @Test
    @Transactional("productTransactionManager")
    public void whenCreatingProduct_thenCreated() {
        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        product = productRepository.save(product);
 
        assertNotNull(productRepository.findOne(product.getId()));
    }
}
*/