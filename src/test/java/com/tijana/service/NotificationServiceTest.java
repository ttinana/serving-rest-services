/**
 * 
 */
package com.tijana.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.tijana.HelperClass;
import com.tijana.dao.NotificationDAO;
import com.tijana.model.Notification;
import com.tijana.service.impl.NotificationServiceImpl;

/**
 * @author ttinana
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {	
	
	@Mock
	private NotificationDAO<Notification> notificationDAO;
	@InjectMocks
	private NotificationServiceImpl notificationService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.tijana.service.NotificationService#findAll()}.
	 */
	@Test
	public final void testFindAll() throws Exception {
		Collection<Notification> notifications = HelperClass.findAll();
		
		Mockito.when(notificationDAO.findAll()).thenReturn(notifications);
		
		Collection<Notification> actual = notificationService.findAll();
		
		Mockito.verify(notificationDAO, Mockito.times(1)).findAll();
		
		assertNotNull(actual);
		assertEquals(notifications, actual);
	}

	/**
	 * Test method for
	 * {@link com.tijana.service.NotificationService#findOne(java.lang.Long)}.
	 */
	@Test
	public final void testFindOne() throws Exception {
		Notification notification = HelperClass.findOne();
		
		Mockito.when(notificationDAO.findOne(Matchers.anyLong())).thenReturn(notification);
		
		Notification actual = notificationService.findOne(1L);
		
		Mockito.verify(notificationDAO, Mockito.times(1)).findOne(Matchers.anyLong());
		
		assertNotNull(actual);
		assertEquals(notification, actual);
	}

	/**
	 * Test method for
	 * {@link com.tijana.service.NotificationService#save(com.tijana.model.Notification)}.
	 */
	@Test
	public final void testSave() throws Exception {
		Notification notification = HelperClass.findOne();
		
		Mockito.when(notificationDAO.save(Matchers.any(Notification.class))).thenReturn(notification);
		
		Notification actual = notificationService.save(notification);
		
		Mockito.verify(notificationDAO, Mockito.times(1)).save(Matchers.any(Notification.class));
		
	}

	/**
	 * Test method for
	 * {@link com.tijana.service.NotificationService#update(com.tijana.model.Notification)}.
	 */
	@Test
	public final void testUpdate() throws Exception {
Notification notification = HelperClass.findOne();
		
		Mockito.when(notificationDAO.save(Matchers.any(Notification.class))).thenReturn(notification);
		
		Notification actual = notificationService.update(notification);
		
		Mockito.verify(notificationDAO, Mockito.times(1)).save(Matchers.any(Notification.class));
		
		assertNotNull(actual);
		assertEquals(notification, actual);
	}

	/**
	 * Test method for
	 * {@link com.tijana.service.NotificationService#delete(java.lang.Long)}.
	 */
	@Test
	public final void testDelete() throws Exception {
		
		notificationService.delete(Matchers.anyLong());
		Mockito.verify(notificationDAO, Mockito.times(1)).delete(Matchers.anyLong());
	}

}
