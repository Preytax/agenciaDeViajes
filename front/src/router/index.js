import { createRouter, createWebHistory } from 'vue-router'
import HomeOperador from '@/views/HomeOperador.vue'
import AddPersona from '@/views/persona/AddPersona.vue'
import GetPersonas from '@/views/persona/GetPersonas.vue'
import GetClientes from '@/views/persona/GetClientes.vue'
import CreatePaquetes from '@/views/paquetes/AddPaquetePersonalizado.vue'
import GetPaquetes from '@/views/paquetes/GetPaquetes.vue'
import sesion from '@/views/HomePrincipal.vue'
import Login from '@/views/sesion/LogIn.vue'
import Register from '@/views/sesion/RegisterIn.vue'
import HelpChat from '@/views/whatsapp/helpChat.vue'
import AddPaqueteEstandar from '@/views/paquetes/AddPaqueteEstandar.vue'

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
    path: '/HomeOperador',
    name: 'HomeOperador',
    component: HomeOperador,
  },
  {
    path: '/perfil',
    name: 'perfil',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/persona/perfilUser.vue')
  },
  {
    path: '/HelpChat',
    name: 'HelpChat',
    component: HelpChat,
  },
  {
    path: '/cliente/gett',
    name: 'GetClientes',
    component: GetClientes,
  },
  {
    path: '/operador/add',
    name: 'AddPersona',
    component: AddPersona,
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
    path: '/operador/get',
    name: 'GetOperador',
    component: GetPersonas,
  },
  {
    path: '/paquete/add',
    name: 'CreatePaquetes',
    component: CreatePaquetes,
  },
  {
    path: '/paquete/get',
    name: 'GetPaquetes',
    component: GetPaquetes,
  },
  {
    path: '/paquete/addEstandar',
    name: 'AddPaqueteEstandar',
    component: AddPaqueteEstandar,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router