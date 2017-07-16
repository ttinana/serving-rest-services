/**
 * 
 */
package com.tijana.service;

import java.util.Collection;

import com.tijana.model.Notification;

/**
 * @author ttinana
 *
 */
public interface NotificationService {

	Collection<Notification> findAll();

	Notification findOne(Long id);

	Notification save(Notification notification);

	Notification update(Notification notification);

	void delete(Long id);

}
