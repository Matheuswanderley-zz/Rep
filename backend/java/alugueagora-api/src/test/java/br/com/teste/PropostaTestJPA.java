package br.com.teste;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alugueAgora.domain.Proposta;
import br.com.alugueAgora.services.PropostaService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class PropostaTestJPA {

	@Autowired
	private PropostaService service;
	
	@Test
	public void save() {
		System.out.println("TESTE BOOTSTRAP");

		Proposta entity = new Proposta();
		
		entity.setBairro("bairro");
		entity.setCidade("cidade");
//		entity.setImovelPermuta(null);
//		entity.setImovelTipo(null);
		entity.setObservacao("observacao");
		entity.setQuantidadeBanheiros(100L);
		entity.setQuantidadeDormitorios(100L);
		entity.setQuantidadeGaragem(100L);
		entity.setQuantidadeSuites(100L);
		entity.setValorProposta(9999L);
		
		service.save(entity);
	}

}
