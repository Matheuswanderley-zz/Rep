import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {environment} from '../../environments/environment';


@Injectable()
export class FiltersService {

  private URL = environment.apiURL;
  private PATH = 'imovel';

  constructor(private _http: Http) { }

  // ListImoveis()
  // {
  //
  //   return this._http.get(this.URL + this.PATH).map(
  //     (res) => res.json()
  //   );
  // }


  BuscarImoveis(values)
  {
    console.log(values);
    return this._http.get(this.URL + this.PATH).map(
      (res) => res.json()
        .filter((tipo) => tipo.imovelEnderecos === values.tipo)
    );
  }


}
