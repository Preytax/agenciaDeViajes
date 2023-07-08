
<style>

span {
    width: 100%;
    font-weight: 700;
    font-family: Sans,Sans-Serif;
    text-align: initial;
}

.contador {
    
}

.contador div {
    width: 20px;
    height: 20px;
    border-radius: 50%;
    border: 1px solid;
}

.container-fluid {
    padding-top: 0px !important;
}

.buscador {
    display: flex;
    width: 100%;
    height: 5rem;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items: center;
    border-radius: 15px;
    box-shadow: 0px 0px 20px 13px rgba(0, 0, 0, 0.2);
}

.buscador div {
    display: flex;
    align-items: center;
    height: 100%;
    flex-wrap: wrap;
    align-content: center;
    padding: 20px;
}

.buscador div:not(:last-child) {
    padding-right: 10px;
    border-right: 1px solid rgba(0, 0, 0, 0.2);
}

/* .buscador div input {
    border: 0;
} */

.buscarPaquete {
    color: aliceblue;
    display: flex;
    border-radius: 0 10px 10px 0;
    width: 8rem;
    height: 100%;
    background-color: #5D87FF;
    transition: background-color 0.3s ease;
    align-items: center;
    justify-content: space-evenly;
}

.buscarPaquete:hover {
    box-shadow: 0px 0px 20px 13px rgba(0, 0, 0, 0.1);
    background-color: #2a62fb;
    cursor: pointer;
}

.buscarPaquete span {
    text-align: center;
}

.fecha span {
    display: flex;
    width: 100%;
}

.contador {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
}

.contador span {
    width: 25%;
}

.round-btn {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #f1f1f1;
  border: none;
  color: #333;
  font-size: 16px;
  cursor: pointer;
  margin-right: 10px;
}

.input-field {
    width: 3rem;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1rem;
    text-align: unset;
    margin-right: 0.5rem;
}

.custom-select {
  appearance: none;
  outline: none;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  background-color: #f1f1f1;
  border-radius: 4px;
  cursor: pointer;
}

.custom-select:nth-of-type(2) {
  margin-left: 2rem;
}

.custom-select:hover {
  background-color: #e1e1e1;
}

.custom-select:focus {
  background-color: #d1d1d1;
}

input[type="date"].custom-input {
  appearance: none;
  outline: none;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  background-color: #f1f1f1;
  border-radius: 4px;
  cursor: pointer;
}

input[type="date"].custom-input:hover {
  background-color: #e1e1e1;
}

input[type="date"].custom-input:focus {
  background-color: #d1d1d1;
}

input[type="date"].custom-input:nth-of-type(2) {
  margin-left: 2rem;
}

.huespedes {
    cursor: pointer;
}

.huespedes div {
    color: #5D87FF;
    width: 11rem;
}
</style>

