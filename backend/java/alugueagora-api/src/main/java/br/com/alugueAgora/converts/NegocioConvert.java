package br.com.alugueAgora.converts;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.stereotype.Component;

	import br.com.alugueAgora.domain.Negocio;
	import br.com.alugueAgora.dto.NegocioDTO;

	@Component
	public class NegocioConvert {

		public List<Negocio> convertDTOToEntity(List<NegocioDTO> dto, String dominio) {

			List<Negocio> NegocioConvert = new ArrayList<>();

			for (NegocioDTO negocio : dto) {
				if ("UPDATE".equalsIgnoreCase(dominio)) {
					NegocioConvert.add(new Negocio(negocio.getCodigoNegocio(), negocio.getDescricaoNegocio()));
				} else {
					NegocioConvert.add(new Negocio(negocio.getDescricaoNegocio()));
				}
			}
			return NegocioConvert;
		}

		public List<NegocioDTO> convertEntityToDTO(List<Negocio> lista) {

			List<NegocioDTO> listaNegocios = new ArrayList<>();

			for (Negocio negocio : lista) {
				listaNegocios.add(new NegocioDTO(negocio.getCodigoNegocio(), negocio.getDescricaoNegocio()));
			}
			return listaNegocios;
		}

		public NegocioDTO convertEntityToDTO(Negocio negocio) {
			NegocioDTO dto = new NegocioDTO(negocio.getCodigoNegocio(), negocio.getDescricaoNegocio());
			return dto;
		}
	}

