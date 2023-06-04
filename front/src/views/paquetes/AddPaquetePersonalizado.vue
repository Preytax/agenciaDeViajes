<template>
    <div class="mp_row_Alert" v-if="showAlert">Falta completar datos obligatorios.<i @click="hideAlert"></i></div>
    <h1 class="titulo">Creación del Paquete</h1>
    <div class="CracionPaquetes">
        <div>
            <ul>
                <li ref="Pais">
                    <label>Elegir país: </label>
                    <select v-model="pais">
                        <option v-for="pais in paises" :key="pais.id" :value="pais.id">{{pais.nombre}}</option>
                    </select>
                </li>
                <li ref="Ciudad">
                    <label>Elegir ciudad: </label>
                    <select v-model="ciudad">
                        <option v-for="ciudad in ciudades" :key="ciudad.id" :value="ciudad.id">{{ciudad.nombre}}</option>
                    </select>
                </li>
                <li ref="Destino">
                    <label>Elegir destino: </label>
                    <select v-model="destino">
                        <option v-for="destino in destinos" :key="destino.id" :value="destino.id">{{destino.nombre}}</option>
                    </select>
                </li>
                <li ref="Actividades">
                    <label>Eligir actividades: </label>
                    <select v-model="actividad">
                        <option v-for="actividad in actividades" :key="actividad.id" :value="actividad.id">{{actividad.nombre}}</option>
                    </select>
                </li>
                <li ref="Hotel">
                    <label>Elegir hotel: </label>
                    <select v-model="hotel">
                        <option v-for="hotel in hoteles" :key="hotel.id" :value="hotel.id">{{hotel.nombre}}</option>
                    </select>
                </li>
                <li ref="MedioTransporte">
                    <label>Elegir medio de transporte: </label>
                    <select v-model="transporte">
                        <option v-for="transporte in transportes" :key="transporte.id" :value="transporte.id">{{transporte.nombre}}</option>
                    </select>
                </li>
                <li ref="fechaInicio">
                    <label>Fecha de inicio: </label>
                    <input type="date">
                </li>
                <li ref="fechaCierre">
                    <label>Fecha de cierre: </label>
                    <input type="date">
                </li>
                <li ref="montoTotal">
                    <label>Monto total: </label>
                    <input type="textarea">
                </li>
            </ul>
        </div>
    </div>
    <div class="divOpciones">
        <ul>
            <li><a class="addAGVOperador" @click="addOperador" href="#">Guardar Paquete</a></li>
            <li><a href="/vista">Cancelar</a></li>
        </ul>
    </div>
</template>

<script>
var axios = require('axios');
var error = 0;

export default{
    beforeRouteEnter(to, from, next) {
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
        // Redirigir a la página de inicio de sesión
        next('/login');
        } else {
        next();
        }
    },
    data(){
        return {
            paises: null,
            Destino: null,
            Actividades: null,
            Hotel: null,
            MedioTransporte: null,
            montoTotal: null,
            fechaInicio: null,
            fechaCierre: null,
            showAlert: false,
            destinos: null
        }
    },
    props: [],
    methods: {
        async getDestinos(){
            const response = await axios.get('http://localhost:8080/getDestinos');
            this.destino = response.data;
        },
        async getPaises(){
            const response = await axios.get('http://localhost:8080/getPaises');
            this.paises = response.data;
        },
        async getCiudad(){
            const response = await axios.get('http://localhost:8080/getCiudades');
            this.ciudad = response.data;
        },
        async getHoteles(){
            const response = await axios.get('http://localhost:8080/getHoteles');
            this.hotel = response.data;
        },
        async getActividades(){
            const response = await axios.get('http://localhost:8080/getActividades');
            this.destinos = response.data;
        },
        async getTransporte(){
            const response = await axios.get('http://localhost:8080/getTransportes');
            this.transporte = response.data;
        },
        async CreatePaquetes(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                elements.classList.remove("notValid-Requerid");
                }
            });
           
            if (this.paises == null) {
                this.showAlert = true;
                this.$refs.pais.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.ciudad == null) {
                this.showAlert = true;
                this.$refs.ciudad.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.destino == null) {
                this.showAlert = true;
                this.$refs.destino.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.Actividades == null) {
                this.showAlert = true;
                this.$refs.Actividades.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.MedioTransporte == null) {
                this.showAlert = true;
                this.$refs.MedioTransporte.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.ho == null) {
                this.showAlert = true;
                this.$refs.hotel.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.fechaInicio == null) {
                this.showAlert = true;
                this.$refs.fechaInicio.classList.add("notValid-Requerid");
                error = 1;
            }
            if (this.fechaCierre == null) {
                this.showAlert = true;
                this.$refs.fechaCierre.classList.add("notValid-Requerid");
                error = 1;
            }
            if(error != 0){
               return;
            }
            const newPaquete = {
                id : this.id,
                idDestino : this.idDestino,
                idhotel : this.idhotel,
                Actividades : this.Actividades,
                MedioTransporte : this.MedioTransporte,
                fechaInicio : this.fechaInicio,
                fechaCierre : this.fechaCierre
            };

            const baseUrl = "http://localhost:8080/";

            await axios({
                method: "POST",
                url: baseUrl + "savePaquete",
                data: newPaquete,
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then(()=>{
                console.log("Paquete creado");
                
            })
            .catch(err => console.log(err));
        },
        hideAlert() {
            this.showAlert = false;
        }
    }
}
</script>

<style>
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

.titulo{
    margin-left: 50px;
}

.divDatosRegistro{
    width: 80%; 
    position: relative;
}

.divDatosRegistro div{
    width: 800px;
    position: absolute;
    top: 50%;
    left: 50%;
    margin: 10px 0 0 -205px;   
}

.divDatosRegistro div ul{
    list-style: none; 
    display: flex;
    flex-flow: row wrap;
}

.divDatosRegistro div ul li{
    width: 30%;
    margin-right: 20%;
    margin-bottom: 35px;
    position: relative;
}

.divDatosRegistro div ul li input{
    width: 100%;
    font: 14px/14px HelveticaNeue_Light;
    color: #67686E;
    height: 32px;
    border: 1px solid #BBBBBD;
    box-shadow: 0px 7px 64px rgba(0, 0, 0, 0.07);
    padding: 0 16px;
    border-radius: 3px;
}

.divDatosRegistro div ul li select{
    width: 100%;
    font: 14px/14px HelveticaNeue_Light;
    color: #67686E;
    height: 32px;
    border: 1px solid #BBBBBD;
    box-shadow: 0px 7px 64px rgba(0, 0, 0, 0.07);
    padding: 0 16px;
    border-radius: 3px;
}

.divOpciones{
    margin: 0;
    margin-top: 200px;
    margin-left: 50px;
    margin-bottom: 20px;
    background-color: blue;
    width: 400px;
    height: 50px;
    border-radius: 30px;
    position: absolute;
    bottom: 0px;
}

.divOpciones ul{
    list-style: none;
}

.divOpciones ul li {
    margin-top: -5px;
    float: left;
    width: 140px;
    height: 30px;
    background-color: white;
    border-radius: 30px;
    line-height: 30px;
    text-align: center;
}

.divOpciones ul li:not(:first-of-type){
    margin-left: 20px;
}

.divOpciones ul li a {
    text-decoration: none;
    color: black;
}

table {
    width: 100%;
    border: 1px solid #000;
 }
 
 th, td {
    width: 25%;
    text-align: left;
    vertical-align: top;
    border: 1px solid #000;
    border-collapse: collapse;
    padding: 0.3em;
 }
</style>