/**
 *
 */
package com.tijana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author ttinana
 *
 */
@Entity
@Table(name = "`notification`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Subscription.class)
public class Notification extends BaseEntity{
	@Getter
	@Column(name = "`text`", length = 100, nullable = false, unique = true)
	private String text;
	
	//@JsonManagedReference
	@Getter
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subscription_id", referencedColumnName = "id", nullable = false)
    private Subscription subscription;

}
