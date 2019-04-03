package es.curso.registro.service;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import es.curso.registro.model.Role;
import es.curso.registro.model.User;
import es.curso.registro.repository.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	
    private static EmbeddedDatabase db;
    
    @Autowired
    UserServiceImpl userService;
    
	@Autowired
	private RoleRepository roleRepository;

      

	@BeforeClass
    public static void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.H2)
    		.addScript("create-db.sql")
    		.addScript("insert-data.sql")
    		.build();
    }

    @Test 
    @Transactional
    public void findByEmailCorrect () {
    	Role role = roleRepository.getRoleByName("ROLE_USER");
    	Assert.assertEquals(role.getName(), "ROLE_USER");
    }
    
    @Test 
    public void findByEmailIncorrectCorrect () {
    	
    	User user = userService.findByEmail("pedro@mail.com");
    	Assert.assertEquals(user.getEmail(), "pedro@mail.com");
    }


}
