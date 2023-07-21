<template>
    <inc_head/>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="body-wrapper">
        <div class="pt-0 container-fluid" data-bd-theme="dark">
            <div class="card">
                <div class="card-body">
                    <h2 class="mb-4" _msttexthash="318188" _msthash="6">{{ title }}</h2>
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Seleccione el Departamento</label>
                            <select v-model="departamento" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="departamento in departamentos" :key="departamento.id" :value="departamento.id">
                                    {{ departamento.nombre }}
                                </option>
                            </select>
                            <div ref="idDepartamento" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                El departamento es obligatorio.
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre de Ciudad</label>
                            <input type="text" class="form-control" id="nombreCiudad" placeholder="" maxlength="45" v-model="nombreCiudad" required/>
                            <div ref="nombreCiudad" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                El nombre de la ciudad es obligatorio.
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Latitud de Ciudad</label>
                            <input type="text" class="form-control" id="nombreCiudad" placeholder="" maxlength="45" v-model="nombreCiudad" required/>
                            <div ref="nombreCiudad" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                La latitud es obligatoria.
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Longitud de Ciudad</label>
                            <input type="text" class="form-control" id="nombreCiudad" placeholder="" maxlength="45" v-model="nombreCiudad" required/>
                            <div ref="nombreCiudad" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                La longitud es obligatorio.
                            </div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <a class="w-100 btn btn-primary btn-lg" @click="addCiudad()" href="#">Registrar</a>
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
    /* beforeRouteEnter(to, from, next) {
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
            // Redirigir a la página de inicio de sesión
            next('/login');
        } else if(localStorage.getItem('id_perfil') != 2 && localStorage.getItem('id_perfil') != 4){
            next('/home');
        } else {
            next();
        }
    }, */
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    components: {
        inc_head,
    },
    data(){
        return {
            title: 'Registrar Ciudad',
            id: localStorage.getItem('id'),
            idPerfil: null,
            idMultiuser: localStorage.getItem('id_multiuser'),
            departamentos: "",
            departamento: "",
            showAlert: false,
            nombreCiudad: ""
        }
    },
    mounted: async function () {
        this.getDepartamentos()
    },
    methods: {
        async getDepartamentos() {
            const responseDepartamento = await axios.get(this.BASE_URL_AXIOS + "getDepartamentosByIdMultiuser/" + this.idMultiuser);
            this.departamentos = responseDepartamento.data;
        },

        async addCiudad(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });
           
            if (this.nombreCiudad == null || this.nombreCiudad == "") {
                this.$refs.nombreCiudad.classList.add("mostrarObligatorio");
                error = 1;
            }

            if(error == 0){
                const newCiudad = {
                    nombre          : this.nombreCiudad,
                    usuarioRegistra : this.id,
                    idMultiuser     : this.idMultiuser,
                    idDepartamento  : this.departamento
                };

                const request = await axios({
                    method: "POST",
                    url: this.BASE_URL_AXIOS + "saveCiudad",
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