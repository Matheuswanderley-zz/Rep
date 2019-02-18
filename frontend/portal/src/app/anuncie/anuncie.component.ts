import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs/Subscription';
import {CadastroService} from '../services/cadastro.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-anuncie',
  templateUrl: './anuncie.component.html'
})
export class AnuncieComponent implements OnInit {

  insc: Subscription;
  getData: string;
  show: boolean;
  tipoAnuncio: string;
  aluguel_total: number;
  valorImovel = 0;
  valorCondominio = 0;
  valorIptu = 0;


  constructor(private Registrar: CadastroService) { }

  ngOnInit() {
    this.tipoAnuncio = 'vender';
  }

  Next(){
    this.show = true;
    document.getElementById('passo1_bullet').classList.remove('active');
    document.getElementById('passo2_bullet').classList.add('active');
    console.log(this.show);
  }

  Prev(){
    this.show = false;
  }


  getSum():number{
    let sum = 0;
    sum = Number(this.valorImovel) + Number(this.valorCondominio) + Number(this.valorIptu);
    return sum;
  }




  Cadastrar(dados: NgForm){
    console.log(dados);
    // $('#modal-retorno').modal('open');
    alert('Imóvel cadastrado com sucesso!');
    this.insc = this.Registrar.CadastrarImovel(dados)
      .subscribe(
        data => this.getData = JSON.stringify(data),
        error => console.log(error)
      )
  }

}