<template>
    <inc_head/>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="body-wrapper">
        <div class="container-fluid" data-bd-theme="dark">
            <div class="card">
                <div class="buscador">
                    <div>
                        <span>Destino</span>
                        <!-- <input type="text" class="destino"> -->
                        <select v-model="pais" @change="getCiudades(pais)" class="custom-select">
                            <option value="">Seleccionar</option>
                            <option v-for="pais in paises" :key="pais.id" :value="pais.id">{{ pais.nombre }}</option>
                        </select>
                        <select v-model="ciudad" class="custom-select">
                            <option value="">Seleccionar</option>
                            <option v-for="ciudad in ciudades" :key="ciudad.id" :value="ciudad.id">{{ ciudad.nombre }}</option>
                        </select>
                    </div>
                    <div class="fecha">
                        <span>Inicio</span>
                        <input class="custom-input" v-model="fechaInicio" type="date">
                    </div>
                    <div class="fecha">
                        <span>Fin</span>
                        <input class="custom-input" v-model="fechaFin" type="date">
                    </div>
                    <div class="huespedes" @click="huespedClick()">
                        <span>Huesped</span>
                        <div>
                            <span>{{ currentText }}</span>
                        </div>
                        <!-- <input type="text" @click="huespedClick()" class="destino"> -->
                    </div>
                    <div @click="buscarPack()" class="buscarPaquete">
                        <span>Buscar</span>
                    </div>
                </div>
                <template v-for="paquete in paquetes" :key="paquete.id">
                    <div class="card-body">
                        <div class="card mb-3">
                        <img src="@/assets/images/paquetes/cuzco.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">{{paquete.idpais + " - " + paquete.idciudad}}</h5>
                            <p class="card-text">{{ paquete.descripcion }}</p>
                            <p class="card-text"><small class="text-muted">S/.{{ paquete.monto }}</small></p>
                        </div>
                        </div>
                    </div>
                </template>
            </div>
        </div>
    </div>
    <!-- Modal -->
    <div v-show="modalHuesped" style="display: block;" class="modal" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" @click="huespedClick()" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="contador">
                        <span>Adultos</span>
                        <button @click="pushAdulto()" class="round-btn">+</button>
                        <input v-model="contAdultos" type="text" class="input-field">
                        <button @click="pullAdulto()" class="round-btn">-</button>
                    </div>
                    <div class="contador">
                        <span>Niños</span>
                        <button @click="pushNinos()" class="round-btn">+</button>
                        <input v-model="contNinos" type="text" class="input-field">
                        <button @click="pullNinos()" class="round-btn">-</button>
                    </div>
                    <div class="contador">
                        <span>Habitaciones</span>
                        <button @click="pushHabitaciones()" class="round-btn">+</button>
                        <input v-model="contHabitaciones" type="text" class="input-field">
                        <button @click="pullHabitaciones()" class="round-btn">-</button>
                    </div>
                </div>
                <div class="modal-footer">
                    <button @click="huespedClick()" type="button" class="btn btn-success" data-bs-dismiss="modal">Aceptar</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import inc_head from "./Inc/inc_head";
import CryptoJS from 'crypto-js';
var axios = require('axios');
var error = 0;

export default{
    beforeRouteEnter(to, from, next) {
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
            // Redirigir a la página de inicio de sesión
            next('/login');
        } else if(localStorage.getItem('id_perfil') != 3){
            next('/homeOperador');
        } else {
            next();
        }
    },
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    components: {
        inc_head,
    },
    data(){
        return {
            paquetes: [],
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
            navLogin: true,

            fechaInicio: "",
            fechaFin: "",
            modalHuesped: false,

            textArray: ["Elegir Habitaciones", "Elegir Personas"],
            currentIndex: 0,
            currentText: '',

            contAdultos: 1,
            contNinos: 0,
            contHabitaciones: 1,

            idMultiuser: localStorage.getItem('id_multiuser'),

            paises: [],
            ciudades: [],

            pais: "",
            ciudad: ""

        }
    },
    created() {
        this.intercalateText();
    },
    props: [],
    mounted: async function() {

        const responsePaquetes = await axios.get( this.BASE_URL_AXIOS + 'getPaquetes');
        this.paquetes = responsePaquetes.data;

        const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS + 'getTiposDocumentos');
        this.tiposDocumentos = responseTipoDocumento.data;

        this.getPaises();
    },
    methods: {
        async getPaises(){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getPaises/'+this.idMultiuser);
            this.paises = response.data;
        },
        async getCiudades(){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getCiudadesByIdPais/'+this.pais);
            this.ciudades = response.data;
        },
        pushAdulto(){
            this.contAdultos += 1;
        },
        pullAdulto(){
            if(this.contAdultos > 1){
                this.contAdultos -= 1;
            }
        },
        pushNinos(){
            this.contNinos += 1;
        },
        pullNinos(){
            if(this.contNinos > 0){
                this.contNinos -= 1;
            }
        },
        pushHabitaciones(){
            this.contHabitaciones += 1;
        },
        pullHabitaciones(){
            if(this.contHabitaciones > 1){
                this.contHabitaciones -= 1;
            }
        },
        intercalateText() {
            this.currentText = this.textArray[this.currentIndex];
            this.currentIndex = (this.currentIndex + 1) % this.textArray.length;
            setTimeout(this.intercalateText, 2000);
        },
        huespedClick() {
            if(this.modalHuesped){
                this.modalHuesped = false;
            }else{
                this.modalHuesped = true;
            }
        },
        buscarPack(){
            console.log(this.contAdultos);
            console.log(this.contNinos);
            console.log(this.contHabitaciones);
        },
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