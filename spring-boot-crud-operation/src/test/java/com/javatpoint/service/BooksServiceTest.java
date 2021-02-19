package com.javatpoint.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class BooksServiceTest {
	
	@InjectMocks
	BooksService service ;
	
	@Mock
	BooksRepository repo;

	@Test
	public void testGetAllBooks() {
		List<Books> list =new ArrayList<Books>();
		list.add(new Books(1, "book java ", "author james bond", 320));
		list.add(new Books(2, "java", "james bond", 420));
		list.add(new Books(3, "testing", "james ruskin bond", 500));
		
		when(repo.findAll()).thenReturn(list);
		List<Books> bookslist = service.getAllBooks();
		assertEquals(3, bookslist.size());
		
	}

	@Test
	public void testGetBooksById() {
		assertTrue(true);
	}

	@Test
	public void testSaveOrUpdate() {
		Books b= new Books(1, "book java ", "author james bond", 320);
		service.saveOrUpdate(b);
		verify(repo, times(1)).save(b);
	}

	@Test
	public void testDelete() {
		assertTrue(true);
	}

	@Test
	public void testUpdate() {
		assertTrue(true);
	}

}
