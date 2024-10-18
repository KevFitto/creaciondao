package org.kyfd.facturacion.modelo;

import javax.persistence.*;

import lombok.*;
@Embeddable
@Getter @Setter
public class Direccion {
	
	@Column(length=30)
	String viaPublica;
	
	@Column(length=5)
	int codigoPostal;
	
	@Column(length=25)
	String municipio;
	
	@Column(length=50)
	String departamento;
}