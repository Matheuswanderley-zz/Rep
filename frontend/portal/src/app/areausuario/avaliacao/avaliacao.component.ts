import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-avaliacao',
  templateUrl: './avaliacao.component.html'
})
export class AvaliacaoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $("app-banner").hide();
    $("section.container.anuncios").css("margin-top", "110px")
  }

}
