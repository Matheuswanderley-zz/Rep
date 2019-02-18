import { Injectable } from '@angular/core'
import { Http } from '@angular/http'
import { Observable } from 'rxjs/Rx'
import { Imovel_api } from '../app.api'
import { ErrorHandler } from '../app.errorhandler'
import { imoveis } from '../home/card/imovel.model'
import { Headers, RequestOptions, Response } from '@angular/http'
import { areacomum } from '../home/card/areacomum.model'
import { HttpHeaders } from '@angular/common/http'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

const httpOptions = {
  headers: new Headers({
    'Accept': 'application/json',
    'transactionId': '1',
    'version': '1'
    })
};
@Injectable()
export class CardService{

constructor(private http: Http){}


imoveis(): Observable<imoveis[]>{
  return this.http.get(`${Imovel_api}/imovel/`, httpOptions)
  .map(response => response.json())
  .catch(ErrorHandler.handleError)

}
areacomum(): Observable<areacomum>{
  return this.http.get(`${Imovel_api}/areaComum/`, httpOptions)
  .map(response => response.json())
  .catch(ErrorHandler.handleError)
}

}
