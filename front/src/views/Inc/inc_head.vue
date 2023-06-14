<template>
  <div>
    <!-- Sidebar Start -->
    <aside class="left-sidebar">
      <!-- Sidebar scroll-->
      <div>
        <div class="brand-logo d-flex align-items-center justify-content-between">
          <a href="./index.html" class="text-nowrap logo-img">
            <img src="@/assets/images/logos/dark-logo.svg" width="180" alt="" />
          </a>
          <div class="close-btn d-xl-none d-block sidebartoggler cursor-pointer" id="sidebarCollapse">
            <i class="ti ti-x fs-8"></i>
          </div>
        </div>
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav scroll-sidebar" data-simplebar="">
          <ul id="sidebarnav">
            <li class="nav-small-cap">
              <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span class="hide-menu">Home</span>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link"  :href="`${BASE_URL}HomeOperador`" aria-expanded="false">
                <span>
                  <i class="ti ti-layout-dashboard"></i>
                </span>
                <span class="hide-menu">Home</span>
              </a>
            </li>
            <template v-if="id_perfil == 1 || id_perfil == 2 || id_perfil == 4">
              <li class="nav-small-cap">
                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                <span class="hide-menu">Configuracion</span>
              </li>
              <template v-if="id_perfil == 1 || id_perfil == 4">
                <li class="sidebar-item">
                  <a class="sidebar-link" :href="`${BASE_URL}operador/add`" aria-expanded="false">
                    <span>
                      <i class="ti ti-layout-dashboard"></i>
                    </span>
                    <span class="hide-menu">Operadores</span>
                  </a>
                </li>
              </template>
              <template v-if="id_perfil == 2 || id_perfil == 4">
                <li class="sidebar-item">
                  <a class="sidebar-link" :href="`${BASE_URL}cliente/gett`" aria-expanded="false">
                    <span>
                      <i class="ti ti-layout-dashboard"></i>
                    </span>
                    <span class="hide-menu">Clientes</span>
                  </a>
                </li>
              </template>
              <template v-if="id_perfil == 2  || id_perfil == 4">
                <li class="sidebar-item">
                  <a class="sidebar-link" :href="`${BASE_URL}paquete/addEstandar`" aria-expanded="false">
                    <span>
                      <i class="ti ti-layout-dashboard"></i>
                    </span>
                    <span class="hide-menu">Paquetes</span>
                  </a>
                </li>
              </template>
            </template>
            
            <!--<li class="nav-small-cap">
              <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span class="hide-menu">UI COMPONENTS</span>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-buttons.html" aria-expanded="false">
                <span>
                  <i class="ti ti-article"></i>
                </span>
                <span class="hide-menu">Buttons</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-alerts.html" aria-expanded="false">
                <span>
                  <i class="ti ti-alert-circle"></i>
                </span>
                <span class="hide-menu">Alerts</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-card.html" aria-expanded="false">
                <span>
                  <i class="ti ti-cards"></i>
                </span>
                <span class="hide-menu">Card</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-forms.html" aria-expanded="false">
                <span>
                  <i class="ti ti-file-description"></i>
                </span>
                <span class="hide-menu">Forms</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-typography.html" aria-expanded="false">
                <span>
                  <i class="ti ti-typography"></i>
                </span>
                <span class="hide-menu">Typography</span>
              </a>
            </li>
            <li class="nav-small-cap">
              <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span class="hide-menu">AUTH</span>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" :href="`${BASE_URL}login`" aria-expanded="false">
                <span>
                  <i class="ti ti-login"></i>
                </span>
                <span class="hide-menu">Login</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" :href="`${BASE_URL}registrarse`" aria-expanded="false">
                <span>
                  <i class="ti ti-user-plus"></i>
                </span>
                <span class="hide-menu">Register</span>
              </a>
            </li>
            <li class="nav-small-cap">
              <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span class="hide-menu">EXTRA</span>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./icon-tabler.html" aria-expanded="false">
                <span>
                  <i class="ti ti-mood-happy"></i>
                </span>
                <span class="hide-menu">Icons</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./sample-page.html" aria-expanded="false">
                <span>
                  <i class="ti ti-aperture"></i>
                </span>
                <span class="hide-menu">Sample Page</span>
              </a>
            </li>-->
          </ul>
          <!--<div class="unlimited-access hide-menu bg-light-primary position-relative mb-7 mt-5 rounded">
            <div class="d-flex">
              <div class="unlimited-access-title me-3">
                <h6 class="fw-semibold fs-4 mb-6 text-dark w-85">Upgrade to pro</h6>
                <a href="https://adminmart.com/product/modernize-bootstrap-5-admin-template/" target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">Buy Pro</a>
              </div>
              <div class="unlimited-access-img">
                <img src="@/assets/images/backgrounds/rocket.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>-->
        </nav>
        <!-- End Sidebar navigation -->
      </div>
      <!-- End Sidebar scroll-->
    </aside>
    <!--  Sidebar End -->
    <!--  Main wrapper -->
    <div class="body-wrapper">
      <!--  Header Start -->
      <header class="app-header">
        <nav class="navbar navbar-expand-lg navbar-light">
          <ul class="navbar-nav">
            <li class="nav-item d-block d-xl-none">
              <a class="nav-link sidebartoggler nav-icon-hover" id="headerCollapse" href="javascript:void(0)">
                <i class="ti ti-menu-2"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link nav-icon-hover" href="javascript:void(0)">
                <i class="ti ti-bell-ringing"></i>
                <div class="notification bg-primary rounded-circle"></div>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link nav-icon-hover"  :href="`${BASE_URL}helpChat`">
                <i class="bi bi-whatsapp"></i>
                <div class="notification bg-primary rounded-circle"></div>
              </a>
            </li>
          </ul>
          <div class="navbar-collapse justify-content-end px-0" id="navbarNav">
            <ul class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
              <!--<a href="https://adminmart.com/product/modernize-free-bootstrap-admin-dashboard/" target="_blank" class="btn btn-primary">Download Free</a>-->
              <span>{{ correo }}</span>
              <li class="nav-item dropdown">
                <a class="nav-link nav-icon-hover" href="#" id="drop2" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  <img src="@/assets/images/profile/user-1.jpg" alt="" width="35" height="35" class="rounded-circle">
                </a>
                <div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
                  <div class="message-body">
                    <a href="/perfil" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-user fs-6"></i>
                      <p class="mb-0 fs-6">Mi Cuenta</p>
                    </a>
                    <a @click="mostrarEdit()" href="#" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="bi bi-pencil-square fs-6" style="width: 20px;"></i>
                      <p class="mb-0 fs-6">Editar</p>
                    </a>
                    <!--<a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-mail fs-6"></i>
                      <p class="mb-0 fs-6">My Account</p>
                    </a>-->
                    <a href="#" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-list-check fs-6"></i>
                      <p class="mb-0 fs-6">My Task</p>
                    </a>
                    <a @click="singOut()" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!--  Header End -->
      <div class="container-fluid">
        <div style="border: 0;" v-show="urlRouter != 'HomeOperador' && urlRouter != 'perfil'" class="card">
          <ul class="nav nav-pills nav-fill gap-2 p-1 small bg-primary rounded-5 shadow-sm" id="pillNav2" role="tablist" 
            style="--bs-nav-link-color: var(--bs-white); --bs-nav-pills-link-active-color: var(--bs-primary); --bs-nav-pills-link-active-bg: var(--bs-white);">
            <!--
            <li class="nav-item" role="presentation">
              <router-link to="/about">
                <button :class="{ 'active': url === 'about'}" class="nav-link rounded-5" id="profile-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
                  About.
                </button>
              </router-link>
            </li>
            -->
            <template v-if="id_perfil == 1 || id_perfil == 4">
              <template v-if="urlRouter == 'operador'">
                <li class="nav-item" role="presentation">
                  <router-link to="/operador/add">
                    <button :class="{ 'active': urlEvento === 'add'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
                      Registrar Operador
                    </button>
                  </router-link>
                </li>
                <li class="nav-item" role="presentation">
                  <router-link to="/operador/get">
                    <button :class="{ 'active': urlEvento === 'get'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
                      Usuarios Registrados
                    </button>
                  </router-link>
                </li>
              </template>
            </template>
            <template v-if="id_perfil == 2 || id_perfil == 4">
              <template v-if="urlRouter == 'paquete'">
                <li class="nav-item" role="presentation">
                  <router-link to="/paquete/addEstandar">
                    <button :class="{ 'active': urlEvento === 'addEstandar'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
                      Crear Paquetes Estandar
                    </button>
                  </router-link>
                </li>
              </template>
              <template v-if="urlRouter == 'cliente'">
                <li class="nav-item" role="presentation">
                  <router-link to="/cliente/gett">
                    <button :class="{ 'active': urlEvento === 'gett'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
                      Clientes Registrados
                    </button>
                  </router-link>
                </li>
              </template>
            </template>
            <template v-else-if="id_perfil == 3">
              <li class="nav-item" role="presentation">
                <router-link to="/home">
                  <button :class="{ 'active': urlEvento === 'Home'}" class="nav-link rounded-5" id="home-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="true">
                    Home
                  </button>
                </router-link>
              </li>
              <li class="nav-item" role="presentation">
                <router-link to="/paquete/add">
                  <button :class="{ 'active': urlEvento === 'addPaquete'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
                    Crear Paquetes Personalizados
                  </button>
                </router-link>
              </li>
            </template>
          </ul>
        </div>
      </div>
    </div>
    <inc_editarInfo ref="ref_incEditarInfo"/>
    <router-view/>
  </div>  
