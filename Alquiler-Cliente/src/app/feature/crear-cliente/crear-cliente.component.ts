import { Component, OnInit } from '@angular/core';
import { TranslateService } from "@ngx-translate/core";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { RestService } from 'src/app/core/services/rest.service';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.scss']
})
export class CrearClienteComponent implements OnInit {
  public editing : boolean = false;
  public cedula : number = null;
  public nombre : String = null;
  public fechaNacimineto : Date = null;
  public telefono : number = null;
  public correo : String = null;
  public categoriaPase : String = null;
  public myForm: FormGroup;

  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.cedula = this.route.snapshot.queryParams["cedula"];
    this.nombre = this.route.snapshot.queryParams["nombre"];
    this.fechaNacimineto = this.route.snapshot.queryParams["fechaNacimineto"];
    this.telefono = this.route.snapshot.queryParams["telefono"];
    this.correo = this.route.snapshot.queryParams["correo"];
    this.categoriaPase = this.route.snapshot.queryParams["categoriaPase"];

    this.myForm = new FormGroup({
      cedula : new FormControl("cedula", [Validators.required]),
      nombre : new FormControl("nombre",[Validators.required]),
      fechaNacimineto : new FormControl("fechaNacimineto",[Validators.required]),
      telefono : new FormControl("telefono", [Validators.required]),
      correo : new FormControl("correo",[Validators.required]),
      categoriaPase : new FormControl("categoriaPase ",[Validators.required])
    });

    this.myForm.controls["cedula"].setValue("");
    this.myForm.controls["nombre"].setValue("");
    this.myForm.controls["fechaNacimineto"].setValue("");
    this.myForm.controls["telefono"].setValue("");
    this.myForm.controls["correo"].setValue("");
    this.myForm.controls["categoriaPase"].setValue("");
  }

  store(){
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const datosCliente = {
      cedula: controls["cedula"].value,
      nombre: controls["nombre"].value,
      fechaNacimineto: controls["fechaNacimineto"].value,
      telefono: controls["telefono"].value,
      correo: controls["correo"].value,
      categoriaPase: controls["categoriaPase"].value,
    };
    let service = `api/service/cliente/crear`;

    let data = {
      "cedula": datosCliente.cedula,
      "nombre": datosCliente.nombre,
      "fechaNacimineto": datosCliente.fechaNacimineto,
      "telefono": datosCliente.telefono,
      "correo": datosCliente.correo,
      "categoriaPase": datosCliente.categoriaPase
    }
    let body = JSON.stringify(data);
    this.service.queryPost(service, body).subscribe(data => {
      let result = data;
      console.log(result);
      if (result) {
        swal({
          title: "Campos Correctos",
          text: "Cliente registrado con exito",
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
