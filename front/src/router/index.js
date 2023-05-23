import { createRouter, createWebHistory } from 'vue-router'
//import HomeView from '../views/HomeView.vue'
import AddOperador from '@/views/operador/AddOperador.vue'
import GetOperadores from '@/views/operador/GetOperadores.vue'
import CreatePaquetes from '@/views/paquetespersonalizados/CreatePaquetes.vue'
import GetPaquetes from '@/views/paquetespersonalizados/GetPaquetes.vue'
import sesion from '@/views/sesion/login-register.vue'
import Login from '@/views/sesion/LogIn.vue'
import Register from '@/views/sesion/RegisterIn.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'home',
    component: sesion,
  },
  {
    path: '/perfil',
    name: 'perfil',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/perfilUser.vue')
  },
  {
    path: '/admin/operador/add',
    name: 'AddOperador',
    component: AddOperador,
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
  },
  {
    path: '/registrarse',
    name: 'register',
    component: Register,
  },
  {
    path: '/admin/operador/get',
    name: 'GetOperador',
    component: GetOperadores,
  },
  {
    path: '/cliente/addPaquete',
    name: 'CreatePaquetes',
    component: CreatePaquetes,
  },
  {
    path: '/cliente/getPaquete',
    name: 'GetPaquetes',
    component: GetPaquetes,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router