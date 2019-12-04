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
  confirmDelete(moto) {
    swal({
      title: "Confirmación",
      text: "¿Esta seguro que desea eliminar el registro?",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
      cancelButtonText: this.translate.instant("buttons.cancel")
    }).then(result => {
      if (result.value) {
        this.eliminarMoto(moto);
      }
    });
  }
  eliminarMoto(moto){
    let url = `/api/service/moto/eliminar/${moto}`;
    this.service.queryDeleteRegular(url).subscribe(
      response => {
        let result = response;
        if (result) {
          this.getMotos();
          swal({
            title: "Exito",
            text: "Registro eliminado con exito",
            type: "success",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          }).then(result => {
            return false;
          });
        } else {
          swal({
            title: "Ups",
            text: "se ha presentado un error",
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),
          }).then(result => {
            return false;
          });
        }
      },
      err => {
        console.log(err);
      }
    );
  }
}
