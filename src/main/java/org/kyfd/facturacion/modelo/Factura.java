package org.kyfd.facturacion.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.kyfd.facturacion.calculadores.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity
@Getter @Setter
public class Factura {

	@Id
	@GeneratedValue(generator = "System-uuid")
	@Hidden
	@GenericGenerator(name = "System-uuid", strategy = "uuid")
	@Column(length = 32)
	String oid;

	@Column(length = 6)
	@DefaultValueCalculator(value = CalculadorSiguienteNumeroParaAnyo.class,
	properties = @PropertyValue(name = "anyo"))
	int numero;

	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column(length = 4)
	int anyo;

	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	@Required
	LocalDate fecha;

	@Stereotype("MEMO")
	String observaciones;
	@ManyToOne
	(fetch=FetchType.LAZY,
	optional=false)
	Cliente cliente;

	@ElementCollection
	@ListProperties("producto.numero, producto.descripcion, cantidad")
	Collection<Detalle> detalles;

	@Stereotype("MEMO")
	String observaciones1;

}
