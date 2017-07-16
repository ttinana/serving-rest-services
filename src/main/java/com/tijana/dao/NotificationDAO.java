/**
 * 
 */
package com.tijana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tijana.model.Notification;

/**
 * @author ttinana
 *
 */
@Repository
//public interface NotificationDAO extends JpaRepository<Notification, Long> {
public interface NotificationDAO<T extends Notification> extends CrudRepository<T, Long> {
}

