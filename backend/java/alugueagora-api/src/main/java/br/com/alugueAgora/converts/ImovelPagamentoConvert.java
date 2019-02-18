package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.dto.ImovelPagamentoDTO;

@Component
public class ImovelPagamentoConvert {

	public List<ImovelPagamento> convertDTOToEntity (List<ImovelPagamentoDTO> dto,Imovel imovel, String dominio){

		List<ImovelPagamento> pagamentos = new ArrayList<>();
		
		for(ImovelPagamentoDTO pagamento : dto) {
			if("UPDATE".equalsIgnoreCase(dominio)) {
				pagamentos.add(new ImovelPagamento(	pagamento.getCodigoPagamento(),
						pagamento.getDataPagamento(),
						pagamento.getStatusPagamento(),
						pagamento.getValorPagamento(),
						imovel));
			}else {
				pagamentos.add(new ImovelPagamento(	pagamento.getDataPagamento(),
						pagamento.getStatusPagamento(),
						pagamento.getValorPagamento(),
						imovel));
			}
		}
		return pagamentos;
	}

	public List<ImovelPagamentoDTO> convertEntityToDTO(List<ImovelPagamento> pagamentos) {
		List<ImovelPagamentoDTO> listaPagamentos = new ArrayList<>();
		
		for(ImovelPagamento pagamento : pagamentos) {
			listaPagamentos.add(new ImovelPagamentoDTO(	pagamento.getCodigopagamento(),
														pagamento.getDatapagamento(),
														pagamento.getStatuspagamento(),
														pagamento.getValorpagamento(),
														pagamento.getImovel().getCodigoImovel()));
		}
		return listaPagamentos;
	}

}
