<template>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="container">
        <main data-bd-theme="dark">
            <div class="py-5 text-center">
                <h2 class="mb-4" _msttexthash="318188" _msthash="6">Dirección de facturación</h2>
                <div class="row g-3">
                    <div class="col-sm-6">
                        <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre</label>
                        <InputText type="text" class="form-control" id="firstName" placeholder="" maxlength="45" v-model="nombres" required/>
                        <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="lastName" class="form-label" _msttexthash="112346" _msthash="29">Apellido Paterno</label>
                        <InputText type="text" class="form-control" id="lastName" placeholder="" maxlength="45" v-model="apellidoPaterno" required/>
                        <div class="invalid-feedback" _msttexthash="592748" _msthidden="1" _msthash="30">
                            Valid last name is required.
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Aapellido Materno</label>
                        <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="45" v-model="apellidoMaterno" required/>
                        <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Fecha de Nacimiento</label>
                        <InputText type="date" class="form-control" id="lastName2" placeholder="" v-model="fechaNacimiento" required/>
                        <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="country" class="form-label" _msttexthash="60047" _msthash="42">Tipo de Documento</label>
                        <select class="form-select" id="country" outlined v-model="tipoDocumento">
                            <option value="" _msttexthash="101647" _msthash="43">Elegir...</option>
                            <option v-for="tipoDocumento in tiposDocumentos" :key="tipoDocumento.id" :value="tipoDocumento.id">{{tipoDocumento.nombre}}</option>
                        </select>
                        <div class="invalid-feedback" _msttexthash="685542" _msthidden="1" _msthash="45">
                            Please select a valid country.
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nro. de Documento</label>
                        <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="8" v-model="nroDocumento" required/>
                        <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="state" class="form-label" _msttexthash="76037" _msthash="46">Perfil</label>
                        <select class="form-select" id="state" v-model="idPerfil">
                            <option value="" selected>Elegir...</option>
                            <template v-for="perfil in perfiles">
                                <option  v-if="perfil.id == 2 || perfil.id == 4" :key="perfil.id" :value="perfil.id">{{perfil.nombre}}</option>
                            </template>
                        </select>
                        <div class="invalid-feedback" _msttexthash="631839" _msthidden="1" _msthash="49">
                            Please provide a valid state.
                        </div>
                    </div>
                    
                    <div class="col-sm-6">
                        <label for="username" class="form-label">Correo Electronico</label>
                        <div class="input-group has-validation">
                            <span class="input-group-text">@</span>
                            <input v-model="correo" type="email" class="form-control" id="correo" placeholder="Correo" maxlength="150" required="">
                            <div class="invalid-feedback">
                                Your username is required.
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <label for="email" class="form-label" _msttexthash="731406" _msthash="34">Contraseña <span class="text-body-secondary" _istranslated="1"></span></label>
                        <input v-model="password" type="password" class="form-control" id="password" placeholder="**********"  maxlength="10" _mstplaceholder="274417" _msthash="35">
                        <div class="invalid-feedback" _msttexthash="1993589" _msthidden="1" _msthash="36">
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

                <a class="w-100 btn btn-primary btn-lg" @click="addOperador" href="#">Registrar</a>
            </div>
        </main>
    </div>
</template>

<script>
import CryptoJS from 'crypto-js';
var axios = require('axios');
var error = 0;

export default{
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
            perfiles: null,
            tiposDocumentos: null,
            valorAlerta: ""
        }
    },
    props: [],
    mounted: async function() {
        const baseUrl = 'http://localhost:8080/';
        
        const responsePerfil = await axios.get( baseUrl + 'getPerfiles');
        this.perfiles = responsePerfil.data;

        const responseTipoDocumento = await axios.get( baseUrl + 'getTiposDocumentos');
        this.tiposDocumentos = responseTipoDocumento.data;
    },
    methods: {
        
        async addOperador(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("notValid-Requerid");
                }
            });
           
            if (this.idPerfil == null) {
                this.showAlert = true;
                //this.$refs.idPerfil.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.nombres == null) {
                this.showAlert = true;
                //this.$refs.nombres.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.apellidoPaterno == null) {
                this.showAlert = true;
                //this.$refs.apellidoPaterno.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.apellidoMaterno == null) {
                this.showAlert = true;
                //this.$refs.apellidoMaterno.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.tipoDocumento == null) {
                this.showAlert = true;
                //this.$refs.tipoDocumento.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.nroDocumento == null) {
                this.showAlert = true;
                //this.$refs.nroDocumento.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.fechaNacimiento == null) {
                this.showAlert = true;
                //this.$refs.fechaNacimiento.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.correo == null) {
                this.showAlert = true;
                //this.$refs.fechaNacimiento.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.password == null) {
                this.showAlert = true;
                //this.$refs.fechaNacimiento.classList.add("notValid-Requerid");
                error = 1;
            }
            if(error != 0){
               return;
            }
            const newOperador = {
                idPerfil : this.idPerfil,
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
}
</script>

<style>
.container, nav {
  max-width: 960px;
}

.mp_row_Alert
{
    font: 14px/14px HelveticaNeue_Light;
    color: #fff;
    background: #404040;
    border-radius: 4px;
    padding: 30px 28px;
    position: fixed;
    width: 35%;
    z-index: 99999999;
    bottom: 6%;
    padding-right: 60px;
	left:0;
	right:0;
	margin:0 auto;
}

.mp_row_Alert i
{
	background-image: url("https://dev2.manpower-powertrade.com/images/types-form/icon-close-alert.svg");
    background-repeat: no-repeat;
    background-position: 95%;
    position: absolute;
    width: 100%;
    height: 100%;
    right: 0;
    top: 0;
    bottom: 0;
    cursor: pointer;
}

.notValid-Requerid input[type="text"],
.notValid-Requerid input[type="number"],
.notValid-Requerid input[type="date"],
.notValid-Requerid select
{
	border: 1px solid #FC5352 !important;
}

.notValid-Requerid label
{
	color:#FC5352 !important;
}

.notValid-Requerid .check-view-password {
    background: url("https://dev2.manpower-powertrade.com/images/login/view_iconError.svg") no-repeat;
    background-size: contain;
    background-position: center;
}

</style>