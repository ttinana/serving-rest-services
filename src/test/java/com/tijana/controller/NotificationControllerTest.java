package com.tijana.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tijana.HelperClass;
import com.tijana.model.Notification;
import com.tijana.service.NotificationService;

@RunWith(MockitoJUnitRunner.class)
public class NotificationControllerTest {

	@Mock
	private NotificationService notificationService;
	@InjectMocks
	private NotificationController notificationController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetNotifications() throws Exception {

		Collection<Notification> notifications = HelperClass.findAll();

		Mockito.when(notificationService.findAll()).thenReturn(notifications);

		ResponseEntity<Collection<Notification>> notificationsEntity = notificationController.getNotifications();

		Mockito.verify(notificationService, Mockito.times(1)).findAll();

		assertNotNull(notificationsEntity.getBody());
		assertEquals(notifications, notificationsEntity.getBody());
		assertEquals(HttpStatus.OK, notificationsEntity.getStatusCode());
	}

	@Test
	public final void testGetNotification() throws Exception {
		Notification notification = HelperClass.findOne();

		Mockito.when(notificationService.findOne(Matchers.anyLong())).thenReturn(notification);

		ResponseEntity<Notification> notificationEntity = notificationController.getNotification(1L);

		Mockito.verify(notificationService, Mockito.times(1)).findOne(1L);

		assertNotNull(notificationEntity);
		assertEquals(notification, notificationEntity.getBody());
		assertEquals(HttpStatus.OK, notificationEntity.getStatusCode());
	}

	@Test
	public final void testSaveNotification() throws Exception {

		Notification notification = HelperClass.findOne();

		Mockito.when(notificationService.save(Matchers.any(Notification.class))).thenReturn(notification);

		ResponseEntity<Notification> notificationEntity = notificationController.saveNotification(notification);

		Mockito.verify(notificationService, Mockito.times(1)).save(notification);

		assertNotNull(notificationEntity);
		assertEquals(HttpStatus.CREATED, notificationEntity.getStatusCode());

	}

	@Test
	public final void testUpdateNotification() throws Exception {
		Notification notification = HelperClass.findOne();

		Mockito.when(notificationService.update(Matchers.any(Notification.class))).thenReturn(notification);

		ResponseEntity<Notification> notificationEntity = notificationController.updateNotification(notification);

		Mockito.verify(notificationService, Mockito.times(1)).update(notification);

		assertNotNull(notificationEntity);
		assertEquals(HttpStatus.OK, notificationEntity.getStatusCode());

	}

	@Test
	public final void testDeleteNotification() throws Exception {

		ResponseEntity<Notification> notificationEntity = notificationController.deleteNotification(1L);

		Mockito.verify(notificationService, Mockito.times(1)).delete(Matchers.anyLong());

		assertNotNull(notificationEntity);
		assertEquals(HttpStatus.NO_CONTENT, notificationEntity.getStatusCode());

	}

}
