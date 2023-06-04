<template>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="./index.html" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="@/assets/images/logos/dark-logo.svg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo</label>
                    <input v-model="correo" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Constraseña</label>
                    <input v-model="password" type="password" class="form-control" id="exampleInputPassword1">
                  </div>
                  <div class="d-flex align-items-center justify-content-between mb-4">
                    <div class="form-check">
                      <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" checked>
                      <label class="form-check-label text-dark" for="flexCheckChecked">
                        Recordar cuenta
                      </label>
                    </div>
                    <a class="text-primary fw-bold" href="#">&#191;Olvidaste tu contraseña&#63;</a>
                  </div>
                  <button @click="singIn" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Iniciar sesion</button>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">&#191;Aun no estas registrado&#63;</p>
                    <a class="text-primary fw-bold ms-2" :href="`${BASE_URL}registrarse`">Crear cuenta</a>
                  </div>
              </div>
              <div v-show="alerta_campos" class="alert alert-warning" role="alert">
                Complete los campos
              </div>
              <div v-show="alerta_credenciales" class="alert alert-danger" role="alert">
                Credenciales invalidas
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CryptoJS from 'crypto-js';
var axios = require('axios');

export default {
  inject: ['BASE_URL_AXIOS','BASE_URL'],
  data() {
    return {
      datosPersona: [],
      correo: "",
      password: "",
      alerta_credenciales: false,
      alerta_campos: false
    }
  },
  mounted() {

  },
  methods: {
    async singIn(){
      if(this.correo == "" || this.password == ""){
        this.alerta_credenciales = false;
        this.alerta_campos = true;

      }else{
        const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS +'singIn/'+this.correo+'/'+CryptoJS.MD5(this.password).toString());
        this.datosPersona = responseTipoDocumento.data;

        if(this.datosPersona != ""){
          this.alerta_credenciales = false;
          this.alerta_campos = false;
          localStorage.setItem('id', this.datosPersona[0].id);
          localStorage.setItem('id_perfil', this.datosPersona[0].idPerfil);
          localStorage.setItem('nombres', this.datosPersona[0].nombres);
          localStorage.setItem('apellido_paterno', this.datosPersona[0].apellidoPaterno);
          localStorage.setItem('apellido_materno', this.datosPersona[0].apellidoMaterno);
          window.location.href = "/home";

        } else {
          this.alerta_campos = false;
          this.alerta_credenciales = true;

        }
      }
    }
  }
};
</script>