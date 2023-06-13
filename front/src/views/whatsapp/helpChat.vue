<template>
    <inc_head/>
    <div class="body-wrapper">
        <div class="pt-0 container-fluid">
            <div class="card">
                <div class="card-body" id="chat3" style="border-radius: 15px;">
                    <section style="background-color: #CDC4F9;">
                        <div class="container py-5">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card" id="chat3" style="border-radius: 15px;">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-6 col-lg-5 col-xl-4 mb-4 mb-md-0">
                                                    <div class="p-3">
                                                        <div class="input-group rounded mb-3">
                                                            <input type="search" class="form-control rounded" placeholder="Buscar" aria-label="Search"
                                                            aria-describedby="search-addon" />
                                                            <span class="input-group-text border-0" id="search-addon">
                                                                <i class="bi bi-search"></i>
                                                            </span>
                                                        </div>
                                                        <div class="ps" data-mdb-perfect-scrollbar="true" style="position: relative; height: 400px; margin-left: 5px">
                                                            <ul class="list-unstyled mb-0">
                                                                <li v-for="chat in chats" :key="chat.correo" class="p-2 border-bottom">
                                                                    <a href="#" @click="showOpenChat(chat.numero)" class="d-flex justify-content-between">
                                                                    <div class="d-flex flex-row">
                                                                        <div>
                                                                        <img
                                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                                                            alt="avatar" class="d-flex align-self-center me-3" width="60">
                                                                        <span class="badge bg-success badge-dot"></span>
                                                                        </div>
                                                                        <div class="pt-1" style="text-align: initial;">
                                                                        <p class="small text-muted mb-1">{{ chat.fecha }}</p>
                                                                        <p class="fw-bold mb-0">{{ chat.nombre }}</p>
                                                                        <p class="small text-muted" v-html="replaceTT(chat.mensaje, 2)"></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="pt-1">
                                                                        <!--<span class="badge bg-danger rounded-pill float-end">3</span>-->
                                                                    </div>
                                                                    </a>
                                                                </li>
                                                                <!--<li class="p-2 border-bottom">
                                                                    <a href="#!" class="d-flex justify-content-between">
                                                                    <div class="d-flex flex-row">
                                                                        <div>
                                                                        <img
                                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                                                                            alt="avatar" class="d-flex align-self-center me-3" width="60">
                                                                        <span class="badge bg-warning badge-dot"></span>
                                                                        </div>
                                                                        <div class="pt-1">
                                                                        <p class="fw-bold mb-0">Alexa Chung</p>
                                                                        <p class="small text-muted">Lorem ipsum dolor sit.</p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="pt-1">
                                                                        <p class="small text-muted mb-1">5 mins ago</p>
                                                                        <span class="badge bg-danger rounded-pill float-end">2</span>
                                                                    </div>
                                                                    </a>
                                                                </li>
                                                                <li class="p-2 border-bottom">
                                                                    <a href="#!" class="d-flex justify-content-between">
                                                                    <div class="d-flex flex-row">
                                                                        <div>
                                                                        <img
                                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3-bg.webp"
                                                                            alt="avatar" class="d-flex align-self-center me-3" width="60">
                                                                        <span class="badge bg-success badge-dot"></span>
                                                                        </div>
                                                                        <div class="pt-1">
                                                                        <p class="fw-bold mb-0">Danny McChain</p>
                                                                        <p class="small text-muted">Lorem ipsum dolor sit.</p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="pt-1">
                                                                        <p class="small text-muted mb-1">Yesterday</p>
                                                                    </div>
                                                                    </a>
                                                                </li>
                                                                <li class="p-2 border-bottom">
                                                                    <a href="#!" class="d-flex justify-content-between">
                                                                    <div class="d-flex flex-row">
                                                                        <div>
                                                                        <img
                                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava4-bg.webp"
                                                                            alt="avatar" class="d-flex align-self-center me-3" width="60">
                                                                        <span class="badge bg-danger badge-dot"></span>
                                                                        </div>
                                                                        <div class="pt-1">
                                                                        <p class="fw-bold mb-0">Ashley Olsen</p>
                                                                        <p class="small text-muted">Lorem ipsum dolor sit.</p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="pt-1">
                                                                        <p class="small text-muted mb-1">Yesterday</p>
                                                                    </div>
                                                                    </a>
                                                                </li>
                                                                <li class="p-2 border-bottom">
                                                                    <a href="#!" class="d-flex justify-content-between">
                                                                    <div class="d-flex flex-row">
                                                                        <div>
                                                                        <img
                                                                            src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava5-bg.webp"
                                                                            alt="avatar" class="d-flex align-self-center me-3" width="60">
                                                                        <span class="badge bg-warning badge-dot"></span>
                                                                        </div>
                                                                        <div class="pt-1">
                                                                        <p class="fw-bold mb-0">Kate Moss</p>
                                                                        <p class="small text-muted">Lorem ipsum dolor sit.</p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="pt-1">
                                                                        <p class="small text-muted mb-1">Yesterday</p>
                                                                    </div>
                                                                    </a>
                                                                </li>
                                                                <li class="p-2">
                                                                    <a href="#!" class="d-flex justify-content-between">
                                                                    <div class="d-flex flex-row">
                                                                        <div>
                                                                            <img
                                                                                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                                                                                alt="avatar" class="d-flex align-self-center me-3" width="60">
                                                                            <span class="badge bg-success badge-dot"></span>
                                                                            </div>
                                                                            <div class="pt-1">
                                                                            <p class="fw-bold mb-0">Ben Smith</p>
                                                                            <p class="small text-muted">Lorem ipsum dolor sit.</p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="pt-1">
                                                                        <p class="small text-muted mb-1">Yesterday</p>
                                                                    </div>
                                                                    </a>
                                                                </li>-->
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>

                                                <template v-if="openChat">
                                                    <div class="col-md-6 col-lg-7 col-xl-8">
                                                        <div ref="scrollContainer" class="pt-3 pe-3 ps" data-mdb-perfect-scrollbar="true" style="position: relative; height: 400px">
                                                            <template v-for="mensaje in mensajes" :key="mensaje.id">
                                                                <template v-if="mensaje.tipo == 2">
                                                                    <div class="d-flex flex-row justify-content-start">
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                                                        alt="avatar 1" style="width: 45px; height: 100%;">
                                                                        <div>
                                                                            <p class="small p-2 ms-3 mb-1 rounded-3" style="max-width: 300px; text-align: initial; background-color: #f5f6f7;" v-html="replaceTT(mensaje.mensaje)"></p>
                                                                            <p class="small ms-3 mb-3 rounded-3 text-muted" style="text-align: initial;">{{mensaje.fecha}}</p>
                                                                        </div>
                                                                    </div>
                                                                </template>
                                                                <template v-else>
                                                                    <div class="d-flex flex-row justify-content-end">
                                                                        <div>
                                                                            <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary" style="max-width: 300px; text-align: initial;" v-html="replaceTT(mensaje.mensaje)"></p>
                                                                            <p class="small me-3 mb-3 rounded-3 text-muted float-end">{{ mensaje.fecha }}</p>
                                                                        </div>
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                                                                        alt="avatar 1" style="width: 45px; height: 100%;">
                                                                    </div>
                                                                </template>
                                                            </template>

                                                            <!--<div class="d-flex flex-row justify-content-end">
                                                                <div>
                                                                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">Ut enim ad minim veniam,
                                                                    quis
                                                                    nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                                                <p class="small me-3 mb-3 rounded-3 text-muted">12:00 PM | Aug 13</p>
                                                                </div>
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                            </div>

                                                            <div class="d-flex flex-row justify-content-start">
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                                <div>
                                                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">Duis aute
                                                                    irure
                                                                    dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                                                </p>
                                                                <p class="small ms-3 mb-3 rounded-3 text-muted float-end">12:00 PM | Aug 13</p>
                                                                </div>
                                                            </div>

                                                            <div class="d-flex flex-row justify-content-end">
                                                                <div>
                                                                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">Excepteur sint occaecat
                                                                    cupidatat
                                                                    non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                                                <p class="small me-3 mb-3 rounded-3 text-muted">12:00 PM | Aug 13</p>
                                                                </div>
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                            </div>

                                                            <div class="d-flex flex-row justify-content-start">
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                                <div>
                                                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">Sed ut
                                                                    perspiciatis
                                                                    unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam
                                                                    rem
                                                                    aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
                                                                    dicta
                                                                    sunt explicabo.</p>
                                                                <p class="small ms-3 mb-3 rounded-3 text-muted float-end">12:00 PM | Aug 13</p>
                                                                </div>
                                                            </div>

                                                            <div class="d-flex flex-row justify-content-end">
                                                                <div>
                                                                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">Nemo enim ipsam
                                                                    voluptatem quia
                                                                    voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
                                                                    qui
                                                                    ratione voluptatem sequi nesciunt.</p>
                                                                <p class="small me-3 mb-3 rounded-3 text-muted">12:00 PM | Aug 13</p>
                                                                </div>
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                            </div>

                                                            <div class="d-flex flex-row justify-content-start">
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                                <div>
                                                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">Neque porro
                                                                    quisquam
                                                                    est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non
                                                                    numquam
                                                                    eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.</p>
                                                                <p class="small ms-3 mb-3 rounded-3 text-muted float-end">12:00 PM | Aug 13</p>
                                                                </div>
                                                            </div>

                                                            <div class="d-flex flex-row justify-content-end">
                                                                <div>
                                                                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">Ut enim ad minima veniam,
                                                                    quis
                                                                    nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
                                                                    commodi
                                                                    consequatur?</p>
                                                                <p class="small me-3 mb-3 rounded-3 text-muted">12:00 PM | Aug 13</p>
                                                                </div>
                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                                                alt="avatar 1" style="width: 45px; height: 100%;">
                                                            </div>-->
                                                        </div>

                                                        <div class="text-muted d-flex justify-content-start align-items-center pe-3 pt-3 mt-2">
                                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                                                                alt="avatar 3" style="width: 40px; height: 100%;">
                                                            <textarea v-model="mensajeNuevo" style="resize: none;height: 45px;" class="form-control form-control-lg" id="exampleFormControlInput2"
                                                                placeholder="Escribe..."></textarea>
                                                            <span class="btnEnvio input-group-text border-0" id="search-addon" @click="envioMensaje()">
                                                                <span v-show="spinner" class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                                                <i class="bi bi-send-plus-fill"></i>
                                                            </span>
                                                            <a class="ms-1 text-muted" href="#!"><i class="fas fa-paperclip"></i></a>
                                                            <a class="ms-3 text-muted" href="#!"><i class="fas fa-smile"></i></a>
                                                            <a class="ms-3" href="#!"><i class="fas fa-paper-plane"></i></a>
                                                        </div>
                                                    </div>
                                                </template>
                                                <template v-else>
                                                    <div class="col-md-6 col-lg-7 col-xl-8">
                                                        <div class="centradoVH pt-3 pe-3 ps" data-mdb-perfect-scrollbar="true" style="position: relative; height: 400px">
                                                            <p>Selecciona un chat</p>
                                                        </div>
                                                    </div>
                                                </template>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  
