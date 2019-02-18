import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  title = 'Compre, alugue seu imóvel';
  menu: boolean;

  constructor() { }

  ngOnInit() {
    this.menu = false;
  }

  clicked(event) {
    $(".menu.sub").toggleClass("active");
  }

}
