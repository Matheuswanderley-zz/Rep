import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs/Subscription';
import {ImoveisService} from '../services/imoveis.service';
import {FiltersService} from '../services/filters.service';
import {BuscaService} from '../services/busca.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html'
})
export class FiltersComponent implements OnInit {

  list = [];
  insc: Subscription;
  tipoAnuncio: string;

  constructor(
    private _list: FiltersService,
    private _busca: BuscaService,
    private router: Router
  ) { }

  ngOnInit() {
  }


  BuscarImovel(values: any){
    console.log(values);
    this.router.navigate(['/busca'], { queryParams: { tipo: values.tipo, onde: values.onde, para: this.tipoAnuncio } });
  }

  ngOnDestroy()
  {
    // this.insc.unsubscribe();
  }

}
