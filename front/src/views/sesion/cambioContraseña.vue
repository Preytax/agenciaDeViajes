<template>
    <!-- Body Wrapper-->
    <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
        <div class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
            <div class="d-flex align-items-center justify-content-center w-100">
                <div class="row justify-content-center w-100">
                    <div class="col-md-8 col-lg-6 col-xxl-3">
                        <div v-show="alerta_ayuda" :class="modoAlerta === 2 ? 'alert-danger' : 'alert-success'" class="alert" role="alert">
                            {{valorAlerta}}
                        </div>
                        <div class="card mb-0">
                            <div class="card-body">
                                <a href="#" class="text-nowrap logo-img text-center d-block py-3 w-100">
                                    <img src="@/assets/images/logos/dark-logo.svg" width="180" alt="">
                                </a>
                                <p class="test-center">Your Social Campaigns</p>
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Escribir la nueva contraseña</label>
                                    <input v-model="password" type="password" class="form-control" :maxlength="10" id="exampleInputEmail1">
                                </div>
                                <button class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Guardar Nueva Contraseña</button>
                                <div v-show="alerta_campos" class="alert alert-warning" role="alert">
                                    Complete los campos
                                  </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { next } from '@/assets/libs/bootstrap/js/dist/dom/selector-engine';
/**import CryptoJS from 'crypto-js';**/

export default {
    beforRouteEnter() {
        next('/home')
    },
    inject: ['BASE_URL_AXIOS', 'BASE_URL'],
    data() {
        return {
            password: "",
            recordarCuenta: false,
            alerta_campos: false,
        }
    },
    mounted() {
        if(localStorage.getItem('hash') && localStorage.getItem('besh') ){
            this.recordarCuenta = true
            this.password = "**-*-*-*-*";
        }
    },
    methods: {

    }
}
</script>