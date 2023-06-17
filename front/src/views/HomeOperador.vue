<template>
  <inc_head/>
  <div>
    HOME
  </div>
</template>

<script>
import inc_head from "./Inc/inc_head";

export default {
  beforeRouteEnter(to, from, next) {
    // Verificar si la variable de sesión existe
    if (!localStorage.getItem('id')) {
          // Redirigir a la página de inicio de sesión
          next('/login');
      } else if(localStorage.getItem('id_perfil') != 1 && localStorage.getItem('id_perfil') != 2 && localStorage.getItem('id_perfil') != 4){
          next('/home');
      } else {
          next();
      }
  },
  name: 'HomeOperador',
  components: {
    inc_head
  }
}
</script>
