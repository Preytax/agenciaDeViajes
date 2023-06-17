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
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Seleccione el Pa&iacute;s</label>
                            <select v-model="pais" class="form-select"
                                aria-label="Default select example">
                                <option value="0" selected>Seleccionar</option>
                                <option v-for="pais in paises" :key="pais.id" :value="pais.id">
                                    {{ pais.nombre }}
                                </option>
                            </select>
                            <div ref="nombresPais" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                El pa&iacute;s es obligatorio.
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre de departamento</label>
                            <input type="text" class="form-control" id="nombresPais" placeholder="" maxlength="45" v-model="nombreDepartamento" required/>
                            <div ref="nombresPais" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                El nombre del departamento es obligatorio.
                            </div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <a class="w-100 btn btn-primary btn-lg" @click="addDepartamento()" href="#">Registrar</a>
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
            title: 'Registrar Departamento',
            id: localStorage.getItem('id'),
            idPerfil: null,
            idMultiuser: localStorage.getItem('id_multiuser'),
            paises: "",
            pais: "",
            showAlert: false,
            nombreDepartamento: ""
        }
    },
    mounted: async function () {
        this.getPaises()
    },
    methods: {
        async getPaises() {
            const responsePais = await axios.get(this.BASE_URL_AXIOS + "getPaises/" + this.idMultiuser);
            this.paises = responsePais.data;
        },

        async addDepartamento(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });
           
            if (this.nombreDepartamento == null || this.nombreDepartamento == "") {
                this.$refs.nombresPais.classList.add("mostrarObligatorio");
                error = 1;
            }

            if(error == 0){
                const newDepartamento = {
                    nombre          : this.nombreDepartamento,
                    idPais          : this.pais,
                    idMultiuser     : this.idMultiuser,
                    usuarioRegistra : this.id
                };

                const request = await axios({
                    method: "POST",
                    url: this.BASE_URL_AXIOS + "saveDepartamento",
                    data: newDepartamento,
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