import inc_head from "../Inc/inc_head";
import axios from 'axios';

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
            chats: [],
            mensajes: [],
            openChat: false,
            maxLength: 10,
            mensajeNuevo : "",
            numeroHelp: "",
            nombreHelp: "",
            spinner: false
        }
    },
    mounted: async function(){
        this.CargarChats();
        setInterval(() => {
            this.CargarChats();

            if(this.numeroHelp != ""){
                this.showOpenChat(this.numeroHelp);
            }
        }, 2000);
    },
    methods: {
        async envioMensaje(){
            if(this.mensajeNuevo != "")
            {
                this.spinner = true;

                const newChat = {
                    is_usuario  : localStorage.getItem('id'),
                    nombre  : this.nombreHelp,
                    mensaje : this.mensajeNuevo,
                    numero  : this.numeroHelp

                };
                await axios({
                    method: "POST",
                    url: this.BASE_URL_AXIOS + "sendMessage",
                    data: newChat,
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                this.mensajeNuevo = "";
                this.CargarChats();
                this.CargarMensajes(this.numeroHelp);
                this.scrollToBottom();
                this.spinner = false;
            }
        },
        replaceTT(text, tipo) {
            if (text.length > this.maxLength && tipo == 2) {
                return text.slice(0, this.maxLength) + '...';
            }
            text = text.replace(/\n/g, '<br>');
            text = text.replace(/\*(.*?)\*/g, '<strong>$1</strong>');
            return text;
        },
        async CargarChats(){
            const responseChats = await axios.get( this.BASE_URL_AXIOS + 'getChats');

            // Ordenar los mensajes por fecha
            this.chats = responseChats.data.sort((a, b) => {
                return new Date(a.fecha) + new Date(b.fecha);
            });
        },
        async CargarMensajes(numero){
            const responseMensajes = await axios.get( this.BASE_URL_AXIOS + 'getMensajes/'+numero);
            this.nombreHelp = responseMensajes.data[0].nombre
            
            // Ordenar los mensajes por fecha
            this.mensajes = responseMensajes.data.sort((a, b) => {
                return new Date(a.fecha) - new Date(b.fecha);
            });

            if(this.numeroHelp != responseMensajes.data[0].numero){
                this.scrollToBottom();
            }
            this.numeroHelp = responseMensajes.data[0].numero
            
        },
        showOpenChat(numero){
            this.CargarMensajes(numero);
            this.openChat = true;
        },
        scrollToBottom() {
            setTimeout(() => {
                this.$refs.scrollContainer.scrollTop = this.$refs.scrollContainer.scrollHeight;
            }, 1);
        }
    }
  };
  </script>

<style>
.centradoVH
{
    display: flex;
    justify-content: space-around;
    align-items: center;
}

.btnEnvio
{
    margin-left: 5px;
    height: 45px;
    border-radius: 15px;
    cursor: pointer;
}

.ps {
    --mdb-scrollbar-rail-x-y-transition-opacity-bg: background-color 0.2s linear,opacity 0.2s linear;
    --mdb-scrollbar-z-index: 1035;
    --mdb-scrollbar-rail-x-y-length: 0.9375rem;
    --mdb-scrollbar-rail-x-y-opacity: 0.6;
    --mdb-scrollbar-rail-x-y-hover-opacity: 0.9;
    --mdb-scrollbar-rail-x-y-bg-color: #eee;
    --mdb-scrollbar-rail-x-y-clicking: #999;
    --mdb-scrollbar-rail-x-y-clicking-length: 0.6875rem;
    --mdb-scrollbar-rail-x-transition-height-bg: background-color 0.2s linear,height 0.2s ease-in-out;
    --mdb-scrollbar-rail-y-transition-width-bg: background-color 0.2s linear,width 0.2s ease-in-out;
    --mdb-scrollbar-thumb-x-y-color: #aaa;
    --mdb-scrollbar-thumb-x-y-border-radius: 0.375rem;
    --mdb-scrollbar-thumb-x-y-length: 0.375rem;
    --mdb-scrollbar-thumb-x-y-position-length: 0.125rem;
    overflow-x: hidden;
    overflow-y: scroll;
    overflow-anchor: none;
    touch-action: auto;
}

::-webkit-scrollbar {
    width: 20px;
}

::-webkit-scrollbar-thumb {
    background: #727f8c;
    border-radius: 10px;
}

::-webkit-scrollbar-track {
    box-shadow: inset 0 0 5px grey;
    border-radius: 10px;
}
</style>