<template>
    <div class="mp_row_Alert"><i></i></div>
    <inc_head/>
    <div class="body_wrapper">
        <div class="pt-0 container-fluid">
            <div class="card">
                <div class="card-body">
                    <h3></h3>
                    <DataTable>
                        <template>
                            <div class="flex justify-content-end">
                                <button type="button" class="p-button p-component p-button-outlined p-button-sm" style="float: left;" label="Limpiar" outlined >
                                    <span class="p-button-icon p-button-icon-left pi pi-filter-slash"></span>
                                    <span class="p-button-label">Limpiar</span>
                                </button>
                                <span class="p-input-icon-left">
                                    <i class="pi pi-search" />
                                    <InputText ref="search" style="" />
                                </span>
                            </div>
                        </template>

                        <template #empty>
                            Sin datos de paquetes
                        </template>
                        <template #loading>
                            Cargando datos de usuarios. Por favor espere.
                        </template>

                        <Column></Column>
                        <Column></Column>
                        <Column></Column>
                        <Column></Column>
                        <Column></Column>
                    </DataTable>

                </div>
            </div>
        </div>
        <div class="modal" tabindex="-1" style="display: block;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"></h5>
                    </div>
                    <div class="modal-body">
                        <!--<p>&#191;Quiere eliminar al usuario {{ datosEliminar.correo }}&#63;</p>-->
                    </div>
                    <div class="">
                        <button></button>
                        <button></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  import inc_head from "../Inc/inc_head";
  import DataTable from 'primevue/datatable';
  import Column from 'primevue/column';
  import InputText from 'primevue/inputtext';
  import axios from 'axios';
  /**import { FilterMatchMode } from 'primevue/api';**/

  export default {
    beforeRouteEnter (to, from, next){
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
            // Redirigir a la página de inicio de sesión
            next('/login');
        } else if(localStorage.getItem('id_perfil') != 1  && localStorage.getItem('id_perfil') != 4){
            next('/home');
        } else {
            next();
        }
    },
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    components: {
        DataTable,
        Column,
        InputText,
        inc_head
    },
    data() {
        return {
            modalModificar: false,
            datosModificar: {},
            loading: true,
            operadores: null,
            showAlert: false,
            title: 'Paquetes Seleccionados',
        }
    },
    mounted: async function () {
        this.cargarTabla();


    },
    methods: {
        async cargarTabla(){
        const response = await axios.get( this.BASE_URL_AXIOS + 'getPersonas/1,2/0,1/'+localStorage.getItem('id'));
        this.operadores = response.data;
        this.loading = false;
      },
      /**async cancelarPaquete (id) {
            const request  = await axios ({
            method: "PUT",
            url: this.BASE_URL_AXIOS + "eliminarPaquete",
            data: {
                "id"                : id,
                "estado"            : 2,
            },
            headers: {
                "Content-Type": "application/json"
            }
        })
        var respuesta =  request.data.split("|");
        if(respuesta[0] == "OK") {

        }
      }**/
    }
  }
</script>