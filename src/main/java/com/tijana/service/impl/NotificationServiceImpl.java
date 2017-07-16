/**
 * 
 */
package com.tijana.service.impl;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tijana.dao.NotificationDAO;
import com.tijana.model.Notification;
import com.tijana.service.NotificationService;

/**
 * @author ttinana
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired 
	private NotificationDAO<Notification> notificationDAO;

	@Override
	public Collection<Notification> findAll() {
		Iterable<Notification> notificationsI = notificationDAO.findAll();
		Collection<Notification> notifications = Lists.newArrayList(notificationsI);
		return notifications;
	}

	@Override
	public Notification findOne(Long id) {
		return (Notification) notificationDAO.findOne(id);
	}

	@Override
	public Notification save(Notification notification) {
		notificationDAO.save(notification);		
		return notification;
	}

	@Override
	public Notification update(Notification notification) {
		if(findOne(notification.getId()) !=null){
		notificationDAO.save(notification);
		}
		return notification;
	}

	@Override
	public void delete(Long id) {
		notificationDAO.delete(id);
		
	}

}
