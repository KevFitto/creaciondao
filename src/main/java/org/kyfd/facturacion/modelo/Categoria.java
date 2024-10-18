package org.kyfd.facturacion.modelo;


import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;
@Entity
@Getter @Setter
public class Categoria {
	
	
	@Id
	@Hidden
	@GeneratedValue(generator="System-uuid")
	@GenericGenerator(name = "System-uuid", strategy = "uuid")
	@Column(length = 32)
	String oid;
	
	@Column(length = 50)
	String descripcion;
	
}