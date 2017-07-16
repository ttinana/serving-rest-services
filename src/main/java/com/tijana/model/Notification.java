/**
 *
 */
package com.tijana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ttinana
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@Table(name = "`notification`")
public class Notification extends BaseEntity{
	
	@Column(name = "`text`", length = 100, nullable = false, unique = true)
	private String text;

}
