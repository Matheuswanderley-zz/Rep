package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IMOVEL_NEGOCIO database table.
 * 
 */
@Entity
@Getter @Setter
@RequiredArgsConstructor 
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="IMOVEL_NEGOCIO")
public class ImovelNegocio implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMOVEL_NEGOCIO_SEQ", sequenceName="IMOVEL_NEGOCIO_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IMOVEL_NEGOCIO_SEQ")
	@Column(name="CODIGO_IMOVEL_NEGOCIO")
	private Long codigoImovelNegocio;
	
	@NonNull @Column(name="CODIGO_NEGOCIO")
	private Long codigoNegocio;
	
}