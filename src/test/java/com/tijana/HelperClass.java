/**
 * 
 */
package com.tijana;

import java.util.ArrayList;
import java.util.Collection;

import com.tijana.model.Notification;
import com.tijana.model.builders.NotificationBuilder;

/**
 * @author ttinana
 *
 */
public class HelperClass {

	public static Collection<Notification> findAll() {
		Notification notification = Notification.builder().id(1L).build();

		Collection<Notification> notifications = new ArrayList<>();
		notifications.add(notification);
		return notifications;
	}

	public static Notification findOne() {
		Notification notification = Notification.builder().id(1L).build();
		notification.setId(1L);
		return notification;
	}

}
