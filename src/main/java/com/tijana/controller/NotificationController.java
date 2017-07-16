/**
 * 
 */
package com.tijana.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tijana.model.Notification;
import com.tijana.service.NotificationService;
/**
 * @author ttinana
 *
 */
@RestController
public class NotificationController {
	@Autowired
	NotificationService notificationService;
	
	@RequestMapping(value = "/api/notifications", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Notification>> getNotifications() {
	Collection<Notification> notifications = notificationService.findAll();
	
	return new ResponseEntity<Collection<Notification>>(notifications, HttpStatus.OK);
	}

	@RequestMapping(value="/api/notifications/{id}", 
				method = RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notification> getNotification(@PathVariable("id") Long id){
		Notification notification = notificationService.findOne(id);
	
	 if (notification == null) {
	        return new ResponseEntity<Notification>(HttpStatus.NOT_FOUND);
	    }
	
	return new ResponseEntity<Notification>(notification, HttpStatus.OK);		
	}

	@RequestMapping(value="/api/notifications", 
		method = RequestMethod.POST,
		consumes=MediaType.APPLICATION_JSON_VALUE,
		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notification> saveNotification(@RequestBody Notification notification){
	
		Notification savedNotification = notificationService.save(notification);
	
	return new ResponseEntity<Notification>(savedNotification, HttpStatus.CREATED);		
	}

	@RequestMapping(
	        value = "/api/notifications/{id}",
	        method = RequestMethod.PUT,
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notification> updateNotification(@RequestBody Notification notification){
	 
		Notification updatedNotification = notificationService.update(notification);
	    if (updatedNotification == null) {
	        return new ResponseEntity<Notification>(
	                HttpStatus.NOT_MODIFIED);
	    }		 
	 return new ResponseEntity<Notification>(updatedNotification, HttpStatus.OK);			 
	}

	@RequestMapping(
	        value = "/api/notifications/{id}",
	        method = RequestMethod.DELETE,
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notification> deleteNotification(@PathVariable("id") Long id/*,
	        @RequestBody Notification notification*/) {
	
		notificationService.delete(id);
	
	    return new ResponseEntity<Notification>(HttpStatus.NO_CONTENT);
	}

}
