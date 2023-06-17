<template>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <inc_head/>
    <div class="body-wrapper">
      <div class="pt-0 container-fluid">
        <div class="card">
          <div class="card-body">
            <h3>{{ title }}</h3><!--showGridlines-->
            <DataTable 
              v-model:filters="filters" :value="actividades" editMode="row" tableClass="editable-cells-table" 
              :rows="10" filterDisplay="row" tableStyle="min-width: 50rem; border:0" 
              paginator scrollable :row-class-name="'table-row-space'"
              :globalFilterFields="['id', 'nombre', 'idCiudad']">
              
              <template v-slot:header>
                <div class="flex justify-content-end">
                  <button type="button" class="p-button p-component p-button-outlined p-button-sm" style="float: left;" label="Limpiar" outlined @click="clearFilter()">
                    <span class="p-button-icon p-button-icon-left pi pi-filter-slash"></span>
                    <span class="p-button-label">Limpiar</span>
                  </button>
                  <span class="p-input-icon-left">
                    <i class="pi pi-search" />
                    <InputText ref="search" style="" v-model="filters['global'].value" placeholder="Buscar..." />
                  </span>
                </div>
              </template>
      
              <template #empty>
                Sin datos de usuarios.
              </template>
      
              <template #loading>
                Cargando datos de usuarios. Por favor espere.
              </template>
      
              <Column field="id" header="Id" style="min-width: 2rem"></Column>
              <Column field="idCiudad" header="Ciudad" style="min-width: 15rem"><!--frozen-->
                <template #filter="{  }">
                  <InputText ref="filtroCiudad" v-model="filters['idCiudad'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>
              <Column field="nombre" header="Actividad" style="min-width: 15rem"><!--frozen-->
                <template #filter="{  }">
                  <InputText ref="filtroNombre" v-model="filters['nombre'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>

              <!--<Column field="id" header="Acciones" style="min-width: 12rem">
                  <template #body="datosId">
                    <button v-if="datosId.data.estado == 1" type="button" @click="suspender(datosId.data.id, datosId.data.estado)" class="btn btn-warning">Suspender</button>
                    <button v-if="datosId.data.estado == 0" type="button" @click="suspender(datosId.data.id, datosId.data.estado)" class="btn btn-success">Habilitar</button>
                    <button type="button" @click="ShowModalEliminar(datosId.data.id, datosId.data.correo)" class="btn btn-danger btn-eliminar">Eliminar</button>
                </template>
              </Column>
              <Column :rowEditor="true" style="width: 10%; min-width: 8rem" bodyStyle="text-align:center"></Column>-->
            </DataTable>
          </div>
        </div>
      </div>
      <div v-show="modalEliminar" class="modal" tabindex="-1" style="display: block;">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Eliminaci&oacute;n de Usuario</h5>
              <button type="button" @click="hideModalEliminar()" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p>&#191;Quiere eliminar al usuario {{ datosEliminar.correo }}&#63;</p>
            </div>
            <div class="modal-footer">
              <button type="button" @click="hideModalEliminar()" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="button" @click="eliminarPersona(datosEliminar.id)" class="btn btn-danger btn-eliminar">Eliminar</button>
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
  import { FilterMatchMode } from 'primevue/api';

  export default {
    beforeRouteEnter(to, from, next) {
        // Verificar si la variable de sesión existe
        if (!localStorage.getItem('id')) {
            // Redirigir a la página de inicio de sesión
            next('/login');
        } else if(localStorage.getItem('id_perfil') != 2  && localStorage.getItem('id_perfil') != 4){
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
        idMultiuser: localStorage.getItem('id_multiuser'),
        modalEliminar: false,
        datosEliminar: {},
        idCiudad : {},
        statuses : {0: 'Deshabilitado', 1:'Habilitado', 2:'Eliminado'},
        loading: true,
        actividades: null,
        showAlert: false,
        title: 'Ciudades Creadas',
        filters: {
          global: { 
            value: null, matchMode: FilterMatchMode.CONTAINS 
          },
          nombre: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
          idCiudad: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
        },
      };
    },
    mounted: async function() {

      this.cargarTabla();

    },
    methods: {
      async cargarTabla(){
        const responseActividades = await axios.get( this.BASE_URL_AXIOS + 'getActividadesByIdMultiuser/'+this.idMultiuser);
        this.actividades = responseActividades.data;

        for (let key in this.actividades) {
          const ciudad = this.actividades[key];
          const ciudadResponse = await axios.get(this.BASE_URL_AXIOS + 'getCiudadById/' + ciudad.idCiudad);
          const nombreCiudad = ciudadResponse.data[0].nombre;
          ciudad.idCiudad = nombreCiudad;
        }

        this.loading = false;
      },
      async ShowModalEliminar(id, correo){
        this.datosEliminar = {
          id:id, 
          correo:correo
        }
        this.modalEliminar = true;
      },
      hideModalEliminar() {
        this.modalEliminar = false;
      },
      async eliminarPersona(id) {
        const request = await axios({
            method: "PUT",
            url: this.BASE_URL_AXIOS + "actualizarEstadoPersona",
            data: {
                "id"                : id,
                "estado"            : 2,
            },
            headers: {
                "Content-Type": "application/json"
            }
        })

        var respuesta =  request.data.split("|");
        if(respuesta[0] == "OK")
        {
            this.hideModalEliminar();
            this.valorAlerta = respuesta[1];
            this.showAlerta();
            this.cargarTabla();

        }else{
            this.valorAlerta = respuesta[1];
            this.showAlerta();
        }
      },
      async suspender(id, estado) {
        const request = await axios({
            method: "PUT",
            url: this.BASE_URL_AXIOS + "actualizarEstadoPersona",
            data: {
                "id"                : id,
                "estado"            : estado,
            },
            headers: {
                "Content-Type": "application/json"
            }
        })

        var respuesta =  request.data.split("|");
        if(respuesta[0] == "OK")
        {
            this.valorAlerta = respuesta[1];
            this.showAlerta();
            this.cargarTabla();

        }else{
            this.valorAlerta = respuesta[1];
            this.showAlerta();
        }
      },
      showAlerta() {
        this.showAlert = true;
        setTimeout(() => {
          this.hideAlert();
        }, 1500);
      },
      hideAlert() {
        this.showAlert = false;
      },
      clearFilter() {
        //Limpiar el inputText
        this.$refs.search.$el.value                 = ''; 
        this.$refs.filtroNombre.$el.value          = '';
        this.$refs.filtroCiudad.$el.value     = '';
        
        // Restablecer el valor del los filtro
        this.filters.global.value             = null;
        this.filters.nombre.value            = null;
        this.filters.idCiudad.value = null;
      },
    }
  };
</script>

<style>
.table-row-space 
{
  margin-bottom: 10px; /* Agrega espacio en la parte inferior de cada fila */
  /* o */
  padding-bottom: 10px; /* Agrega espacio interno en la parte inferior de cada fila */
}

.btn-eliminar
{
  margin-top: 5px;
}
</style>