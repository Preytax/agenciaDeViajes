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
import AddPais from '@/views/ubigeo/AddPais.vue'
import GetPais from '@/views/ubigeo/GetPais.vue'
import AddDepartamento from '@/views/ubigeo/AddDepartamento.vue'
import GetDepartamento from '@/views/ubigeo/GetDepartamento.vue'
import AddCiudad from '@/views/ubigeo/AddCiudad.vue'
import GetCiudad from '@/views/ubigeo/GetCiudad.vue'
import AddActividad from '@/views/acciones/AddActividad.vue'
import GetActividad from '@/views/acciones/GetActividad.vue'
import mercadoPago from '@/views/pasarela/mercadoPago'
import getCompras from '@/views/compra/getCompras'

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
    path: '/actividad/AddActividad',
    name: 'AddActividad',
    component: AddActividad,
  },
  {
    path: '/actividad/GetActividad',
    name: 'GetActividad',
    component: GetActividad,
  },
  {
    path: '/ciudad/AddCiudad',
    name: 'AddCiudad',
    component: AddCiudad,
  },
  {
    path: '/getCompras',
    name: 'getCompras',
    component: getCompras,
  },
  {
    path: '/ciudad/GetCiudad',
    name: 'GetCiudad',
    component: GetCiudad,
  },
  {
    path: '/pais/AddPais',
    name: 'AddPais',
    component: AddPais,
  },
  {
    path: '/pais/GetPais',
    name: 'GetPais',
    component: GetPais,
  },
  {
    path: '/departamento/AddDepartamento',
    name: 'AddDepartamento',
    component: AddDepartamento,
  },
  {
    path: '/departamento/GetDepartamento',
    name: 'GetDepartamento',
    component: GetDepartamento,
  },
  {
    path: '/mercadoPago',
    name: 'mercadoPago',
    component: mercadoPago,
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