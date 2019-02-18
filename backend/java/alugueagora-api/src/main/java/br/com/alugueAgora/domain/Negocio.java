package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;


/**
 * The persistent class for the NEGOCIO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Negocio implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NEGOCIO_SEQ", sequenceName="NEGOCIO_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="NEGOCIO_SEQ")
	@Column(name="CODIGO_NEGOCIO")
	private Long codigoNegocio;

	@NonNull
	@Column(name="DESCRICAO_NEGOCIO")
	private String descricaoNegocio;

}