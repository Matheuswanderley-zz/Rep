import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {environment} from '../../environments/environment';

@Injectable()
export class CadastroService {

  private URL = environment.apiURL;
  private PATH = 'imovel/';

  constructor(private _http: Http) {}

  CadastrarImovel(imovel){

    console.log(imovel);

    let imovelJson = {
      "anuncio": 0,
      "anuncioDestaque": 0,
      "areaImovel": 0,
      "celular": 0,
      "codigoCliente": 0,
      "codigoImovel": 0,
      "dataRegistro": "2018-01-07T20:32:38.589Z",
      "descricaoImovel": imovel.descricao,
      "disponibilidade": 0,
      "email": "string",
      "envioPlaca": 0,
      "imovelAreaComum": [
        {
          "codigoImovel": 0,
          "codigoareacomum": 0,
          "codigoimovelareacomum": 0,
          "valor": 0
        }
      ],
      "imovelCaracteristicas": [
        {
          "codigoImovel": 0,
          "codigocaracteristicas": 0,
          "codigoimovelcaracteristicas": 0,
          "valor": imovel.preco
        }
      ],
      "imovelEnderecos": [
        {
          "bairro": imovel.bairro,
          "cep": imovel.cep,
          "cidade": imovel.cidade,
          "codigoImovel": 0,
          "codigoendereco": 0,
          "complemento": imovel.complemento,
          "estado": imovel.estado,
          "logradouro": imovel.endereco,
          "numero": imovel.numero,
          "pais": "string",
          "regiao": "string",
          "tipoEndereco": 0,
          "tipologradouro": "string"
        }
      ],
      "imovelFotos": [
        {
          "codigoImovel": 0,
          "codigofoto": 0,
          "foto": "string"
        }
      ],
      "imovelNegocio": {
        "codigoImovelNegocio": 0,
        "negocioCodigoNegocio": 0
      },
      "imovelPagamentos": [
        {
          "codigoImovel": 0,
          "codigopagamento": 0,
          "datapagamento": "2018-01-07T20:32:38.589Z",
          "statuspagamento": 0,
          "valorpagamento": imovel.preco
        }
      ],
      "imovelPlaca": {
        "codigoplaca": 0,
        "qrcode": "string"
      },
      "imovelTipo": {
        "codigoImovelTipo": 0,
        "codigoTipo": 0
      },
      "oportunidade": 0,
      "preferido": 0,
      "quantidadeBanheiros": imovel.banheiros,
      "quantidadeDormitorios": imovel.quartos,
      "quantidadeGaragem": imovel.vagas,
      "telefone1": 0,
      "telefone2": 0,
      "tituloImovel": imovel.tituloImovel,
      "valorCondominio": imovel.valorCondominio,
      "valorImovel": imovel.valorImovel,
      "valorIptu": imovel.valorIptu,
      "valorPacote": 0
    };


    console.log(imovel);
    console.log(imovelJson);
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this._http.post(this.URL + this.PATH, imovelJson, {headers: headers})
      .map(
        res => res.json()
      );
  }

}
