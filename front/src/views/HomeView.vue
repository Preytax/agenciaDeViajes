<template>
  <inc_head/>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import inc_head from "../Inc/inc_head";
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  beforeRouteEnter(to, from, next) {
      // Verificar si la variable de sesión existe
      if (!localStorage.getItem('id')) {
      // Redirigir a la página de inicio de sesión
      next('/login');
      } else {
      next();
      }
  },
  name: 'HomeView',
  components: {
    HelloWorld,
    inc_head
  }
}
</script>
