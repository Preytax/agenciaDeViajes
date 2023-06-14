<template>
    <inc_head />
    <div class="mp_row_Alert" v-if="showAlert">
        {{ valorAlerta }}<i @click="hideAlert"></i>
    </div>
    <div class="body-wrapper">
        <div class="container-fluid" data-bd-theme="dark">
            <div class="card">
                <div class="card-body">
                    <h2 class="mb-4" _msttexthash="318188" _msthash="6">
                        Creacion de Paquetes Estandar
                    </h2>
                    <form class="row g-3">
                        <div class="col-md-6"> <!--Pais-->
                            <label for="inputEmail4" class="form-label">Elegir Pais</label>
                            <select v-model="paises1" @change="paisesr" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="pais in paises" :key="pais.id" :value="pais.id">
                                    {{ pais.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Departamento</label>
                            <select v-model="departamento2" @change="ciudad5" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="departamento in departamentos" :key="departamento.id"
                                    :value="departamento.id">
                                    {{ departamento.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Ciudad</label>
                            <select v-model="cuidades2" @change="hotelactividades" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="ciudad in cuidades" :key="ciudad.id" :value="ciudad.id">
                                    {{ ciudad.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Hotel</label>
                            <select v-model="hoteles2" class="form-select" aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="hotel in hoteles" :key="hotel.id" :value="hotel.id">
                                    {{ hotel.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-12">
                            <label for="inputEmail4" class="form-label">Elegir Activades</label>
                            <select v-model="actividades2" class="form-select" aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="actividad in actividades" :key="actividad.id" :value="actividad.id">
                                    {{ actividad.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6"> <!--Tipo-Transporte-->
                            <label for="inputEmail4" class="form-label">Elegir el tipo Transporte</label>
                            <select v-model="modoDeTransporte" @change="tansporte" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="modoTransporte in modoTransportes" :key="modoTransporte.id"
                                    :value="modoTransporte.id">
                                    {{ modoTransporte.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6"> <!--Agencia-Transporte-->
                            <label for="inputEmail4" class="form-label">Agencia de Transporte</label>
                            <select v-model="transportes1" class="form-select" aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="transporte in transportes" :key="transporte.id" :value="transporte.id">
                                    {{ transporte.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6"> <!--Fecha Final-->
                            <label for="inputEmail4" class="form-label">Elegir Fecha de Inicio</label>
                            <input v-model="fechaInicio" type="date" class="form-control" id="" placeholder="">
                        </div>
                        <div class="col-md-6"> <!--Fecha Final-->
                            <label for="inputEmail4" class="form-label">Elegir Fecha Final</label>
                            <input v-model="fechaFinal" type="date" class="form-control" id="" placeholder="">
                        </div>
                        <div class="col-md-12"> <!--Monto-->
                            <label for="inputEmail4" class="form-label">Monto Total</label>
                            <input v-model="monto" type="text" class="form-control" id="" placeholder="Ingrese Monto">
                        </div>
                    </form>
                    <hr class="my-4" />
                    <a class="w-100 btn btn-primary btn-lg" @click="addPaqueteEstandar" href="#">Registrar Paquete</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import inc_head from "../Inc/inc_head";
var axios = require("axios");
var error = 0;

export default {
    beforeRouteEnter(to, from, next) {
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
            // Redirigir a la página de inicio de sesión
            next('/login');
        } else if(localStorage.getItem('id_perfil') != 2  && localStorage.getItem('id_perfil') != 4){
            next('/home');
        } else {
            next();
        }
    },
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    components: {
        inc_head
    },
    data() {
        return {
            modoDeTranposte: null,
            paises: null,
            departamentos: null,
            departamento2: null,
            cuidades: null,
            cuidades2: null,
            actividades: null,
            actividades2: null,
            hoteles: null,
            hoteles2: null,
            modoTransportes: null,
            transportes1: null,
            transportes: null,
            fechaInicio: null,
            fechaFinal: null,
            monto: null,
            showAlert: null,
        };
    },
    mounted: async function () {
        const responsePais = await axios.get(this.BASE_URL_AXIOS + "getPaises");
        this.paises = responsePais.data;
        const responseTipoTransporte = await axios.get(this.BASE_URL_AXIOS + "getTipoTransporte");
        this.modoTransportes = responseTipoTransporte.data;
    },
    props: [],
    methods: {
        async paisesr() {
            const responseDepartamento = await axios.get(this.BASE_URL_AXIOS + "getDepartamento/" + this.paises1);
            this.departamentos = responseDepartamento.data;
        },

        async tansporte() {
            const responseTransporte = await axios.get(this.BASE_URL_AXIOS + "getTransportes/" + this.modoDeTransporte);
            this.transportes = responseTransporte.data;
        },

        async ciudad5() {
            const responseCuidad = await axios.get(this.BASE_URL_AXIOS + "getCiudades/" + this.departamento2);
            this.cuidades = responseCuidad.data;
        },

        async hotelactividades() {
            const responseHotel = await axios.get(this.BASE_URL_AXIOS + "getHoteles/" + this.cuidades2);
            this.hoteles = responseHotel.data;
            const responseActividad = await axios.get(this.BASE_URL_AXIOS + "getActividades/" + this.cuidades2);
            this.actividades = responseActividad.data;
        },

        async addPaqueteEstandar() {
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    //elements.classList.remove("mostrarObligatorio");
                }
            });
            if (this.paises == null) {
                this.showAlert = true;
                //this.$refs.pais.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.departamentos == null) {
                this.showAlert = true;
                //this.$refs.departamentos.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.cuidades == null) {
                this.showAlert = true;
                //this.$refs.cuidades.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.actividades == null) {
                this.showAlert = true;
                //this.$refs.actividades.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.hoteles == null) {
                this.showAlert = true;
                //this.$refs.hoteles.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.modoTransportes == null) {
                this.showAlert = true;
                //this.$refs.modoTransporte.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.transportes == null) {
                this.showAlert = true;
                //this.$refs.transportes.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (error == 0) {
                const newPaqueteEstandar = {
                    idmodo: 1,
                    idusuario: 213412,
                    idpais: this.paises1,
                    iddepartamento: this.departamento2,
                    idciudad: this.cuidades2,
                    idactividades: this.actividades2,
                    idhotel: this.hoteles2,
                    idmodotransporte: this.modoDeTransporte,
                    idtransporte: this.transportes1,
                    fechaInicio: this.fechaInicio,
                    fechaFinal: this.fechaFinal,
                    monto: this.monto,
                    usuarioRegistra: 1,
                };

                const request = await axios({
                    method: "POST",
                    url: this.BASE_URL_AXIOS + "savePaquete",
                    data: newPaqueteEstandar,
                    headers: {
                        "Content-Type": "application/json",
                    },
                })

                var arreglo = request.data.split("|");

                if (arreglo[0] == "OK") {
                    this.valorAlerta = arreglo[1];
                    this.showAlert = true;
                    setTimeout(() => {
                        location.reload();
                    }, 1000);

                } else {
                    this.valorAlerta = arreglo[1];
                    this.showAlert = true;
                }
            }
        },
        hideAlert() {
            this.showAlert = false;
        },
    },
};
</script>
