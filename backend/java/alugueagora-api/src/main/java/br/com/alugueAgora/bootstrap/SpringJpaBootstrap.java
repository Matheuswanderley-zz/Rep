package br.com.alugueAgora.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.domain.ImovelEndereco;
import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.domain.ImovelNegocio;
import br.com.alugueAgora.domain.ImovelPlaca;
import br.com.alugueAgora.domain.ImovelTipo;
import br.com.alugueAgora.domain.Tipo;
import br.com.alugueAgora.repositories.ImovelAreaComumRepository;
import br.com.alugueAgora.repositories.ImovelCaracteristicaRepository;
import br.com.alugueAgora.repositories.ImovelEnderecoRepository;
import br.com.alugueAgora.repositories.ImovelFotoRepository;
import br.com.alugueAgora.services.ImovelService;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ImovelService imovelService;
	private ImovelCaracteristicaRepository caracteristicasRepository;
	private ImovelEnderecoRepository enderecoRepository;
	private ImovelFotoRepository fotosRepository;
	private ImovelAreaComumRepository areaComumRepository;

	private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

	@Autowired
	public void setImovelRepository(ImovelService imovelService) {
		this.imovelService = imovelService;
	}

	@Autowired
	public void setAreaComumRepository(ImovelAreaComumRepository areaComumRepository) {
		this.areaComumRepository = areaComumRepository;
	}

	@Autowired
	public void setCaracteristicasRepository(ImovelCaracteristicaRepository caracteristicasRepository) {
		this.caracteristicasRepository = caracteristicasRepository;
	}

	@Autowired
	public void setEnderecoRepository(ImovelEnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Autowired
	public void setFotosRepository(ImovelFotoRepository fotosRepository) {
		this.fotosRepository = fotosRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//cadastraImovel();
	}

	private void cadastraEndereco() {
		ImovelEndereco endereco = new ImovelEndereco();
		endereco.setCodigoEndereco(2L);
		endereco.setPais("brasil");
		endereco.setRegiao("sudeste");
		endereco.setEstado("sao paulo");
		endereco.setCidade("santos");
		endereco.setBairro("porto");
		endereco.setTipologradouro("rua");
		endereco.setComplemento("casa");
		endereco.setLogradouro("rua jose");
		endereco.setNumero(1L);
		enderecoRepository.save(endereco);
	}

	private void cadastraImovel() {
		System.out.println("TESTE BOOTSTRAP");
		Imovel anuncio = new Imovel();

		anuncio.setDescricaoImovel("teste anuncio 1");
		anuncio.setTituloImovel("teste titulo imovel");
		anuncio.setImovelTipo(new ImovelTipo(1L));
		anuncio.setImovelPlaca(new ImovelPlaca("qrcode"));
		anuncio.setImovelNegocio(new ImovelNegocio(1L));

		Imovel imovelPersistido = imovelService.save(anuncio);

		ImovelFoto f1 = new ImovelFoto();
		f1.setCodigoImovelFoto(null);
		f1.setFoto("foto1");
		f1.setImovel(imovelPersistido);

		ImovelFoto f2 = new ImovelFoto();
		f2.setCodigoImovelFoto(null);
		f2.setFoto("foto2");
		f2.setImovel(imovelPersistido);

		List<ImovelFoto> fotos = new ArrayList<>();
		fotos.add(f1);
		fotos.add(f2);
		imovelPersistido.setImovelFoto(fotos);

		imovelService.update(imovelPersistido);

		imovelService.getById(imovelPersistido.getCodigoImovel());

		System.out.println("CODIGO DO IMOVEL CADASTRADO = " + imovelPersistido.getCodigoImovel());
		System.out.println("FIM DO TESTE!!");
	}

}