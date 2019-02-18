import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-propostas',
  templateUrl: './propostas.component.html'
})
export class PropostasComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $("app-banner").hide();
    $("section.container.anuncios").css("margin-top", "110px")
  }

}
