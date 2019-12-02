import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { RestService } from 'src/app/core/services/rest.service';
import { Reserva } from 'src/app/shared/reserva';

@Component({
  selector: 'app-listar-reserva',
  templateUrl: './listar-reserva.component.html',
  styleUrls: ['./listar-reserva.component.scss']
})
export class ListarReservaComponent implements OnInit {

  public listaReserva : Reserva []=[];
  public pagina: number = 1;
  public cantidadPagina: number  = 5;
  public tamanio : number = this.listaReserva.length;
  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService
  ) { }

  ngOnInit() {
    this.getReservas();
  }

  getReservas(){
    let url = `/api/service/reserva/listar`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.listaReserva = result;
        } else {
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    );
  }

}
