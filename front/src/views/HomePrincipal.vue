
<style>

span {
    width: 100%;
    font-weight: 700;
    font-family: Sans,Sans-Serif;
    text-align: initial;
}

.divProductos {
    max-width: 300px;
    float: left;
    margin-left: 3rem;
    cursor: pointer;
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
    height: 2rem;
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
    border-radius: 0 10px 0 0;
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

.limpiarPaquete {
    color: aliceblue;
    display: flex;
    border-radius: 0 0 10px 0;
    width: 8rem;
    height: 100%;
    background-color: #f53d3d;
    transition: background-color 0.3s ease;
    align-items: center;
    justify-content: space-evenly;
}

.limpiarPaquete:hover {
    box-shadow: 0px 0px 20px 13px rgba(0, 0, 0, 0.1);
    background-color: #f40a0a;
    cursor: pointer;
}

.buscarPaquete span, .limpiarPaquete span {
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
  max-width: 50px;
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

.divPaquete {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    align-items: center;
    flex-direction: column;
    font-size: 20px;
}

.divPaquete span {
    width: 70%;
}

.btn-acciones {
    width: 8rem;
    padding: 0 !important;
    align-items: center;
    height: 2.5rem;
    flex-wrap: wrap;
    align-content: center;
}

</style>

<template>
    <inc_head/>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="body-wrapper" style="margin-left: 0; margin-top: 10px;">
        <div class="container-fluid" data-bd-theme="dark">
            <div class="card">
                <div class="buscador">
                    <div>
                        <span>Origen</span>
                        <!-- <input type="text" class="destino"> -->
                        <select v-model="paisPartida" @change="getCiudadesOrigen(pais)" class="custom-select">
                            <option value="">Seleccionar</option>
                            <option v-for="pais in paises" :key="pais.id" :value="pais.id">{{ pais.nombre }}</option>
                        </select>
                        <select v-model="ciudadPartida" class="custom-select">
                            <option value="">Seleccionar</option>
                            <option v-for="ciudad in ciudadesPartida" :key="ciudad.id" :value="ciudad.id">{{ ciudad.nombre }}</option>
                        </select>
                    </div>
                    <div>
                        <span>Destino</span>
                        <!-- <input type="text" class="destino"> -->
                        <select v-model="paisDestino" @change="getCiudadesDestino(pais)" class="custom-select">
                            <option value="">Seleccionar</option>
                            <option v-for="pais in paises" :key="pais.id" :value="pais.id">{{ pais.nombre }}</option>
                        </select>
                        <select v-model="ciudadDestino" class="custom-select">
                            <option value="">Seleccionar</option>
                            <option v-for="ciudad in ciudadesDestino" :key="ciudad.id" :value="ciudad.id">{{ ciudad.nombre }}</option>
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
                        <span>hu&eacute;sped</span>
                        <div>
                            <span>{{ currentText }}</span>
                        </div>
                        <!-- <input type="text" @click="huespedClick()" class="destino"> -->
                    </div>
                    <div class="btn-acciones">
                        <div @click="getPaquetes()" class="buscarPaquete">
                            <span>Buscar</span>
                        </div>
                        <div @click="limpiarFiltros()" class="limpiarPaquete">
                            <span>Limpiar</span>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div @click="modalPaqueteClick(paquete)" v-for="paquete in paquetes" :key="paquete.id" class="divProductos card mb-3">
                        <img src="@/assets/images/paquetes/cuzco.jpg" class="card-img-top" alt="...">
                        <div style="height: 120px;" class="card-body">
                            <h5 class="card-title">{{paquete.idpais + " - " + paquete.idciudad}}</h5>
                            <p class="card-text">{{ paquete.descripcion }}</p>
                            <p class="card-text"><small class="text-muted">S/ {{ precios[paquete.id] }}</small></p>                        </div>
                        <div class="card-footer">
                            <span class="card-title"><span style="color: #2a62fb;">{{paquete.fechaInicio}}</span> - <span style="color: #f40a0a;">{{paquete.fechaFinal}}</span></span>
                        </div>
                    </div>
                </div>
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

    <!-- Modal detalle paquete -->
    <div v-show="modalPaquete" style="display: block;" class="modal" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" @click="modalPaqueteClick()" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="divPaquete">
                        <span><i class="bi bi-arrow-right-square-fill"></i> Pa&iacute;s Origen: </span>
                        <span><i class="bi bi-arrow-right-square-fill"></i> Ciudad Origen: </span>
                        <span><i class="bi bi-arrow-left-square-fill"></i> Pa&iacute;s Destino: {{ paqueteSeleccionado.idpais }}</span>
                        <span><i class="bi bi-arrow-left-square-fill"></i> Ciudad Destino: {{ paqueteSeleccionado.idciudad }}</span>
                        <span><i class="bi bi-calendar-check"></i> Fecha de Partida: {{ paqueteSeleccionado.fechaInicio }}</span>
                        <span><i class="bi bi-calendar-check-fill"></i> Fecha de Regreso: {{ paqueteSeleccionado.fechaFinal }}</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button style="background-color: #5D87FF;" @click="modalPaqueteClick()" type="button" class="btn btn-success" data-bs-dismiss="modal"><i class="bi bi-cash-coin"></i> Comprar S/{{ paqueteSeleccionado.monto }}</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import inc_head from "./Inc/inc_head";
/* import CryptoJS from 'crypto-js';
 */var axios = require('axios');
/* var error = 0;
 */
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

            idMultiuser: 1/* localStorage.getItem('id_multiuser') */,

            paises: [],
            ciudadesDestino: [],
            ciudadesPartida: [],

            paisDestino: "",
            ciudadDestino: "",
            paisPartida: "",
            ciudadPartida: "",

            precios: {},

            montoPaquete: "",
            modalPaquete: "",

            paqueteSeleccionado: {}
        }
    },
    created() {
        this.intercalateText();
    },
    props: [],
    mounted: async function() {

        this.getPaquetes()

        const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS + 'getTiposDocumentos');
        this.tiposDocumentos = responseTipoDocumento.data;

        this.getPaises();
    },
    methods: {
        async getPaquetes(){
            const responsePaquetes = await axios.get( this.BASE_URL_AXIOS + 'getPaquetes');
            this.paquetes = responsePaquetes.data;

            this.paquetes.forEach((paquete) => {
                this.calcularPrecio(paquete.idtransporte, paquete.idhotel, paquete.actividades, paquete.id).then((precio) => {
                    this.precios[paquete.id] = precio; // Directly update the reactive property
                });
            });
        },
        async getPaises(){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getPaises/'+this.idMultiuser);
            this.paises = response.data;
        },
        async getCiudadesDestino(){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getCiudadesByIdPais/'+this.paisDestino);
            this.ciudadesDestino = response.data;
        },
        async getCiudadesOrigen(){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getCiudadesByIdPais/'+this.paisPartida);
            this.ciudadesPartida = response.data;
        },
        async getCiudadById(idCiudad){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getCiudadById/'+idCiudad);
            return response.data;
        },
        async getTransporteById(idTransporte){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getTransporteById/'+idTransporte);
            return response.data;
        },
        async getHotelById(idHotel){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getHotelById/'+idHotel);
            return response.data;
        },
        async getActividadById(idActividad){
            const response = await axios.get( this.BASE_URL_AXIOS + 'getActividadById/'+idActividad);
            return response.data;
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
        modalPaqueteClick(paquete) {
            if(this.modalPaquete){
                this.modalPaquete = false;
            }else{
                this.modalPaquete = true;
                this.paqueteSeleccionado = paquete;
            }
        },
        limpiarFiltros(){
            this.getPaquetes();
            this.ciudad = "";
            this.pais = "";
            this.fechaInicio = null;
            this.fechaFin = null;
            this.contAdultos = 1;
            this.contNinos = 0;
            this.contHabitaciones = 1;

        },
        async buscarPack(){
            console.log(this.contAdultos);
            console.log(this.contNinos);
            console.log(this.contHabitaciones);
            
            if(this.pais != ""){
                if(this.ciudad == ""){
                    this.ciudad = 0
                }
                
                if(this.fechaInicio == ""){
                    this.fechaInicio = 0
                }

                if(this.fechaFin == ""){
                    this.fechaFin = 0
                }
                const responsePaquetes = await axios.get( this.BASE_URL_AXIOS + 'getPaquetesByFiltros/'+this.pais+'/'+this.ciudad+'/'+this.fechaInicio+'/'+this.fechaFin);
                this.paquetes = responsePaquetes.data;
            } else {
                console.log("Seleccione un destino");
            }
        },
        async calcularPrecio(idTransporte, idHotel, idActividad, paqueteId){
            if(this.ciudadDestino != "" && this.ciudadPartida != "" && this.fechaInicio != "" && this.fechaFin != ""){
                //obtener lat y lon por id de ciudad
                let ciudadDest = await this.getCiudadById(this.ciudadDestino);

                //obtener lat y lon por id de ciudad
                let ciudadPart = await this.getCiudadById(this.ciudadPartida);

                //obtener costo de transporte
                let costTrans = await this.getTransporteById(idTransporte);

                //obtener costo de transporte
                let costHotel = await this.getHotelById(idHotel);

                //obtener costo de transporte
                let costActividad = await this.getActividadById(idActividad);

                //CANTIDA DE PERSONAS
                let cantPers = this.contAdultos + this.contNinos;
                let actividad   = cantPers * costActividad.precio;
                let hotel       = cantPers * costHotel.precioDia * this.contHabitaciones;
                let transporte  = cantPers * (costTrans.precioKm) * (this.getDistanciaKilometros(ciudadDest.latitud, ciudadDest.longitud, ciudadPart.latitud, ciudadPart.longitud));

                // Convert the date strings to JavaScript Date objects
                let fechaInicioObj = new Date(this.fechaInicio);
                let fechaFinalObj = new Date(this.fechaFin);

                // Calculate the time difference in milliseconds
                let timeDiff = fechaFinalObj.getTime() - fechaInicioObj.getTime();

                // Calculate the number of days between the start and end dates
                let days = timeDiff / (1000 * 60 * 60 * 24);

                let costoTotal = (actividad + hotel + transporte) * days;

                this.precios[paqueteId] = costoTotal;

                return costoTotal.toFixed(2);
            } else {
                return "...";
            }

        },
        getDistanciaKilometros(latitud1, longitud1, latitud2, longitud2) {
            const degreesToRadians = function(degrees) {
                return degrees * Math.PI / 180;
            };

            const earthRadiusKilometers = 6378.137; // Radio de la tierra en kilómetros

            const deltaLatitude = degreesToRadians(latitud2 - latitud1);
            const deltaLongitude = degreesToRadians(longitud2 - longitud1);

            const haversineA = Math.sin(deltaLatitude/2) * Math.sin(deltaLatitude/2) + 
                                Math.cos(degreesToRadians(latitud1)) * Math.cos(degreesToRadians(latitud2)) * 
                                Math.sin(deltaLongitude/2) * Math.sin(deltaLongitude/2);

            const haversineC = 2 * Math.atan2(Math.sqrt(haversineA), Math.sqrt(1-haversineA));

            // Aquí obtienes la distancia en kilómetros
            const distanceInKilometers = earthRadiusKilometers * haversineC;
            return distanceInKilometers;
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
        /* async addOperador(){
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
        }, */
        hideAlert() {
            this.showAlert = false;
        }
    }
}
</script>