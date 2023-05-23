<template>
  <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
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
                <a href="#" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="@/assets/images/logos/dark-logo.svg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
                
                
                <div class="row g-3">
                  <div class="col-sm-6">
                      <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre</label>
                      <InputText type="text" class="form-control" id="firstName" placeholder="" maxlength="45" v-model="nombres" required/>
                      <div ref="nombres" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                          El nombre es obligatorio.
                      </div>
                  </div>
                  <div class="col-sm-6">
                      <label for="lastName" class="form-label" _msttexthash="112346" _msthash="29">Apellido Paterno</label>
                      <InputText type="text" class="form-control" id="lastName" placeholder="" maxlength="45" v-model="apellidoPaterno" required/>
                      <div ref="apellidoPaterno" class="invalid-feedback" _msttexthash="592748" _msthidden="1" _msthash="30">
                          El apellido paterno es obligatorio.
                      </div>
                  </div>
                  <div class="col-sm-6">
                      <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Aapellido Materno</label>
                      <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="45" v-model="apellidoMaterno" required/>
                      <div ref="apellidoMaterno" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                          El apellido materno es obligatorio.
                      </div>
                  </div>
                  <div class="col-sm-6">
                      <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Fecha de Nacimiento</label>
                      <InputText type="date" class="form-control" id="lastName2" placeholder="" v-model="fechaNacimiento" required/>
                      <div ref="fechaNacimiento" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                          La fecha de Nacimiento es obligatoria.
                      </div>
                  </div>
                  <div class="col-sm-6">
                      <label for="country" class="form-label" _msttexthash="60047" _msthash="42">Tipo de Documento</label>
                      <select class="form-select" id="country" outlined v-model="tipoDocumento">
                          <option value="" _msttexthash="101647" _msthash="43">Elegir...</option>
                          <option v-for="tipoDocumento in tiposDocumentos" :key="tipoDocumento.id" :value="tipoDocumento.id">{{tipoDocumento.nombre}}</option>
                      </select>
                      <div ref="tipoDocumento" class="invalid-feedback" _msttexthash="685542" _msthidden="1" _msthash="45">
                          El tipo de documento es obligatorio.
                      </div>
                  </div>
                  <div class="col-sm-6">
                      <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nro. de Documento</label>
                      <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="8" v-model="nroDocumento" required/>
                      <div ref="nroDocumento" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                          El nro. de documento es obligatorio.
                      </div>
                  </div>            
                  <div class="col-sm-6">
                      <label for="username" class="form-label">Correo Electronico</label>
                      <div class="input-group has-validation">
                          <span class="input-group-text">@</span>
                          <input v-model="correo" type="email" class="form-control" id="correo" placeholder="Correo" maxlength="150" required="">
                          <div ref="correo" class="invalid-feedback">
                              El correo es obligatorio.
                          </div>
                      </div>
                  </div>
                  <div class="col-sm-6">
                      <label for="email" class="form-label" _msttexthash="731406" _msthash="34">Contraseña <span class="text-body-secondary" _istranslated="1"></span></label>
                      <input v-model="password" type="password" class="form-control" id="password" placeholder="**********"  maxlength="10" _mstplaceholder="274417" _msthash="35">
                      <div ref="password" class="invalid-feedback" _msttexthash="1993589" _msthidden="1" _msthash="36">
                          Please enter a valid email address for shipping updates.
                      </div>
                  </div>
                </div>

                <hr class="my-4">

                <!--
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="same-address">
                    <label class="form-check-label" for="same-address" _msttexthash="2733666" _msthash="52">La dirección de envío es la misma que mi dirección de facturación</label>
                </div>

                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="save-info">
                    <label class="form-check-label" for="save-info" _msttexthash="1399762" _msthash="53">Guarde esta información para la próxima vez</label>
                </div>

                <hr class="my-4">
                -->

                <a class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2" @click="addOperador" href="#">Registrarse</a>
                <div class="d-flex align-items-center justify-content-center">
                  <p class="fs-4 mb-0 fw-bold">Already have an Account?</p>
                  <a class="text-primary fw-bold ms-2" :href="baseUrl + 'login'">Iniciar Sesi&oacute;n</a>
                </div>
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
var error = 0;

export default{
    inject: ['baseUrl'],
    components: {
    },
    data(){
        return {
            idPerfil: null,
            nombres: null,
            apellidoPaterno: null,
            apellidoMaterno: null,
            tipoDocumento: null,
            nroDocumento: null,
            fechaNacimiento: null,
            correo: null,
            password: null,
            showAlert: false,
            tiposDocumentos: null,
            valorAlerta: "",
            navRegister: false,
            tabResgiter: false,
            tabLogin: true,
            navLogin: true
        }
    },
    props: [],
    mounted: async function() {

        const baseUrl = 'http://localhost:8080/';

        const responseTipoDocumento = await axios.get( baseUrl + 'getTiposDocumentos');
        this.tiposDocumentos = responseTipoDocumento.data;
    },
    methods: {
        async showLogin(){
            this.tabResgiter = false
            this.navRegister = false
            this.tabLogin = true
            this.navLogin = true
        },
        async showRegister(){
            this.tabResgiter = true
            this.navRegister = true
            this.tabLogin = false
            this.navLogin  = false
        },
        async addOperador(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });
           
            if (this.nombres == null || this.nombres == "") {
                this.showAlert = true;
                this.$refs.nombres.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.apellidoPaterno == null || this.apellidoPaterno == "") {
                this.showAlert = true;
                this.$refs.apellidoPaterno.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.apellidoMaterno == null || this.apellidoMaterno == "") {
                this.showAlert = true;
                this.$refs.apellidoMaterno.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.tipoDocumento == null || this.tipoDocumento == "") {
                this.showAlert = true;
                this.$refs.tipoDocumento.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.nroDocumento == null || this.nroDocumento == "") {
                this.showAlert = true;
                this.$refs.nroDocumento.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.fechaNacimiento == null || this.fechaNacimiento == "") {
                this.showAlert = true;
                this.$refs.fechaNacimiento.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.correo == null || this.correo == "") {
                this.showAlert = true;
                this.$refs.correo.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.password == null || this.password == "") {
                this.showAlert = true;
                this.$refs.password.classList.add("mostrarObligatorio");
                error = 1;
            }
            if(error != 0){
               return;
            }
            const newOperador = {
                idPerfil : 3,
                nombres : this.nombres,
                apellidoPaterno : this.apellidoPaterno,
                apellidoMaterno : this.apellidoMaterno,
                tipoDocumento : this.tipoDocumento,
                nroDocumento : this.nroDocumento,
                fechaNacimiento : this.fechaNacimiento,
                correo : this.correo,
                password : CryptoJS.MD5(this.password).toString()
            };

            const baseUrl = "http://localhost:8080/";

            const request = await axios({
                method: "POST",
                url: baseUrl + "saveOperador",
                data: newOperador,
                headers: {
                    "Content-Type": "application/json"
                }
            })
            /*.then(()=>{
                
            })
            .catch(err => console.log(err));*/
            var arreglo =  request.data.split("|");

            if(arreglo[0] == "OK")
            {
                this.valorAlerta = arreglo[1];
                this.showAlert = true;
                setTimeout(() => {
                    location.reload();
                }, 1000);

            }else{
                this.valorAlerta = arreglo[1];
                this.showAlert = true;
            }
        },
        hideAlert() {
            this.showAlert = false;
        }
      }
  };

</script>

<style>
.mostrarObligatorio{
  display: block !important;
}
</style>