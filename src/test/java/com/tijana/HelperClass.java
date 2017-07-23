/**
 * 
 */
package com.tijana;

import java.util.ArrayList;
import java.util.Collection;

import com.tijana.model.Notification;

/**
 * @author ttinana
 *
 */
public class HelperClass {

		public static Collection<Notification> findAll() {
		Notification notification = new Notification();
		notification.setId(1L);

		Collection<Notification> notifications = new ArrayList<>();
		notifications.add(notification);
		return notifications;
		}
		
		public static Notification findOne() {
			Notification notification = new Notification();
			notification.setId(1L);
			return notification;
		}

}
