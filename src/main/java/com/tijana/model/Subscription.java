/**
 * 
 */
package com.tijana.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ttinana
 *
 */
@Entity
@Table(name = "`subscription`")
@NoArgsConstructor
public class Subscription extends BaseEntity {
	@Setter
	@Column(name = "`type`", length = 100, nullable = false, unique = false)
	private String type;

	@Column(name = "`text`", length = 100, nullable = false, unique = false)
	private String text;	
	
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "subscription", fetch = FetchType.EAGER)
	private Set<Notification> notificationList = new HashSet<Notification>();
	
	public Subscription(Long id){
		this.setId(id);
		this.setType("DEMO");
	}

	@XmlTransient
	public Set<Notification> getNotificationList() {
		return notificationList;
	}	

}
