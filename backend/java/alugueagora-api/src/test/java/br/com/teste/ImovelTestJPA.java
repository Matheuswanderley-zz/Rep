package br.com.teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.domain.ImovelNegocio;
import br.com.alugueAgora.domain.ImovelPlaca;
import br.com.alugueAgora.domain.ImovelTipo;
import br.com.alugueAgora.services.ImovelService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class ImovelTestJPA {

	@Autowired
	private ImovelService imovelService;
	
	@Test
	public void cadastraImovel() {
		System.out.println("TESTE BOOTSTRAP");
		Imovel anuncio = new Imovel();
		
		ImovelPlaca imovelPlaca = new ImovelPlaca();
		imovelPlaca.setCodigoImovelplaca(null);
		imovelPlaca.setQrcode("teste");
		
		ImovelTipo imovelTipo = new ImovelTipo();
		imovelTipo.setCodigoImovelTipo(null);
		imovelTipo.setCodigoTipo(1L);
		
		ImovelNegocio imovelNegocio = new ImovelNegocio();
		imovelNegocio.setCodigoImovelNegocio(null);
		imovelNegocio.setCodigoNegocio(1L);
		
		ImovelFoto f1 = new ImovelFoto();
		f1.setCodigoImovelFoto(null);
		f1.setFoto("foto1");
		
		ImovelFoto f2 = new ImovelFoto();
		f2.setCodigoImovelFoto(null);
		f2.setFoto("foto2");
		
		List<ImovelFoto> fotos = new ArrayList<>();
		fotos.add(f1);
		fotos.add(f2);
		
		anuncio.setDescricaoImovel("teste anuncio 5");
		anuncio.setImovelTipo(imovelTipo);
		anuncio.setImovelPlaca(imovelPlaca);
		anuncio.setImovelNegocio(imovelNegocio);
		//anuncio.setFotos(fotos);
		
		imovelService.save(anuncio);
	}

}
