import {SearchComponent} from '../search/search.component';
import {HomeComponent} from '../home/home.component';
import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from '../login/login.component';
import {AnuncieComponent} from '../anuncie/anuncie.component';
import {AnuncieComponent2} from '../anuncie/anuncie.component2';
import {environment} from '../../environments/environment';
import {PropostaComponent} from '../proposta/proposta.component';
import {AreausuarioComponent} from '../areausuario/areausuario.component';
import {AnunciosComponent} from '../areausuario/anuncios/anuncios.component';
import {AvaliacaoComponent} from '../areausuario/avaliacao/avaliacao.component';
import {PropostasComponent} from '../areausuario/propostas/propostas.component';
import {AssociadosComponent} from '../areausuario/avaliacao/associados/associados.component';
import {DetalhesComponent} from '../detalhes/detalhes.component';

const app_route: Routes = [
  {
    path: '',
    component: HomeComponent,
    data: {title: 'Home - Imobiliária'}
  },
  {
    path: 'imoveis',
    component: SearchComponent,
    data: {title: 'Imóveis' + environment.titleDefault}
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {title: 'Login' + environment.titleDefault}
  },
  {
    path: 'busca',
    component: SearchComponent,
    data: {title: 'Resultado da busca' + environment.titleDefault}
  },
  {
    path: 'anuncie',
    component: AnuncieComponent,
    data: {title: 'Anuncie' + environment.titleDefault}
  },
  {
    path: 'anuncie2',
    component: AnuncieComponent2,
    data: {title: 'Anuncie' + environment.titleDefault}
  },
  {
    path: 'proposta',
    component: PropostaComponent,
    data: {title: 'Proposta' + environment.titleDefault}
  },
  {
    path: 'detalhes',
    component: DetalhesComponent,
    data: {title: 'Detalhes' + environment.titleDefault}
  },
  {
    path: 'usuario',
    component: AreausuarioComponent,
    data: {title: 'Minha conta' + environment.titleDefault}
  },
  {
    path: 'usuario/anuncios',
    component: AnunciosComponent,
    data: {title: 'Meus anúncios' + environment.titleDefault}
  },
  {
    path: 'usuario/avaliacao',
    component: AvaliacaoComponent,
    data: {title: 'Minhas avaliações' + environment.titleDefault}
  },
  {
    path: 'usuario/avaliacao/associados',
    component: AssociadosComponent,
    data: {title: 'Minhas avaliações de associados' + environment.titleDefault}
  },
  {
    path: 'usuario/propostas',
    component: PropostasComponent,
    data: {title: 'Minhas propostas' + environment.titleDefault}
  }
]

export const Routings: ModuleWithProviders = RouterModule.forRoot(app_route);
