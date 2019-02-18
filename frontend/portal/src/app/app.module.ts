import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BoxComponent } from './box/box.component';
import { ImoveisComponent } from './imoveis/imoveis.component';
import { FooterComponent } from './footer/footer.component';
import { FiltersComponent } from './filters/filters.component';
import { BannerComponent } from './banner/banner.component';
import {ImoveisService} from './services/imoveis.service';
import {FiltersService} from './services/filters.service';
import { SearchComponent } from './search/search.component';
import {Routings} from './routers/app.routing';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AnuncieComponent } from './anuncie/anuncie.component';
import { AnuncieComponent2 } from './anuncie/anuncie.component2';
import {CadastroService} from './services/cadastro.service';
import {BuscaService} from './services/busca.service';
import { PropostaComponent } from './proposta/proposta.component';
import { AreausuarioComponent } from './areausuario/areausuario.component';
import { AnunciosComponent } from './areausuario/anuncios/anuncios.component';
import { AvaliacaoComponent } from './areausuario/avaliacao/avaliacao.component';
import { PropostasComponent } from './areausuario/propostas/propostas.component';
import { AssociadosComponent } from './areausuario/avaliacao/associados/associados.component';
import { DetalhesComponent } from './detalhes/detalhes.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BoxComponent,
    ImoveisComponent,
    FooterComponent,
    FiltersComponent,
    BannerComponent,
    SearchComponent,
    HomeComponent,
    LoginComponent,
    AnuncieComponent,
    AnuncieComponent2,
    PropostaComponent,
    AreausuarioComponent,
    AnunciosComponent,
    AvaliacaoComponent,
    PropostasComponent,
    AssociadosComponent,
    DetalhesComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routings
  ],
  providers: [ImoveisService, FiltersService, CadastroService, BuscaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
