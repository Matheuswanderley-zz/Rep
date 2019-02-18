package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the CLIENTE_LOGIN database table.
 * 
 */
@Entity
@Data
@Table(name="CLIENTE_LOGIN")
public class ClienteLogin implements Serializable {
	private static final Long serialVersionUID = 1L;

	@EmbeddedId
	@SequenceGenerator(name="CLIENTE_LOGIN_SEQ", sequenceName="CLIENTE_LOGIN_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CLIENTE_LOGIN_SEQ")
	private ClienteLoginPK pk;
	
	@Column(name="CLIENTE_CODIGO_CLIENTE")
	private Cliente codigoCliente;

	
}