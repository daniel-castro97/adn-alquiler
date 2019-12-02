import { Component, OnInit } from '@angular/core';
import swal from "sweetalert2";
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { RestService } from 'src/app/core/services/rest.service';
import { Moto } from 'src/app/shared/moto';

@Component({
  selector: 'app-listar-motos',
  templateUrl: './listar-motos.component.html',
  styleUrls: ['./listar-motos.component.scss']
})
export class ListarMotosComponent implements OnInit {

  public listaMotos : Moto []=[];
  public pagina: number = 1;
  public cantidadPagina: number  = 5;
  public tamanio : number = this.listaMotos.length;

  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService
  ) { }

  ngOnInit() {
    this.getMotos();
  }

  private getMotos() {
    let url = `/api/service/moto/lista-motos`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.listaMotos = result;
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
