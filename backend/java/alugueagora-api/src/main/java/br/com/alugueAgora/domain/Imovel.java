package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IMOVEL database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="IMOVEL")
@NamedQueries({
    @NamedQuery(name = "Imovel.listAll", query = "FROM Imovel as im ORDER BY im.codigoImovel")
    , @NamedQuery(name = "Imovel.findBy", query = "FROM Imovel as im where 1=1"
			+ "and (:imovelTipo is null or im.imovelTipo = :imovelTipo) "
			+ "and (:imovelNegocio is null or im.imovelNegocio = :imovelNegocio) "
			+ "and (:quantidadeBanheiros is null or im.quantidadeBanheiros = :quantidadeBanheiros) "
			+ "and (:quantidadeDormitorios is null or im.quantidadeDormitorios = :quantidadeDormitorios) "
			+ "and (:quantidadeSuites is null or im.quantidadeSuites = :quantidadeSuites) "
			+ "and (:quantidadeGaragem is null or im.quantidadeGaragem = :quantidadeGaragem) ORDER BY im.codigoImovel")
    })
public class Imovel implements Serializable {

	private static final Long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="IMOVEL_SEQ", sequenceName="IMOVEL_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IMOVEL_SEQ")
	@Column(name="CODIGO_IMOVEL")
	private Long codigoImovel;

	@Column(name="ANUNCIO")
	private Long anuncio;
	@Column(name="AREA")
	private Long areaImovel;
	@Column(name="CELULAR")
	private Long celular;
	@Column(name="DATA_REGISTRO")
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;
	@Column(name="DESCRICAO_IMOVEL")
	private String descricaoImovel;
	@Column(name="TITULO_IMOVEL")
	private String tituloImovel;
	@Column(name="DESTAQUE")
	private Long anuncioDestaque;
	@Column(name="DISPONIBILIDADE")
	private Long disponibilidade;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ENVIO_PLACA")
	private Long envioPlaca;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IMOVEL_NEGOCIO")
	private ImovelNegocio imovelNegocio;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IMOVEL_PLACA")
	private ImovelPlaca imovelPlaca;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IMOVEL_TIPO")
	private ImovelTipo imovelTipo;
	
	@Column(name="OPORTUNIDADE")
	private Long oportunidade;
	@Column(name="PREFERIDO")
	private Long preferido;
	@Column(name="QUANTIDADE_BANHEIROS")
	private Long quantidadeBanheiros;
	@Column(name="QUANTIDADE_DORMITORIOS")
	private Long quantidadeDormitorios;
	@Column(name="QUANTIDADE_GARAGEM")
	private Long quantidadeGaragem;
	@Column(name="QUANTIDADE_SUITES")
	private Long quantidadeSuites;
	@Column(name="TELEFONE1")
	private Long telefone1;
	@Column(name="TELEFONE2")
	private Long telefone2;
	@Column(name="VALOR_CONDOMINIO")
	private Long valorCondominio;
	@Column(name="VALOR_IMOVEL")
	private Long valorImovel;
	@Column(name="VALOR_IPTU")
	private Long valorIptu;
	@Column(name="VALOR_PACOTE")
	private Long valorPacote;

	@OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
	private List<ImovelFoto> imovelFoto;
	@OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
	private List<ImovelAreaComum> imovelAreaComum;
	@OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
	private List<ImovelCaracteristica> imovelCaracteristica;
	@OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
	private List<ImovelEndereco> imovelEndereco;
	@OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
	private List<ImovelPagamento> imovelPagamento;
}