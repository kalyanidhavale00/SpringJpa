package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceTest {
	
	@Autowired
  CoderService coderservice;
	
	@MockBean
	CoderRepository repo;
	
	@Test
	void testAddCoder() {
      		Coder c1=new Coder();
		c1.setCid(2);
		c1.setCname("Madhura");
		c1.setTech("MYSQL");
		
	    Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(coderservice.addCoder(c1)).isEqualTo(c1);
	}

	/*@Test
	void testGetCoders() {
		fail("Not yet implemented");
	}*/

	@Test
	void testGetCoderById() throws Throwable {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setTech("JavaFS");
		
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(coderservice.getCoderById(1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCoderById() {
		Coder c1=new Coder();
		c1.setCid(1);
		//c1.setCname("kalyani");
		//c1.setTech("MySQL");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCid()));
		
	}

	@Test
	void testDeleteCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCid()));
	}

	@Test
	void testUpdateCoder() throws Throwable {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("mohan");
		c1.setTech("Java");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCname("Manju");
		c1.setTech("Python");
		
		assertThat(coderservice.updateCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testAddCoders() {
				Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Ravi");
		c1.setTech("Java");
		
		Coder c2=new Coder();
		c1.setCid(2);
		c1.setCname("Madhuri");
		c1.setTech("Spring");
		
		List<Coder> coderList=new ArrayList<>();
		coderList.add(c1);
		coderList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(coderList);
		
		assertThat(coderservice.getCoders()).isEqualTo(coderList);
	}

	/*@Test
	void testGetCoderByCname() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByTechSorted() {
		fail("Not yet implemented");
	}*/

}
