package com.e_buvette.ebuvette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.repository.ClientRepository;

@RunWith(Arquillian.class)

public class ClientTestArquillian {
	
	 @Deployment
     public static JavaArchive createDeployment() {
         return ShrinkWrap.create(JavaArchive.class)
         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
         .addClasses(Client.class, ClientRepository.class);
         //.addAsResource("META-INF/persistence.xml");
     }

	 @Inject
     Client client; 
	 
	 @Autowired
	 ClientRepository clientRepository;
     
     @SuppressWarnings("null")
	@Test
     public void testClient() {
         
         assertTrue(clientRepository .findAll().isEmpty());
         Client c1 = new Client();
         c1.setNom("Sabour");
         c1.setPrenom("Ilham");
         c1.setEmail("ilhamS@gmail.com");
         c1.setNumeroTelephone("04578964");
         c1.setPassword("123");
         Client c2 = new Client();
         c2.setNom("Wiam");
         c2.setPrenom("Ilhami");
         c2.setEmail("iS@gmail.com");
         c2.setNumeroTelephone("0457896447");
         c2.setPassword("123");
         clientRepository.save(c1);
         clientRepository.save(c2);
     
         assertEquals(2, clientRepository.findAll().size());
     
         clientRepository.delete(c1);
     
         assertEquals(1, clientRepository.findAll().size());
     }

}
