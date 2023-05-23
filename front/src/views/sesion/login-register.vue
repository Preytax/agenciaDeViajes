<template>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="container" style="max-width: 400px;">
        <main data-bd-theme="dark">
            <!-- Pills navs -->
            <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                <li class="nav-item" role="presentation">
                    <a :class="{ 'show active': navLogin}" @click="showLogin" class="nav-link" id="tab-login" data-mdb-toggle="pill" href="#pills-login" role="tab"
                    aria-controls="pills-login" aria-selected="true">Login</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a :class="{ 'show active': navRegister}" @click="showRegister" class="nav-link" id="tab-register" data-mdb-toggle="pill" href="#pills-register" role="tab"
                    aria-controls="pills-register" aria-selected="false">Register</a>
                </li>
                </ul>
                <!-- Pills navs -->

                <!-- Pills content -->
                <div class="tab-content">
                <div :class="{ 'show active': tabLogin}" class="tab-pane fade" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <form>
                    <div class="text-center mb-3">
                        <p>Sign in with:</p>
                        <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-facebook-f"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-google"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-twitter"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-github"></i>
                        </button>
                    </div>

                    <p class="text-center">or:</p>

                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" id="loginName" class="form-control" />
                        <label class="form-label" for="loginName">Email or username</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <input type="password" id="loginPassword" class="form-control" />
                        <label class="form-label" for="loginPassword">Password</label>
                    </div>

                    <!-- 2 column grid layout -->
                    <div class="row mb-4">
                        <div class="col-md-6 d-flex justify-content-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-3 mb-md-0">
                            <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
                            <label class="form-check-label" for="loginCheck"> Remember me </label>
                        </div>
                        </div>

                        <div class="col-md-6 d-flex justify-content-center">
                        <!-- Simple link -->
                        <a href="#!">Forgot password?</a>
                        </div>
                    </div>

                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

                    <!-- Register buttons -->
                    <div class="text-center">
                        <p>Not a member? <a href="#!">Register</a></p>
                    </div>
                    </form>
                </div>
                <div :class="{ 'show active': tabResgiter}" class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
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
                </div>
                <!-- Pills content -->
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
            console.log("llego")
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("notValid-Requerid");
                }
            });
           
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
}
</script>

<style>

</style>