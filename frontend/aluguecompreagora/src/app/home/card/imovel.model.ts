export interface imoveis{
     codigoImovel: number
     anuncio: number
     anuncioDestaque: string
     areaImovel: number
     celular: number
     dataRegistro: string
     descricaoImovel: string
     tituloImovel: string
     disponibilidade: string
     email: string
     envioPlaca: string
     imovelAreaComum: imovelAreaComum[]
     imovelCaracteristicas: imovelCaracteristicas[]
     imovelEnderecos: imovelEnderecos[]
     imovelFotos: imovelFotos[]
     imovelNegocio: imovelNegocio
     imovelPagamentos: imovelPagamentos
     imovelPlaca: imovelPlaca
     ImovelTipo: imovelTipo
     oportunidade: string
     preferido: string
     quantidadeBanheiros: number
     quantidadeDormitorios: number
     quantidadeGaragem: number
     quantidadeSuites: number
     telefone1: number
     telefone2: number
     valorCondominio: number
     valorImovel: number
     valorIptu: number
     valorPacote: number
     codigoCliente: number
  }
export interface imovelNegocio{
  codigoImovelNegocio: number
  negocioCodigoNegocio: number
}
export interface imovelTipo{
  codigoImovelTipo: number
  codigoTipo: number
}
export interface imovelPlaca{
  codigoPlaca: number
  qrCode: string
}
export interface imovelAreaComum{
  codigoImovelAreaComum: number
  valor: number
  codigoAreaComum: number
  codigoImovel: number
}
export interface imovelCaracteristicas{
  codigoImovelCaracteristicas: number
  valor: number
  codigoCaracteristicas: number
  codigoImovel: number
}
export interface imovelEnderecos{
  codigoEndereco: number
  bairro: string
  cep: number
  tipoEndereco: string
  cidade: string
  complemento: string
  estado: string
  logradouro: string
  numero: number
  pais: string
  regiao: string
  tipoLogradouro: string
  codigoImovel: number
    }
export interface imovelFotos{
  codigoFoto: number
  foto: string
  codigoImovel: number
}
export interface imovelPagamentos{
  codigoPagamento: number
  dataPagamento: number
  statusPagamento: string
  valorPagamento: number
  codigoImovel: number
}
