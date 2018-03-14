package com.springjpa.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import com.springjpa.exception.CustomerTransactionException;
import com.springjpa.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {
	
	//text Double
	@Mock
	private CustomerDaoImpl textDoubleDao;
	
	// 要被測試的，也就是SUT(Service層)
	@InjectMocks
	private CustomerServiceImpl toDoService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testInitData() {
		Customer toDo = new Customer(8, "Todo Sample 8", "aaa");
		toDoService.initData(toDo);
        verify(textDoubleDao, times(1)).initData(toDo);
	}
	
	@Test
	public void testCreat() {
		Customer toDo = new Customer(8, "Todo Sample 8", "aaa");
		toDoService.creat(toDo);
        verify(textDoubleDao, times(1)).creat(toDo);
	}
	
	@Test
	public void testFindId() {
		Customer toDo = new Customer(333, "unit", "test");
		when(textDoubleDao.find(1L)).thenReturn(toDo);
		
		Customer result = toDoService.find(1);
		
		assertEquals(0, result.getId());
		assertEquals(333, result.getPhone());
		assertEquals("unit", result.getFirstName());
		assertEquals("test", result.getLastName());
	}
	
	@Test
	public void testFindAll() {
		List<Customer> toDoList = new ArrayList<Customer>();
		toDoList.add(new Customer(1,"Todo Sample 1",""));
		toDoList.add(new Customer(2,"Todo Sample 2",""));
		toDoList.add(new Customer(3,"Todo Sample 3",""));
		when(textDoubleDao.findAll()).thenReturn(toDoList);
		
		List<Customer> result = toDoService.findAll();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testUpdate() {
		Customer toDo = new Customer(333, "unit", "test");

		when(textDoubleDao.find(1L)).thenReturn(toDo);
		Customer result = toDoService.find(1);
		
		result.setFirstName("KKK");
		toDoService.update(result);
		result = toDoService.find(1);
		
		assertThat(result.getId(), is(0L));
		assertThat(result.getPhone(), is(333L));
	    assertThat(result.getFirstName(), is("KKK"));
	    assertThat(result.getLastName(), is("test"));
	}
	
	@Test
	public void testDelete() {
		Customer toDo = new Customer(8, "Todo Sample 8", "aaa");
		toDoService.delete(toDo.getId());
        verify(textDoubleDao, times(1)).delete(toDo.getId());
	}
	
	@Test
	public void testGetAll() {
		when(textDoubleDao.getAll()).thenReturn(new Customer(666, "unit", "test").toString() + "<br>");
		String result = toDoService.getAll();
		
		assertThat(result, is(new Customer(666, "unit", "test").toString() + "<br>"));
	}
	
	/*
	@Test
	public void testGetAllToDo(){
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1,"Todo Sample 1",true));
		toDoList.add(new ToDo(2,"Todo Sample 2",true));
		toDoList.add(new ToDo(3,"Todo Sample 3",false));
		when(textDoubleDao.findAll()).thenReturn(toDoList);
		
		List<ToDo> result = toDoService.getAllToDo();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testGetToDoById(){
		ToDo toDo = new ToDo(1,"Todo Sample 1",true);
		when(textDoubleDao.findOne(1L)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		assertEquals(1, result.getId());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void saveToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		when(textDoubleDao.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		assertEquals(8, result.getId());
		assertEquals("Todo Sample 8", result.getText());
		assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void removeToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		toDoService.removeToDo(toDo);
        verify(textDoubleDao, times(1)).delete(toDo);
	}
	*/
	

}

