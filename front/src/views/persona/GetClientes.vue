<template>
    <div class="mp_row_Alert" v-if="showAlert">{{valorAlerta}}<i @click="hideAlert"></i></div>
    <inc_head/>
    <div class="body-wrapper">
      <div class="pt-0 container-fluid">
        <div class="card">
          <div class="card-body">
            <h3>{{ title }}</h3><!--showGridlines-->
            <DataTable 
              v-model:filters="filters" :value="operadores" editMode="row" tableClass="editable-cells-table" 
              :rows="10" filterDisplay="row" tableStyle="min-width: 50rem; border:0" 
              paginator scrollable :row-class-name="'table-row-space'"
              :globalFilterFields="['idPerfil', 'nombres', 'apellidoPaterno', 'apellidoPaterno', 'tipoDocumento', 'nroDocumento']">
              
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
                Sin datos de clientes.
              </template>
      
              <template #loading>
                Cargando datos de clientes. Por favor espere.
              </template>
      
              <Column field="id" header="Id" style="min-width: 2rem"></Column>
              <Column field="nombres" header="Nombres" style="min-width: 15rem"><!--frozen-->
                <template #filter="{  }">
                  <InputText ref="filtroNombres" v-model="filters['nombres'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>
              <Column field="apellidoPaterno" header="Apellido Paterno" style="min-width: 12rem">
                <template #filter="{  }">
                  <InputText ref="filtroApellidoPaterno" v-model="filters['apellidoPaterno'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>
              <Column field="apellidoMaterno" header="Apellido Materno" style="min-width: 12rem">
                <template #filter="{  }">
                  <InputText ref="filtroApellidoMaterno" v-model="filters['apellidoMaterno'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>
              <Column field="tipoDocumento" header="Documento" style="min-width: 12rem">
                <template #body="datostipoDocumento">
                  <span>{{ tiposDocumentos[datostipoDocumento.data.tipoDocumento] }}</span>
                </template>
              </Column>
              <Column field="nroDocumento" header="Nro. Documento" style="min-width: 12rem">
                <template #filter="{  }">
                  <InputText ref="filtroNroDocumento" v-model="filters['nroDocumento'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>
              <Column field="idPerfil" header="Perfil" style="min-width: 12rem">
                <!--<template #body="datosTiposPerlies">
                  <span>{{ /*perfiles[datosTiposPerlies.data.idPerfil]*/ }}</span>
                </template>-->
                <template #filter="{  }">
                  <InputText ref="filtroIdPerfil" v-model="filters['idPerfil'].value" type="text" class="p-column-filter" placeholder="Buscar" />
                </template>
              </Column>
              <Column field="estado" header="Estado" style="min-width: 12rem">
                <template #body="datoOperador">
                  <span>{{ statuses[datoOperador.data.estado] }}</span>
                </template>
              </Column>
              <Column field="fechaNacimiento" header="Fecha Nacimiento" style="min-width: 12rem">
                <template #filter="{  }">
                  <InputText ref="filtroFechaNacimiento" type="date" v-model="filters['fechaNacimiento'].value" placeholder="yyyy-mm-dd" mask="99-99-9999" />
                </template>
              </Column>
              <Column field="usuarioRegistra" header="Usuario Registra" style="min-width: 12rem"></Column>
              <Column field="fechaRegistro" header="Fecha Registro" style="min-width: 12rem"></Column>
              <Column field="ipRegistra" header="IP Registro" style="min-width: 12rem"></Column>

              <Column field="id" header="Acciones" style="min-width: 12rem">
                  <template #body="datosId">
                    <button v-if="datosId.data.estado == 1" type="button" @click="suspenderCliente(datosId.data.id, datosId.data.estado)" class="btn btn-warning">Suspender</button>
                    <button v-if="datosId.data.estado == 0" type="button" @click="suspenderCliente(datosId.data.id, datosId.data.estado)" class="btn btn-success">Habilitar</button>
                    <button type="button" @click="ShowModalEliminar(datosId.data.id, datosId.data.correo)" class="btn btn-danger btn-eliminar">Eliminar</button>
                </template>
              </Column>
              <!--<Column :rowEditor="true" style="width: 10%; min-width: 8rem" bodyStyle="text-align:center"></Column>-->
            </DataTable>
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
                <button type="button" @click="eliminarCliente(datosEliminar.id)" class="btn btn-danger btn-eliminar">Eliminar</button>
              </div>
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
        modalEliminar: false,
        tiposDocumentos : {},
        perfiles : {},
        datosEliminar: {},
        statuses : {0: 'Suspendido', 1:'Habilitado', 2:'Eliminado'},
        loading: true,
        operadores: null,
        showAlert: false,
        title: 'Clientes Registrados',
        filters: {
          global: { 
            value: null, matchMode: FilterMatchMode.CONTAINS 
          },
          idPerfil: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
          nombres: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
          apellidoPaterno: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
          apellidoMaterno: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
          nroDocumento: { 
            value: null, matchMode: FilterMatchMode.STARTS_WITH
          },
          fechaNacimiento: { 
            value: null, matchMode: FilterMatchMode.CONTAINS
          },
          fechaRegistro: { 
            value: null, matchMode: FilterMatchMode.CONTAINS
          },
        },
      };
    },
    mounted: async function() {

      this.cargarTabla();

      /* REORDENAMIENTO DE TIPOS DE DOCUEMNTOS */
      const responseTipoDocumento = await axios.get( this.BASE_URL_AXIOS + 'getTiposDocumentos');
      var auxTiposDocumentos = {};

      for (const op of responseTipoDocumento.data) {
        auxTiposDocumentos[op.id] = op.nombre;
      }
      this.tiposDocumentos = auxTiposDocumentos;

      for (let key in this.operadores) {
        const operador = this.operadores[key];
        const perfilResponse = await axios.get(this.BASE_URL_AXIOS + 'getPerfil/' + operador.idPerfil);
        const nombrePerfil = perfilResponse.data.nombre;
        operador.idPerfil = nombrePerfil; // Agregar el nombre al objeto operador en la lista
      }

      /*REORDENAMIENTO DE TIPOS DE PERFILES 
      const responsePerfil = await axios.get( this.BASE_URL_AXIOS + 'getPerfiles');
      var auxTipoPerfiles = {};
      
      for (const op of responsePerfil.data) {
        auxTipoPerfiles[op.id] = op.nombre;
      }
      this.perfiles = auxTipoPerfiles;*/
    },
    methods: {
      async cargarTabla(){
        const response = await axios.get( this.BASE_URL_AXIOS + 'getClientes/3/0,1');
        this.operadores = response.data;
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

      async eliminarCliente(id) {
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
      async suspenderCliente(id, estado) {
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
        this.$refs.filtroNombres.$el.value          = '';
        this.$refs.filtroApellidoPaterno.$el.value  = '';
        this.$refs.filtroApellidoMaterno.$el.value  = '';
        this.$refs.filtroNroDocumento.$el.value     = '';
        this.$refs.filtroIdPerfil.$el.value         = '';
        this.$refs.filtroFechaNacimiento.$el.value  = '';

        // Restablecer el valor del los filtro
        this.filters.global.value           = null;
        this.filters.nombres.value          = null;
        this.filters.apellidoPaterno.value  = null;
        this.filters.apellidoMaterno.value  = null;
        this.filters.nroDocumento.value     = null;
        this.filters.idPerfil.value         = null;
        this.filters.fechaNacimiento.value  = null;
      },
    }
  };
  </script>

  <style>
.table-row-space {
  margin-bottom: 10px; /* Agrega espacio en la parte inferior de cada fila */
  /* o */
  padding-bottom: 10px; /* Agrega espacio interno en la parte inferior de cada fila */
}
</style>