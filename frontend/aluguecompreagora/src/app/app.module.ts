import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CardService } from '../app/home/card.service'
import { HttpModule } from '@angular/http'
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './home/header/header.component';
import { BannerComponent } from './home/banner/banner.component';
import { CardComponent } from './home/card/card.component';
import { BarraBuscaComponent } from './home/barra-busca/barra-busca.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    BannerComponent,
    CardComponent,
    BarraBuscaComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [ CardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
