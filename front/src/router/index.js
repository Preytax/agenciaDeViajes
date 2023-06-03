import { createRouter, createWebHistory } from 'vue-router'
//import HomeView from '../views/HomeView.vue'
import AddPersona from '@/views/persona/AddPersona.vue'
import GetPersonas from '@/views/persona/GetPersonas.vue'
import CreatePaquetes from '@/views/paquetes/AddPaquetePersonalizado.vue'
import GetPaquetes from '@/views/paquetes/GetPaquetes.vue'
import sesion from '@/views/HomePrincipal.vue'
import Login from '@/views/sesion/LogIn.vue'
import Register from '@/views/sesion/RegisterIn.vue'
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
    path: '/perfil',
    name: 'perfil',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/perfilUser.vue')
  },
  {
    path: '/admin/persona/add',
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
    path: '/admin/persona/get',
    name: 'GetOperador',
    component: GetPersonas,
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
  },
  {
    path: '/cliente/addPaqueteEstandar',
    name: 'AddPaqueteEstandar',
    component: AddPaqueteEstandar,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router