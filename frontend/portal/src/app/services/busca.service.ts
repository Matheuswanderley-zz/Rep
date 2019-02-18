import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {environment} from '../../environments/environment';

@Injectable()
export class BuscaService {

  private URL = environment.apiURL;
  private PATH = 'imovel';

  constructor(private _http: Http) { }

  BuscarImoveis(tipoi)
  {
    console.log(tipoi);
    return this._http.get('http://bold-forest-9198.getsandbox.com/api/cloud/imovel').map(
      (res) => res.json()
        .filter((imovel) => imovel.codigoImovel === 1398)
    );
  }



}
