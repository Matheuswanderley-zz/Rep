package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IMOVEL_PAGAMENTO database table.
 * 
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="IMOVEL_PAGAMENTO")
public class ImovelPagamento implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMOVEL_PAGAMENTO_SEQ", sequenceName="IMOVEL_PAGAMENTO_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IMOVEL_PAGAMENTO_SEQ")
	@Column(name="CODIGO_IMOVEL_PAGAMENTO")
	private Long codigopagamento;
	@NonNull @Column(name="DATA_PAGAMENTO")
	@Temporal(TemporalType.DATE)
	private Date datapagamento;
	@NonNull @Column(name="STATUS_PAGAMENTO")
	private Long statuspagamento;
	@NonNull @Column(name="VALOR_PAGAMENTO")
	private Long valorpagamento;
	@ManyToOne(optional = false) @NonNull
	@JoinColumn(name="CODIGO_IMOVEL")
	private Imovel imovel;

}