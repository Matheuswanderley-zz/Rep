package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Login;
import br.com.alugueAgora.dto.AcessoDTO;
import br.com.alugueAgora.dto.LoginDTO;

@Component
public class LoginConvert {
		
		@Autowired
		AcessoConvert acessoConvert;

		List<AcessoDTO> acessoDto = new ArrayList<>();
		
		public List<Login> convertListDTOtoListEntity(List<LoginDTO> dto, String dominio) {

			List<Login> lista = new ArrayList<>();

			for (LoginDTO login : dto) {
				if ("UPDATE".equalsIgnoreCase(dominio)) {
					lista.add(new Login(login.getCodigoLogin(),
										login.getUsername(),
										login.getPassword(),
										login.getDataLogin(),
										login.getDataAcesso(),
										acessoConvert.convertDTOToEntity(acessoDto,dominio)));
				} else {
					lista.add(new Login(login.getUsername(),
										login.getPassword(),
										login.getDataLogin(),
										login.getDataAcesso(),
										acessoConvert.convertDTOToEntity(acessoDto,dominio)));
				}
			}
			return lista;
		}
		
		public Login convertDTOtoEntity(LoginDTO dto,String dominio) {
			if ("UPDATE".equalsIgnoreCase(dominio)) {
				Login login = new Login(dto.getCodigoLogin(),
						dto.getUsername(),
						dto.getPassword(),
						dto.getDataLogin(),
						dto.getDataAcesso(),
						acessoConvert.convertDTOToEntity(acessoDto,dominio));
				return login;				
			}else {
				Login login = new Login(
						dto.getUsername(),
						dto.getPassword(),
						dto.getDataLogin(),
						dto.getDataAcesso(),
						acessoConvert.convertDTOToEntity(acessoDto,dominio));
				return login;
			}

		}
		

		public List<LoginDTO> convertListEntityToListDTO(List<Login> lista) {

			List<LoginDTO> listaLogins = new ArrayList<>();

			for (Login login : lista) {
				listaLogins.add(new LoginDTO(login.getCodigoLogin(),
											login.getEmail(),
											login.getPassword(),
											login.getDataLogin(),
											login.getDataAcesso()
											//,acessoConvert.convertEntityToDTO(login.getAcessos())
								));
			}
			return listaLogins;
		}

		public LoginDTO convertEntityToDTO(Login login) {
			LoginDTO dto = new LoginDTO(login.getCodigoLogin(),
										login.getEmail(),login.getPassword(),
										login.getDataLogin(),
										login.getDataAcesso()			
										//,acessoConvert.convertEntityToDTO(login.getAcessos())
							);
			return dto;
		}
	}

