package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
@ExtendWith (MockitoExtension.class)
class ItemBusinessServiceTest {
	@Mock
	private ItemRepository repository;
	@InjectMocks
	private ItemBusinessService business;
	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService business = new ItemBusinessService();
		com.in28minutes.unittesting.unittesting.model.Item item = business.retreiveHardcodedItem();	
		assertNotNull(item);
		assertEquals(new com.in28minutes.unittesting.unittesting.model.Item(1, "Ball", 10, 100), item);
}
	
	@Test
	void testSaveItem(){
		com.in28minutes.unittesting.unittesting.model.Item item = new com.in28minutes.unittesting.unittesting.model.Item(2, "Item2", 20, 20);
		when(repository.save(item)).thenReturn(item);
		business.saveItem( item);
		assertEquals("Item2", item.getName());
		assertNotNull(item.getId());
	}
	@Test
	void testRetrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new com.in28minutes.unittesting.unittesting.model.Item(2,"Item2", 2,20)));
		ItemBusinessService business = new ItemBusinessService();
		business.retrieveAllItems();
	}
	
	
	

}