</template>

<script>
import inc_editarInfo from "./inc_editarInfo";
/* eslint-disable */
import $ from 'jquery';
/* eslint-enable */


export default {
  inject: ['BASE_URL'],
  name: "inc_head",
  components:{
    inc_editarInfo
  },
  data() {
    return {
      id_perfil: localStorage.getItem('id_perfil'),
      correo: localStorage.getItem('correo'),
      title: 'Operadores',
      url: window.location.href,
      urlRouter: "",
      urlEvento: ""
    };
  },
  methods: {
    async singOut(){
      localStorage.removeItem('id');
      localStorage.removeItem('id_perfil');
      localStorage.removeItem('nombres');
      localStorage.removeItem('apellido_paterno');
      localStorage.removeItem('apellido_materno');
      localStorage.removeItem('correo');
      localStorage.removeItem('dni');
      window.location.href = this.BASE_URL;
    },
    mostrarEdit(){
      this.$refs.ref_incEditarInfo.mostrarEdit();
      this.$refs.ref_incEditarInfo.getPersona();
    },
  },
  mounted() {
    this.urlRouter = this.$route.path.split("/")[1];
    this.urlEvento = this.url.slice(this.url.lastIndexOf('/') + 1);
    // Admin Panel settings

    //****************************
    /* This is for the mini-sidebar if width is less than 1170*/
    //****************************
    var setsidebartype = function () {
      var width =
        window.innerWidth > 0 ? window.innerWidth : this.screen.width;
      if (width < 1199) {
        $("#main-wrapper").attr("data-sidebartype", "mini-sidebar");
        $("#main-wrapper").addClass("mini-sidebar");
      } else {
        $("#main-wrapper").attr("data-sidebartype", "full");
        $("#main-wrapper").removeClass("mini-sidebar");
      }
    };
    $(window).ready(setsidebartype);
    $(window).on("resize", setsidebartype);
    //****************************
    /* This is for sidebartoggler*/
    //****************************
    $(".sidebartoggler").on("click", function () {
      $("#main-wrapper").toggleClass("mini-sidebar");
      if ($("#main-wrapper").hasClass("mini-sidebar")) {
        $(".sidebartoggler").prop("checked", true);
        $("#main-wrapper").attr("data-sidebartype", "mini-sidebar");
      } else {
        $(".sidebartoggler").prop("checked", false);
        $("#main-wrapper").attr("data-sidebartype", "full");
      }
    });
    $(".sidebartoggler").on("click", function () {
      $("#main-wrapper").toggleClass("show-sidebar");
    });
  }
};

</script>

<style>

body {
  font-family: Helvetica Neue,Helvetica,Arial,sans-serif; 
} 

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.nav-item {
  text-decoration: none;
}

nav
{
  padding: 30px;
}

nav a 
{
  font-weight: bold;
  color: white;
  text-decoration:none;
}
</style>
