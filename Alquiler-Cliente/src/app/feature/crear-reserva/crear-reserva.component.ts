import { Component, OnInit } from '@angular/core';
import { TranslateService } from "@ngx-translate/core";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { RestService } from 'src/app/core/services/rest.service';

@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html',
  styleUrls: ['./crear-reserva.component.scss']
})
export class CrearReservaComponent implements OnInit {

  public editable: boolean = false;
  public fechaSolicitud: Date = null;
  public fechaInicio: Date = null;
  public fechaFin : Date = null;
  public moto : String = null;
  public cliente : number = null;
  public myForm : FormGroup;
  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.fechaSolicitud = this.route.snapshot.queryParams["fechaSolicitud"];
    this.fechaInicio = this.route.snapshot.queryParams["fechaInicio"];
    this.fechaFin = this.route.snapshot.queryParams["fechaFin"];
    this.moto = this.route.snapshot.queryParams["moto"];
    this.cliente = this.route.snapshot.queryParams["cliente"];

    this.myForm = new FormGroup ({
          fechaSolicitud : new FormControl("fechaSolicitud",[Validators.required]),
          fechaInicio : new FormControl("fechaInicio",[Validators.required]),
          fechaFin : new FormControl("fechaFin",[Validators.required]),
          moto : new FormControl("moto",[Validators.required]),
          cliente : new FormControl("cliente",[Validators.required])
    });

    this.myForm.controls["fechaSolicitud"].setValue("");
    this.myForm.controls["fechaInicio"].setValue("");
    this.myForm.controls["fechaFin"].setValue("");
    this.myForm.controls["moto"].setValue("");
    this.myForm.controls["cliente"].setValue("");
  }
  store(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }
    const datosReserva = {
      fechaSolicitud: controls["fechaSolicitud"].value,
      fechaInicio: controls["fechaInicio"].value,
      fechaFin: controls["fechaFin"].value,
      moto: controls["moto"].value,
      cliente: controls["cliente"].value,
    };

    let service = `api/service/reserva/crear`;

    let data = {
      "fechaSolicitud": datosReserva.fechaSolicitud,
      "fechaInicio": datosReserva.fechaInicio,
      "fechaFin": datosReserva.fechaFin,
      "moto": {
        "placa":datosReserva.moto,
      },
      "cliente":{
        "cedula":datosReserva.cliente
      }
    }

    let body = JSON.stringify(data);
    this.service.queryPost(service, body).subscribe(data => {
      let result = data;
      console.log(result);
      if (result) {
        swal({
          title: "Campos correctos",
          text: "Reserva registrada con exito",
          type: "success",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),
        }).then(result => {

          this.router.navigate(["/home"]);
        });
      } else {
        swal({
          title: "Ups",
          text: "Se ha presentado un error",
          type: "error",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),
        }).then(result => {
          return false;
        });
      }
    }, err => {
      console.log(err);
      swal({
        title: "Ups",
        text: "Algo salió mal, Por favor revisa los campos",
        type: "error",
        showCancelButton: false,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: this.translate.instant("buttons.ok"),
      }).then(result => {
        return false;
      });
    });

  }
  confirmVolver() {
    swal({
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_volver"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
      cancelButtonText: this.translate.instant("buttons.cancel")
    }).then(result => {
      if (result.value) {
        this.router.navigate(["/home"]);
      }
    });
  }
  public controlHasError(controlName: string, validationType: string): boolean {
    const control = this.myForm.controls[controlName];
    if (!control) {
      return false;
    }
    const result =
      control.hasError(validationType) && (control.dirty || control.touched);
    return result;
  }

}
