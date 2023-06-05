<template>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <transition name="fade">
        <div v-if="show" class="conteiner divSombraAlerta">
            <div class="contenedorAlerta">
                <div class="divAlerta">
                    <div class="body-wrapper">
                        <div class="container-fluid scrollEditor">
                            <div class="card">
                                <div class="card-body">
                                    <div class="tab-content">
                                        <div class="tab-pane fade show active" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                                            <div class="row g-3">
                                                <div class="col-sm-6">
                                                    <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre</label>
                                                    <input type="text" class="form-control" id="firstName" placeholder="" maxlength="45" v-model="nombres" required/>
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
                                                    <InputText type="date" class="form-control" id="lastName2" placeholder="" v-model="fechaNacimiento" :max="maxDate" required/>
                                                    <div ref="fechaNacimiento" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                                        La fecha de nacimiento es obligataoria.
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label for="country" class="form-label" _msttexthash="60047" _msthash="42">Tipo de Documento</label>
                                                    <select class="form-select" id="country" outlined v-model="tipoDocumento">
                                                        <option value="" _msttexthash="101647" _msthash="43">Elegir...</option>
                                                        <option v-for="tipoDocumento in tiposDocumentos" :key="tipoDocumento.id" :value="tipoDocumento.id">{{tipoDocumento.nombre}}</option>
                                                    </select>
                                                    <div ref="tipoDocumento" class="invalid-feedback" _msttexthash="685542" _msthidden="1" _msthash="45">
                                                        El tipo de documento es obligataorio.
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nro. de Documento</label>
                                                    <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="8" v-model="nroDocumento" required/>
                                                    <div ref="nroDocumento" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                                        El numero de documento es obligatorio.
                                                    </div>
                                                </div>            
                                                <div class="col-sm">
                                                    <label for="username" class="form-label">Correo Electronico</label>
                                                    <div class="input-group has-validation">
                                                        <span class="input-group-text">@</span>
                                                        <input v-model="correo" type="email" class="form-control" id="correo" placeholder="Correo" maxlength="150" required="">
                                                        <div ref="correo" class="invalid-feedback">
                                                            El correo electronico es obligatorio.
                                                        </div>
                                                        <div ref="correoValido" class="invalid-feedback">
                                                            Ingrese un correo electronico valido.
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row g-3 mt-1">
                                                <div class="col-sm-6">
                                                    <label for="email" class="form-label" _msttexthash="731406" _msthash="34">Contraseña <span class="text-body-secondary" _istranslated="1"></span></label>
                                                    <input autocomplete="off" v-model="password" type="password" class="form-control" id="password" placeholder="**********"  maxlength="10" _mstplaceholder="274417" _msthash="35">
                                                    <div ref="password" class="invalid-feedback" _msttexthash="1993589" _msthidden="1" _msthash="36">
                                                        Las contraseñas no coinciden.
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label for="email" class="form-label" _msttexthash="731406" _msthash="34">Repetir Contraseña <span class="text-body-secondary" _istranslated="1"></span></label>
                                                    <input autocomplete="off" v-model="passwordR" type="password" class="form-control" id="passwordR" placeholder="**********"  maxlength="10" _mstplaceholder="274417" _msthash="35">
                                                    <div ref="passwordR" class="invalid-feedback" _msttexthash="1993589" _msthidden="1" _msthash="36">
                                                        Las contraseñas no coinciden.
                                                    </div>
                                                </div>
                                            </div>
                                            <hr class="my-4">
                                        </div>
                                        <button @click="updatePersona" type="button" class="btn btn-success m-1">Actualizar</button>
                                        <button @click="ocultarEdit" ref="divOculto" type="button" class="btn btn-danger m-1">Cancelar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>

<script>
import axios from 'axios';
import CryptoJS from 'crypto-js';
var error = 0;
var passwMD5 = "";

