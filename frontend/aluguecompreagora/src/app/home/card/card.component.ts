import { Component, OnInit } from '@angular/core';
import { imoveis } from '../card/imovel.model'
import { CardService } from '../card.service'
import { Observable } from 'rxjs/Observable'


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

imovel : imoveis[]
areacomum: any
jogador: Array<String>

  constructor(private cardservice: CardService) { }

  ngOnInit() {
    this.cardservice.imoveis()
    .subscribe(res =>  this.imovel = res['data']);
    this.cardservice.areacomum()
    .subscribe(res => this.areacomum = res['data'])

  }

}
