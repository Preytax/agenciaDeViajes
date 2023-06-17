<template>
    <inc_head/>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <div class="body-wrapper">
        <div class="pt-0 container-fluid" data-bd-theme="dark">
            <div class="card">
                <div class="card-body">
                    <h2 class="mb-4" _msttexthash="318188" _msthash="6">{{ title }}</h2>
                    <div class="row g-3">
                        <div class="col-sm">
                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre de pa&iacute;s</label>
                            <input type="text" class="form-control" id="nombresPais" placeholder="" maxlength="45" v-model="nombrePais" required/>
                            <div ref="nombresPais" class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                El nombre del pa&iacute;s es obligatorio.
                            </div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <a class="w-100 btn btn-primary btn-lg" @click="addPais()" href="#">Registrar</a>
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
        } else if(localStorage.getItem('id_perfil') != 1 && localStorage.getItem('id_perfil') != 4){
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
            title: 'Registrar País',
            id: localStorage.getItem('id'),
            idMultiuser: localStorage.getItem('id_multiuser'),
            idPerfil: null,
            showAlert: false,
            nombrePais: ""
        }
    },
    methods: {
        
        async addPais(){
            Object.keys(this.$refs).forEach((refKey) => {
                const elements = this.$refs[refKey];
                if (!Array.isArray(elements)) {
                    elements.classList.remove("mostrarObligatorio");
                }
            });
           
            if (this.nombrePais == null || this.nombrePais == "") {
                this.$refs.nombresPais.classList.add("mostrarObligatorio");
                error = 1;
            }

            if(error == 0){
                const newPais = {
                    usuarioRegistra  : this.id,
                    idMultiuser  : this.idMultiuser,
                    nombre : this.nombrePais
                };

                const request = await axios({
                    method: "POST",
                    url: this.BASE_URL_AXIOS + "savePais",
                    data: newPais,
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