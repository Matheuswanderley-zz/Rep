import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';
import {ImoveisService} from '../services/imoveis.service';
import {BuscaService} from '../services/busca.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html'
})

// export class SearchComponent implements OnInit {
//
//   title1 = 'Imóveis perto de você';
//   list = [];
//   insc: Subscription;
//
//
//   constructor(
//     private _list: ImoveisService
//   ) { }
//
//   ngOnInit() {
//     this.insc = this._list.ListImoveis()
//       .subscribe(
//         (data) => this.list = data,
//         (err) => console.log(err)
//       );
//
//
//
//   }
//
//   ngOnDestroy()
//   {
//     this.insc.unsubscribe();
//   }
//
// }


export class SearchComponent implements OnInit {

  sub: Subscription;
  dormitory: number;
  list: Object;
  tipo: string;
  onde: string;
  para: string;
  orderObj: object;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _list: ImoveisService,
    private _busca: BuscaService
  ) {}

  ngOnInit() {

    /*Pega parametros URL*/
  //   this.sub = this.route.params.subscribe( params =>
  //     this.tipo = params['tipo']
  // );



    /* FUNCIONA */
    // this.route.queryParams
    //   .filter(params => params.tipo)
    //   .subscribe(params => {
    //     console.log(params); // {order: "popular"}
    //
    //     this.tipo = params.tipo;
    //     console.log(this.tipo); // popular
    //   });
    /* END FUNCIONA */


    this.route.queryParams
      .filter(params => params.tipo)
      .filter(params => params.onde)
      .filter(params => params.para)
      .subscribe(params => {
        console.log(params); // {order: "popular"}

        this.tipo = params.tipo;
        /*console.log(this.tipo);*/
      });



    /*Envia parametro para procurar dormitorios*/
    // this.sub = this._list.GetDormitory(this.dormitory)
    //   .subscribe(
    //     (data) => this.list = data
    //   ),
    //   (err) => console.log(err),
    //   () => console.log('Sucesso!');


    /*Envia parametro para procurar dormitorios*/
     this.sub = this._busca.BuscarImoveis(this.tipo)
       .subscribe(
         (data) => this.list = data
       ),
       (err) => console.log(err),
       () => console.log('Sucesso!');


  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
