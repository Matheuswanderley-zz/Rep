import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-anuncios',
  templateUrl: './anuncios.component.html'
})
export class AnunciosComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $("app-banner").hide();
    $("section.container.anuncios").css("margin-top", "110px")
  }

  reativaAnuncio() {
    // $('#modal-reativar').modal('close');
    // setTimeout(function(){
    //
    //   $('#modal-ok').modal('open');
    // }, 300);

  }

}
