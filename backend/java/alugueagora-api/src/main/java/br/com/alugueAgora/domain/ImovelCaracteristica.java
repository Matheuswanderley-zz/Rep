package br.com.alugueAgora.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 


/**
 * The persistent class for the IMOVEL_CARACTERISTICAS database table.
 * 
 */
@Entity
@Getter @Setter
@RequiredArgsConstructor 
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="IMOVEL_CARACTERISTICAS")
public class ImovelCaracteristica implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMOVEL_CARACTERISTICAS_SEQ", sequenceName="IMOVEL_CARACTERISTICAS_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IMOVEL_CARACTERISTICAS_SEQ")
	@Column(name="CODIGO_IMOVEL_CARAC")
	private Long codigoimovelcaracteristicas;
	@NonNull @Column(name="VALOR")
	private Long valor;
	@NonNull @Column(name="CARAC_CODIGO_CARAC")
	private Long caracteristica;
	@ManyToOne(optional = false) @NonNull
	@JoinColumn(name="CODIGO_IMOVEL")
	private Imovel imovel;
}