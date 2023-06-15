<template>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div v-show="alerta_ayuda" :class="modoAlerta === 2 ? 'alert-danger' : 'alert-success'" class="alert" role="alert">
              {{valorAlerta}}
            </div>
            <div class="card mb-0">
              <div class="card-body">
                <a href="#" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="@/assets/images/logos/dark-logo.svg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo</label>
                    <input v-model="correo" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Constraseña</label>
                    <input v-model="password" type="password" class="form-control" :maxlength="10" id="exampleInputPassword1">
                  </div>
                  <div class="d-flex align-items-center justify-content-between mb-4">
                    <div class="form-check">
                      <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" v-model="recordarCuenta" checked>
                      <label class="form-check-label text-dark" for="flexCheckChecked">
                        Recordar cuenta
                      </label>
                    </div>
                    <a class="text-primary fw-bold" href="#" @click="showCambioContraseña()">&#191;Olvidaste tu contraseña&#63;</a>
                  </div>
                  <template class="recapchat">
                    <vue-recaptcha ref="recaptcha" sitekey="6LdYA4kmAAAAAOBwAWvfJ50cxN8YbR33rc2I2FLQ" @verify="onRecaptchaVerify" />
                  </template>
                  <button @click="singIn" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Iniciar sesion</button>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">&#191;Aun no estas registrado&#63;</p>
                    <a class="text-primary fw-bold ms-2" :href="`${BASE_URL}registrarse`">Crear cuenta</a>
                  </div>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">&#191;Necesitas ayuda&#63;</p>
                    <a class="text-primary fw-bold ms-2" href="#" @click="showSolicitudAyuda()">Escribenos</a>
                  </div>
              </div>
              <div v-show="alerta_recapchat" class="alert alert-warning" role="alert">
                Complete el capchat
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
    <div v-show="cambioContraseña" class="modal" tabindex="-1" style="display: block;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Recuperación de Contraseña</h5>
            <button v-show="!spinner" type="button" @click="hideCambioContraseña()"></button>
          </div>
          <div class="modal-body">
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Correo Electrónico</label>
              <input type="text" v-model="chatCorreo" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="modal-footer">
              <button v-show="!spinner" type="button" @click="hideCambioContraseña()" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button v-show="!spinner" type="button" @click="enviarCorreo()" class="btn btn-primary">Enviar</button>
              <button v-show="spinner" type="button" class="ben btn-primary">
                <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                Enviando...
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-show="solicitudAyuda" class="modal" tabindex="-1" style="display: block;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Solicitud de Ayuda</h5>
            <button v-show="!spinner" type="button" @click="hideSolicitudAyuda()" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Nombre</label>
              <input type="text" v-model="chatNombre" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Numero</label>
              <input type="text" v-model="chatNumero" class="form-control" id="exampleInputPassword1">
            </div>
          </div>
          <div class="modal-footer">
            <button v-show="!spinner" type="button" @click="hideSolicitudAyuda()" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button v-show="!spinner" type="button" @click="enviarMensajeWPP()" class="btn btn-primary">Enviar</button>
            <button v-show="spinner" type="button" class="btn btn-primary">
              <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
              Enviando...
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CryptoJS from 'crypto-js';
var axios = require('axios');
import { VueRecaptcha } from 'vue-recaptcha';

