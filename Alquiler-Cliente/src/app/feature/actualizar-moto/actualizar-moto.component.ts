import { Component, OnInit } from '@angular/core';
import { TranslateService } from "@ngx-translate/core";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { RestService } from 'src/app/core/services/rest.service';
@Component({
  selector: 'app-actualizar-moto',
  templateUrl: './actualizar-moto.component.html',
  styleUrls: ['./actualizar-moto.component.scss']
})
export class ActualizarMotoComponent implements OnInit {
  public editable : boolean = false;
  public placa : String = null;
  public marca : String = null;
  public modelo : number = null;
  public referencia : String = null;
  public cilindrada : number = null;
  public precioAlquiler : number = null;
  public myForm : FormGroup;
  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.placa = this.route.snapshot.queryParams["placa"];
    this.marca = this.route.snapshot.queryParams["marca"];
    this.modelo = this.route.snapshot.queryParams["modelo"];
    this.referencia = this.route.snapshot.queryParams["referencia"];
    this.cilindrada = this.route.snapshot.queryParams["cilindrada"];
    this.precioAlquiler = this.route.snapshot.queryParams["precioAlquiler"];

    this.myForm = new FormGroup({
      placa : new FormControl("placa", [Validators.required]),
      marca : new FormControl("marca",[Validators.required]),
      modelo : new FormControl("modelo",[Validators.required]),
      referencia : new FormControl("referencia", [Validators.required]),
      cilindrada : new FormControl("cilindrada",[Validators.required]),
      precioAlquiler : new FormControl("precioAlquiler ",[Validators.required])
    });

    this.myForm.controls["placa"].setValue("");
    this.myForm.controls["marca"].setValue("");
    this.myForm.controls["modelo"].setValue("");
    this.myForm.controls["referencia"].setValue("");
    this.myForm.controls["cilindrada"].setValue("");
    this.myForm.controls["precioAlquiler"].setValue("");
    
  }
  store(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }
    const datosMoto = {
      placa: controls["placa"].value,
      marca: controls["marca"].value,
      modelo: controls["modelo"].value,
      referencia: controls["referencia"].value,
      cilindrada: controls["cilindrada"].value,
      precioAlquiler: controls["precioAlquiler"].value,
    };

    let service = `api/service/moto/actualizar`;

    let data = {
      "placa": datosMoto.placa,
      "marca": datosMoto.marca,
      "modelo": datosMoto.modelo,
      "referencia": datosMoto.referencia,
      "cilindrada": datosMoto.cilindrada,
      "precioAlquiler": datosMoto.precioAlquiler
    }

    let body = JSON.stringify(data);
    this.service.queryPost(service, body).subscribe(data => {
      let result = data;
      console.log(result);
      if (result) {
        swal({
          title: "Campos correctos",
          text: "Moto actualizada con exito",
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
