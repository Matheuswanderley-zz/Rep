import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-associados',
  templateUrl: './associados.component.html'
})
export class AssociadosComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $("app-banner").hide();
    $("section.container.anuncios").css("margin-top", "110px")
  }

}
