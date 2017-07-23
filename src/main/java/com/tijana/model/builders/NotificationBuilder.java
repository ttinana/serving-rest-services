/**
 * 
 */
package com.tijana.model.builders;

import com.tijana.model.Notification;
import com.tijana.model.Subscription;

import lombok.Data;

/**
 * @author ttinana
 *
 */
@Data
public class NotificationBuilder {
	private Long id;
	private String text;
	private Subscription subscription;

	public NotificationBuilder id(Long id) {
		this.setId(id);
		return this;
	}

	public NotificationBuilder text(String text) {
		this.setText(text);
		return this;
	}

	public NotificationBuilder subscription(Subscription subscription) {
		this.setSubscription(subscription);
		return this;
	}

	public Notification build() {
		return new Notification(this);
	}

}
