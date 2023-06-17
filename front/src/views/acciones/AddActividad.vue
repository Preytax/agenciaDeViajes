<template>
    <inc_head/>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="body-wrapper">
        <div class="pt-0 container-fluid" data-bd-theme="dark">
            <div class="card">
                <div class="card-body">
                    <h2 class="mb-4" _msttexthash="318188" _msthash="6">{{ title }}</h2>
                    <div class="row g-3">
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir País</label>
                            <select v-model="pais" @change="getDepartamentosByIdMultiuserAndIdPais()" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="pais in paises" :key="pais.id" :value="pais.id">
                                    {{ pais.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Elegir Departamento</label>
                            <select v-model="departamento" @change="getCiudadesByIdMultiuserByIdDepartamento()" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="departamento in departamentos" :key="departamento.id"
                                    :value="departamento.id">
                                    {{ departamento.nombre }}
                                </option>
                            </select>
                        </div>
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Seleccione la ciudad</label>
                            <select v-model="ciudad" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="ciudad in ciudades" :key="ciudad.id" :value="ciudad.id">
                                    {{ ciudad.nombre }}
                                </option>
                            </select>
                            <div ref="idCiudad" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                La ciudad es obligatoria.
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre de Actividad</label>
                            <input type="text" class="form-control" id="nombreActividad" placeholder="" maxlength="45" v-model="nombreActividad" required/>
                            <div ref="nombreActividad" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                El nombre de la actividad es obligatoria.
                            </div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <a class="w-100 btn btn-primary btn-lg" @click="addActividad()" href="#">Registrar</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import inc_head from "../Inc/inc_head";
var axios = require('axios');
var error = 0;


export default{
    beforeRouteEnter(to, from, next) {
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
            // Redirigir a la página de inicio de sesión
            next('/login');
        } else if(localStorage.getItem('id_perfil') != 2 && localStorage.getItem('id_perfil') != 4){
            next('/home');
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
            title: 'Registrar Actividades',
            id: localStorage.getItem('id'),
            idPerfil: null,
            idMultiuser: localStorage.getItem('id_multiuser'),
            paises: "",
            pais: "",
            departamentos: "",
            departamento: "",
            ciudades: "",
            ciudad: "",
            showAlert: false,
            nombreActividad: ""
        }
    },
    mounted: async function () {
        const responsePais = await axios.get(this.BASE_URL_AXIOS +"getPaises/" + this.idMultiuser);
        this.paises = responsePais.data;
    },
    methods: {
        async getDepartamentosByIdMultiuserAndIdPais() {
            const responseDepartamento = await axios.get(this.BASE_URL_AXIOS + "getDepartamentosByIdMultiuserAndIdPais/" + this.idMultiuser + "/" + this.pais);
            this.departamentos = responseDepartamento.data;
        },
        async getCiudadesByIdMultiuserByIdDepartamento() {
            const responseCiudades = await axios.get(this.BASE_URL_AXIOS + "getCiudadesByIdMultiuserAndIdDepartamento/" + this.idMultiuser + "/" + this.departamento);
            this.ciudades = responseCiudades.data;
        },

        async addActividad(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });
           
            if (this.nombreActividad == null || this.nombreActividad == "") {
                this.$refs.nombreActividad.classList.add("mostrarObligatorio");
                error = 1;
            }

            if(error == 0){
                const newCiudad = {
                    nombre          : this.nombreActividad,
                    usuarioRegistra : this.id,
                    idMultiuser     : this.idMultiuser,
                    idCiudad        : this.ciudad
                };

                const request = await axios({
                    method: "POST",
                    url: this.BASE_URL_AXIOS + "saveActividad",
                    data: newCiudad,
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
            }
        },
        hideAlert() {
            this.showAlert = false;
        }
    }
}
</script>