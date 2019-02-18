package br.com.alugueAgora.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 * The persistent class for the ACESSO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="ACESSO")
public class Acesso implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACESSO_SEQ", sequenceName="ACESSO_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ACESSO_SEQ")
	@Column(name="CODIGO_ACESSO")
	private Long codigoAcesso;
	
	@Column(name="TIPO_ACESSO") @NonNull
	private String tipoAcesso;
}