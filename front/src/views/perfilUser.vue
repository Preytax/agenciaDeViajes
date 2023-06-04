<template>
  <inc_head/>
  <a>Este es el perfil</a>
</template>

<script>
import inc_head from "./Inc/inc_head.vue";

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
  methods: {
    inc_head
  },
  mounted() {

  }
};

</script>