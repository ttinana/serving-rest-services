/**
 * Base entity superclass.
 */
package com.tijana.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * @author ttinana
 *
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Column(name = "`id`", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="entity_id_seq")
    @SequenceGenerator(name="entity_id_seq", sequenceName="entity_id_seq", allocationSize=1)
    private Long id;

}
