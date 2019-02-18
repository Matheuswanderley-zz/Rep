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
 * The persistent class for the CARACTERISTICAS database table.
 * 
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CARACTERISTICAS")
public class Caracteristica implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARACTERISTICAS_SEQ", sequenceName="CARACTERISTICAS_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CARACTERISTICAS_SEQ")
	@Column(name="CODIGO_CARACTERISTICAS")
	private Long codigoCaracteristicas;

	@NonNull
	@Column(name="DESCRICAO_CARACTERISTICAS")
	private String descricaoCaracteristicas;

}