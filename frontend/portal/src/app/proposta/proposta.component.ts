import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-proposta',
  templateUrl: './proposta.component.html'
})
export class PropostaComponent implements OnInit {

  show: boolean;
  passo2 = false;


  constructor() { }

  ngOnInit() {
  }

  Next(){
    this.show = true;
    this.passo2 = !this.passo2;
  }

  Prev(){
    this.show = false;
    this.passo2 = this.passo2;

  }

}
