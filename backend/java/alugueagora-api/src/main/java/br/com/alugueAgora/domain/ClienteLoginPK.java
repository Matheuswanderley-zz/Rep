package br.com.alugueAgora.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ClienteLoginPK implements Serializable{

	private static final long serialVersionUID = 6641410326914818L;
	@Column(name="ACESSO_CODIGO_ACESSO")
	private Acesso codigoAcesso;

	@Column(name="LOGIN_CODIGO_LOGIN")
	private Login codigoLogin;

}