export default {
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    name: "inc_editarInfo",
    data() {
        return {
            title: 'Operadores',
            id: localStorage.getItem('id'),
            persona: null,
            nombres: null,
            apellidoPaterno: null,
            apellidoMaterno: null,
            tipoDocumento: null,
            nroDocumento: null,
            fechaNacimiento: null,
            correo: null,
            password: null,
            passwordR: null,
            url: window.location.href,
            tiposDocumentos: null,
            showAlert: false,
            show: false,
        }
    },
    computed: {
        maxDate() {
            const now = new Date();
            const year = now.getFullYear();
            let month = now.getMonth() + 1;
            let day = now.getDate();

            if (month < 10) {
                month = '0' + month;
            }

            if (day < 10) {
                day = '0' + day;
            }

            return `${year}-${month}-${day}`;
        },
    },
    methods: {
        async getPersona() {
            const request = await axios.get( this.BASE_URL_AXIOS + 'getOperador/'+this.id);
            const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS + 'getTiposDocumentos');
            this.tiposDocumentos = responseTipoDocumento.data;

            this.persona           = request.data;
            this.nombres            = this.persona.nombres;
            this.apellidoPaterno    = this.persona.apellidoPaterno;
            this.apellidoMaterno    = this.persona.apellidoMaterno;
            this.tipoDocumento      = this.persona.tipoDocumento;
            this.nroDocumento       = this.persona.nroDocumento;
            this.fechaNacimiento    = this.persona.fechaNacimiento;
            this.correo             = this.persona.correo;
        },
        async updatePersona(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });

            if (this.nombres == null || this.nombres == "") {
                this.$refs.nombres.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.apellidoPaterno == null || this.apellidoPaterno == "") {
                this.$refs.apellidoPaterno.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.apellidoMaterno == null || this.apellidoMaterno == "") {
                this.$refs.apellidoMaterno.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.tipoDocumento == null || this.tipoDocumento == "") {
                this.$refs.tipoDocumento.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.nroDocumento == null || this.nroDocumento == "") {
                this.$refs.nroDocumento.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.fechaNacimiento == null || this.fechaNacimiento == "") {
                this.$refs.fechaNacimiento.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.correo == null || this.correo == "") {
                this.$refs.correo.classList.add("mostrarObligatorio");
                error = 1;
            }else if(this.validateEmail(this.correo)){
                this.$refs.correoValido.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.password != null && this.password != ""){
                if(this.password === this.passwordR){
                    passwMD5 = CryptoJS.MD5(this.password).toString();
                }else{
                    this.$refs.password.classList.add("mostrarObligatorio");
                    this.$refs.passwordR.classList.add("mostrarObligatorio");
                    error = 1;
                }
            }

            if(error == 0){
                
                const request = await axios({
                    method: "PUT",
                    url: this.BASE_URL_AXIOS + "updatePersona",
                    data: {
                        "id"                : this.id,
                        "nombres"           : this.nombres,
                        "apellidoPaterno"   : this.apellidoPaterno,
                        "apellidoMaterno"   : this.apellidoMaterno,
                        "tipoDocumento"     : this.tipoDocumento,
                        "nroDocumento"      : this.nroDocumento,
                        "fechaNacimiento"   : this.fechaNacimiento,
                        "correo"            : this.correo,
                        "password"          : passwMD5,
                    },
                    headers: {
                        "Content-Type": "application/json"
                    }
                })

                var respuesta =  request.data.split("|");
                if(respuesta[0] == "OK")
                {
                    this.valorAlerta = respuesta[1];
                    this.showAlert = true;
                    setTimeout(() => {
                        location.reload();
                    }, 1000);

                }else{
                    this.valorAlerta = respuesta[1];
                    this.showAlert = true;
                }
            }

            
        },
        validateEmail(email) {
            const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!regex.test(email)) {
                return true;
            } else {
                return false;
            }
        },
        mostrarEdit(){
            this.show = true;
        },
        ocultarEdit(){
            this.show = false;
        },
        hideAlert() {
            this.showAlert = false;
        }
    },
};

</script>

<style>
.mostrarObligatorio{
  display: block !important;
}

.divSombraAlerta{
  width: 100%;
  height: 100%;
  position: fixed;
  background: #c4c4c4b0;
  bottom: 0;
  left: 0;
  z-index: 9999;
}

.contenedorAlerta{
    width: 100%; 
    height: 25rem; 
    background-color: #5d87ff; 
    position: absolute; 
    bottom: 0;
    border: solid 1px;
}

.divAlerta{
    position: absolute;
    bottom: 0;
    top: -450px
}

.scrollEditor{
    max-height: 700px;
    overflow-x: hidden;
    overflow-y: scroll;
}

@media (min-width: 767.98px)
{
    .scrollEditor{
        margin-left: 200px !important;
    }
}

.fade-enter-active{
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
} 
.fade-leave-active {
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.fade-enter-from, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0
}
</style>