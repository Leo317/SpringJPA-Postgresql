package com.springjpa.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springjpa.dao.CustomerDaoImpl;
import com.springjpa.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {
	
	//text Double
	@Mock
	private CustomerDaoImpl toDoRepository;
	
	// 要被測試的，也就是SUT(Service層)
	@InjectMocks
	private CustomerServiceImpl toDoService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAll() {
		Customer toDo = new Customer(666, "unit", "test");

		when(toDoRepository.find(1L)).thenReturn(toDo);
		Customer result = toDoService.find(1);
		assertEquals(666, result.getPhone());
		assertEquals("unit", result.getFirstName());
		assertEquals("test", result.getLastName());
	}
	
	/*
	@Test
	public void testGetAllToDo(){
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1,"Todo Sample 1",true));
		toDoList.add(new ToDo(2,"Todo Sample 2",true));
		toDoList.add(new ToDo(3,"Todo Sample 3",false));
		when(toDoRepository.findAll()).thenReturn(toDoList);
		
		List<ToDo> result = toDoService.getAllToDo();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetToDoById(){
		ToDo toDo = new ToDo(1,"Todo Sample 1",true);
		when(toDoRepository.findOne(1L)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		assertEquals(1, result.getId());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void saveToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		when(toDoRepository.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		assertEquals(8, result.getId());
		assertEquals("Todo Sample 8", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void removeToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
	}
	*/
	

}

