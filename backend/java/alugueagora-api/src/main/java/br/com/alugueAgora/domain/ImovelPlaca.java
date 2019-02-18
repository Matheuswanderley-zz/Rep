package br.com.alugueAgora.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the IMOVEL_PLACA database table.
 * 
 */
@Entity
@Getter @Setter
@RequiredArgsConstructor 
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="IMOVEL_PLACA")
public class ImovelPlaca implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMOVEL_PLACA_SEQ", sequenceName="IMOVEL_PLACA_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IMOVEL_PLACA_SEQ")
	@Column(name="CODIGO_IMOVEL_PLACA")
	private Long codigoImovelplaca;
	
	@NonNull @Column(name = "QRCODE")
	private String qrcode;

}