package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The persistent class for the LOGIN database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="LOGIN")
public class Login implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LOGIN_SEQ", sequenceName = "LOGIN_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LOGIN_SEQ")
	@Column(name = "CODIGO_LOGIN")
	private Long codigoLogin;

	@Column(name = "EMAIL") @NonNull
	private String email;

	@Column(name = "PASSWORD") @NonNull
	private String password;

	//@Temporal(TemporalType.DATE)
	@Column(name = "DATA_LOGIN") @NonNull
	private String dataLogin;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="DATA_ACESSO") @NonNull
	private String dataAcesso;
	
	//@Column(name="STATUS") @NonNull
	//private char status;
	
	@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST) @NonNull
    @JoinTable(
    		name = "CLIENTE_LOGIN", 
    		joinColumns = @JoinColumn(name = "LOGIN_CODIGO_LOGIN",referencedColumnName="CODIGO_LOGIN"), 
    		inverseJoinColumns = @JoinColumn(name = "ACESSO_CODIGO_ACESSO",referencedColumnName="CODIGO_ACESSO"))
	private List<Acesso> acessos;

}