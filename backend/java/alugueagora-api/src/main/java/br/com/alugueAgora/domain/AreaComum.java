package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;


/**
 * The persistent class for the AREA_COMUM database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="AREA_COMUM")
public class AreaComum implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_COMUM_SEQ", sequenceName="AREA_COMUM_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="AREA_COMUM_SEQ")
	@Column(name="CODIGO_AREA_COMUM")
	private Long codigoAreaComum;

	@NonNull
	@Column(name="DESCRICAO_AREA_COMUM")
	private String descricaoAreaComum;

}