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
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Pais:</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                                <option v-for="pais in paises" :key="pais.id" :value="pais.id">
                                    {{ pais.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Departamento</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Ciudad</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                                <option v-for="ciudad in cuidades" :key="ciudad.id" :value="ciudad.id">
                                    {{ ciudad.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Hotel</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                                <option v-for="hotel in hoteles" :key="hotel.id" :value="hotel.id">
                                    {{ hotel.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-12">
                            <label for="inputEmail4" class="form-label">Elegir Activades</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                                <option v-for="actividad in actividades" :key="actividad.id" :value="actividad.id">
                                    {{ actividad.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir el tipo Transporte</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Transporte</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                                <option v-for="transporte in transportes" :key="transporte.id" :value="transporte.id">
                                    {{ transporte.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Fecha de Inicio</label>
                            <input type="date" class="form-control" id="" placeholder="">
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Fecha Final</label>
                            <input type="date" class="form-control" id="" placeholder="">
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Tipo de Moneda</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccionar</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Moto Total</label>
                            <input type="text" class="form-control" id="" placeholder="Ingrese Monto">
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
    components: {
        inc_head
    },
    data() {
        return {
            paises: null,
            departamentos: null,
            cuidades: null,
            actividades: null,
            hoteles: null,
            tipoTranpostes: null,
            transportes: null,
            fechaInicio: null,
            fechaFinal: null,
            showAlert: null,
        };
    },
    mounted: async function () {
        const responsePais = await axios.get("http://localhost:8080/getPaises");
        this.paises = responsePais.data;
        //const responseDepartamento = await axios.get("http://localhost:8080/getDepartamento");
        //this.departamentos = responseDepartamento.data;
        const responseCuidad = await axios.get("http://localhost:8080/getCiudades");
        this.cuidades = responseCuidad.data;
        const responseActividad = await axios.get("http://localhost:8080/getActividades");
        this.actividades = responseActividad.data;
        const responseHotel = await axios.get("http://localhost:8080/getHoteles");
        this.hoteles = responseHotel.data;
        //const responseTipoTransporte = await axios.get("http://localhost:8080/getTipoTransporte");
        //this.tipoTranpostes = responseTipoTransporte.data;
        const responseTransporte = await axios.get("http://localhost:8080/getTransportes");
        this.transportes = responseTransporte.data;
    },
    props: [],
    methods: {
        async addPaqueteEstandar() {
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });
            if (this.paises == null) {
                this.showAlert = true;
                this.$refs.pais.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.departamentos == null) {
                this.showAlert = true;
                this.$refs.departamentos.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.cuidades == null) {
                this.showAlert = true;
                this.$refs.cuidades.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.actividades == null) {
                this.showAlert = true;
                this.$refs.actividades.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.hoteles == null) {
                this.showAlert = true;
                this.$refs.hoteles.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.tipoTransportes == null) {
                this.showAlert = true;
                this.$refs.tipoTransportes.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (this.transportes == null) {
                this.showAlert = true;
                this.$refs.transportes.classList.add("mostrarObligatorio");
                error = 1;
            }
            if (error != 0) {
                const newPaqueteEstandar = {
                    idpaquete: this.idpaquete,
                    paises: this.paises,
                    //departamentos: this.departamentos,
                    cuidades: this.cuidades,
                    actividades: this.actividades,
                    hoteles: this.hoteles,
                    //tipoTranpostes: this.tipoTranpostes,
                    transportes: this.transportes,
                    fechaInicio: this.fechaInicio,
                    fechaFinal: this.fechaFinal,
                };

                const baseUrl = "http://localhost:8080/";

                const request = await axios({
                    method: "POST",
                    url: baseUrl + "savePaquete",
                    data: newPaqueteEstandar,
                    headers: {
                        "Content-Type": "application/json",
                    },
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
            }
        },
        hideAlert() {
            this.showAlert = false;
        },
    },
};
</script>