export default {
  beforeRouteEnter(to, from, next) {
    // Verificar si la variable de sesión existe
    if (localStorage.getItem('id')) {
    // Redirigir a la página de inicio de sesión
    next('/home');
    } else {
    next();
    }
  },
  components: { 
    VueRecaptcha 
  },
  inject: ['BASE_URL_AXIOS','BASE_URL'],
  data() {
    return {
      datosPersona: [],
      correo: "",
      password: "",
      tokenRecaptcha: "",
      alerta_recapchat: false,
      alerta_credenciales: false,
      alerta_campos: false,
      recordarCuenta: false,
      solicitudAyuda: false,
      alerta_ayuda: false,
      chatCorreo: "",
      numeroAyuda: "",
      spinner: false,
      modoAlerta: "",
      alerta_error_ayuda: false
    }
  },
  mounted() {
    if(localStorage.getItem('hash') && localStorage.getItem('besh') ){
      this.recordarCuenta = true
      this.correo = localStorage.getItem('hash');
      this.password = "**-*-*-*-*";
    }
  },
  methods: {
    /*async enviarMensajeWPP() {
      const token = 'GA230611221411';
      const api = 'https://script.google.com/macros/s/AKfycbyoBhxuklU5D3LTguTcYAS85klwFINHxxd-FroauC4CmFVvS0ua/exec';

      const payload = {
        op: 'registermessage',
        token_qr: token,
        mensajes: [
          {
            numero: "51942263335",
            mensaje: `*Solicitud de Ayuda* \n\nUn cliente esta solicitando ayuda desde el formulario del login, los datos de contato son:\n\n*Numero:* ${this.numeroAyuda}\n*Correo:* ${this.correoAyuda}\n\n*Comuniquese con el cliente*`
          }
        ]
      };

      try {
        this.spinner = true;
        await axios.post(api, JSON.stringify(payload));
        this.hideSolicitudAyuda();
        this.spinner = false;
        this.alerta_ayuda = true;
        setTimeout(() => {
          this.alerta_ayuda = false;
        }, 1500);
      } catch (error) {
        this.alerta_error_ayuda = true;
        setTimeout(() => {
          this.alerta_error_ayuda = false;
        }, 1500);
      }
    },*/
    hideSolicitudAyuda() {
      this.solicitudAyuda = false;
    },
    showSolicitudAyuda() {
      this.solicitudAyuda = true;
    },

    showCambioContraseña() {
      this.cambioContraseña = true;
    },
    hideCambioContraseña() {
      this.cambioContraseña = false;
    },
    async enviarMensajeWPP() {
      this.spinner = true;
      //const request = await axios.get( this.BASE_URL_AXIOS + 'sendMessage/Solicitud de Ayuda/'+this.correoAyuda+'/'+this.numeroAyuda);
      const newChat = {
          nombre  : this.chatNombre,
          numero  : this.chatNumero,
      };
      const request = await axios({
          method: "POST",
          url: this.BASE_URL_AXIOS + "sendHelpMessage",
          data: newChat,
          headers: {
              "Content-Type": "application/json"
          }
      })

      this.hideSolicitudAyuda();
      this.spinner = false;
      var arreglo =  request.data.split("|");
      this.valorAlerta = arreglo[1];
      this.alerta_ayuda = true;

      if(arreglo[0] == "OK"){
        this.modoAlerta = 1;
      }else{
        this.modoAlerta = 2;
      }

      setTimeout(() => {
        this.alerta_ayuda = false;
      }, 1500);
      
    },
    async enviarCorreo(){
      this.spinner = true;

    },
    onRecaptchaVerify(response) {
      this.tokenRecaptcha = response;
    },
    async singIn(){
      var passwordMD5 = CryptoJS.MD5(this.password).toString()

      if(this.correo == "" || this.password == ""){
        this.alerta_campos = true;
        this.alerta_recapchat = false;
        this.alerta_credenciales = false;

      }else{
        if(this.recordarCuenta){
          if(!localStorage.getItem('hash') && !localStorage.getItem('besh')){
            localStorage.setItem('hash', this.correo);
            localStorage.setItem('besh', CryptoJS.MD5(this.password).toString());
          }else{
            if(this.password != "**-*-*-*-*"){
              this.alerta_campos = false;
              this.alerta_recapchat = false;
              this.alerta_credenciales = true;
              
              localStorage.removeItem('hash');
              localStorage.removeItem('besh');
              return
            }
            passwordMD5 = localStorage.getItem('besh');
          }
          

        }else{
          localStorage.removeItem('hash');
          localStorage.removeItem('besh');
        }

        // Realizar validación de ReCAPTCHA
        if(this.tokenRecaptcha != ""){

          const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS +'singIn/'+this.correo+'/'+passwordMD5);
          this.datosPersona = responseTipoDocumento.data;

          if(this.datosPersona != ""){
            this.alerta_campos = false;
            this.alerta_recapchat = false;
            this.alerta_credenciales = false;

            localStorage.setItem('id', this.datosPersona[0].id);
            localStorage.setItem('id_perfil', this.datosPersona[0].idPerfil);
            localStorage.setItem('nombres', this.datosPersona[0].nombres);
            localStorage.setItem('apellido_paterno', this.datosPersona[0].apellidoPaterno);
            localStorage.setItem('apellido_materno', this.datosPersona[0].apellidoMaterno);
            localStorage.setItem('dni', this.datosPersona[0].nroDocumento);
            localStorage.setItem('correo', this.correo);
            
            if(localStorage.getItem('hash') != localStorage.getItem('correo')){
              localStorage.setItem('hash', localStorage.getItem('correo'));
            }

            window.location.href = "/home";

          } else {
            this.alerta_campos = false;
            this.alerta_recapchat = false;
            this.alerta_credenciales = true;
          }
        }
        else {
          this.alerta_campos = false;
          this.alerta_recapchat = true;
        }
      }
    }
  }
};
</script>

<style>
.recapchat{
  display: flex;
  justify-content: space-around;
  margin: 0 0 20px 0;
}
</style>