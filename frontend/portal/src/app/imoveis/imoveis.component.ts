import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs/Subscription';
import {ImoveisService} from '../services/imoveis.service';

@Component({
  selector: 'app-imoveis',
  templateUrl: './imoveis.component.html'
})
export class ImoveisComponent implements OnInit {

  title1 = 'Imóveis perto de você';
  list = [];
  insc: Subscription;


  constructor(
    private _list: ImoveisService
  ) { }

  ngOnInit() {
    this.insc = this._list.ListImoveis()
      .subscribe(
        (data) => this.list = data,
        (err) => console.log(err)
      );



  }

  ngOnDestroy()
  {
    this.insc.unsubscribe();
  }

}
