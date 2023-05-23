<script>
  export default {
    data() {
      return {
        title: 'Operadores',
        url: window.location.href,
      };
    },
    mounted() {
      this.url = this.url.slice(this.url.lastIndexOf('/') + 1);
    },
  };
</script>
<template>
  <nav class="container">
    <ul class="nav nav-pills nav-fill gap-2 p-1 small bg-primary rounded-5 shadow-sm" id="pillNav2" role="tablist" 
      style="--bs-nav-link-color: var(--bs-white); --bs-nav-pills-link-active-color: var(--bs-primary); --bs-nav-pills-link-active-bg: var(--bs-white);">
      <li class="nav-item" role="presentation">
        <router-link to="/">
          <button :class="{ 'active': url === ''}" class="nav-link rounded-5" id="home-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="true">
            Home
          </button>
        </router-link>
      </li>
      <!--
      <li class="nav-item" role="presentation">
        <router-link to="/about">
          <button :class="{ 'active': url === 'about'}" class="nav-link rounded-5" id="profile-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
            About
          </button>
        </router-link>
      </li>
      -->
      <li class="nav-item" role="presentation">
        <router-link to="/admin/operador/add">
          <button :class="{ 'active': url === 'add'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
            Registrar Operador
          </button>
        </router-link>
      </li>
      <li class="nav-item" role="presentation">
        <router-link to="/admin/operador/get">
          <button :class="{ 'active': url === 'get'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
            Listar Personas
          </button>
        </router-link>
      </li>
      <li class="nav-item" role="presentation">
        <router-link to="/cliente/addPaquete">
          <button :class="{ 'active': url === 'addPaquete'}" class="nav-link rounded-5" id="contact-tab2" data-bs-toggle="tab" type="button" role="tab" aria-selected="false">
            Crear Paquetes Personalizados
          </button>
        </router-link>
      </li>
    </ul>
  </nav>
  <router-view/>
</template>

<style>
@import './assets/css/styles.min.css';
body {
  font: HelveticaNeue;
    /*font-family: var(--font-family);*/
} 

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: white;
  text-decoration:none;
}

</style>
