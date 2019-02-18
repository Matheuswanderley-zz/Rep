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
 * The persistent class for the TIPO database table.
 * 
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Tipo implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_SEQ", sequenceName="TIPO_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TIPO_SEQ")
	@Column(name="CODIGO_TIPO")
	private Long codigoTipo;

	@NonNull
	@Column(name="DESCRICAO_TIPO")
	private String descricaoTipo;

}