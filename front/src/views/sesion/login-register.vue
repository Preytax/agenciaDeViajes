<template>
    <inc_head/>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="body-wrapper">
        <div class="container-fluid" data-bd-theme="dark">
            <div class="card">
                <template v-for="paquete in paquetes" :key="paquete.id">
                    <div class="card-body">
                        <div class="card mb-3">
                        <img src="@/assets/images/paquetes/cuzco.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">{{paquete.idpais + " - " + paquete.idciudad}}</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                        </div>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
import inc_head from "../Inc/inc_head";
import CryptoJS from 'crypto-js';
var axios = require('axios');
var error = 0;

export default{
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    components: {
        inc_head,
    },
    data(){
        return {
            paquetes: [
                {
                    id: "123",
                    ciudad: "Lima",
                    pais: "Peru"
                }
            ],
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

        const responsePaquetes = await axios.get( this.BASE_URL_AXIOS + 'getPaquetes');
        this.paquetes = responsePaquetes.data;

        const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS + 'getTiposDocumentos');
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

            const request = await axios({
                method: "POST",
                url: this.BASE_URL_AXIOS + "saveOperador",
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