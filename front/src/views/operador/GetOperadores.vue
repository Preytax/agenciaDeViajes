<template>
    <inc_head/>
    <div class="body-wrapper">
      <div class="container-fluid">
        <div class="card">
          <div class="card-body">
            <h3>{{ title }}</h3>
            <DataTable selectionMode="single" :metaKeySelection="metaKey" v-model:filters="filters" :value="operadores" paginator showGridlines :rows="10" editMode="row" dataKey="id" filterDisplay="menu" 
              :loading="loading" :globalFilterFields="['idPerfil', 'nombres', 'apellidoPaterno', 'apellidoPaterno', 'tipoDocumento', 'nroDocumento']" tableClass="editable-cells-table" @row-edit-save="onRowEditSave"
              tableStyle="min-width: 50rem" v-model:editingRows="editingRows">
      
              <template v-slot:header>
                <div class="flex justify-content-end">
                  <Button type="button" class="p-button p-component p-button-outlined p-button-sm" style="float: left;" label="Limpiar" outlined @click="clearFilter()">
                    <span class="p-button-icon p-button-icon-left pi pi-filter-slash"></span>
                    <span class="p-button-label">Limpiar</span>
                  </Button>
                  <span class="p-input-icon-left">
                    <i class="pi pi-search" />
                    <InputText ref="search" style="" v-model="filters['global'].value" placeholder="Buscar..." />
                  </span>
                </div>
              </template>
      
              <template #empty>
                Sin datos de operadores.
              </template>
      
              <template #loading>
                Cargando datos de operadores. Por favor espere.
              </template>
      
              <Column field="id" header="Id" style="min-width: 12rem"></Column>
              <Column field="idPerfil" header="Perfil" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.idPerfil }}
                </template>
                <template #filter="{ filterModel }">
                    <InputText v-model="filterModel.value" type="text" class="p-column-filter" placeholder="Search by name" />
                </template>
              </Column>
              <Column field="nombres" header="Nombres" style="min-width: 12rem">
                <template #editor="{ data, field }">
                    <InputText v-model="data[field]" />
                </template>
              </Column>
              <Column field="apellidoPaterno" header="Apellido Paterno" style="min-width: 12rem"></Column>
              <Column field="apellidoMaterno" header="Apellido Materno" style="min-width: 12rem"></Column>
              <Column field="tipoDocumento" header="Documento" style="min-width: 12rem"></Column>
              <Column field="nroDocumento" header="Nro. Documento" style="min-width: 12rem"></Column>
              <Column field="estado" header="Estado" style="min-width: 12rem">
                <template #body="datoOperador">
                  <span>{{ statuses[datoOperador.data.estado] }}</span>
                </template>
              </Column>
              <Column field="fechaNacimiento" header="Fecha Nacimiento" style="min-width: 12rem"></Column>
              <Column field="usuarioRegistra" header="Usuario Registra" style="min-width: 12rem"></Column>
              <Column field="fechaRegistro" header="Fecha Registro" style="min-width: 12rem"></Column>
              <Column field="ip" header="ip" style="min-width: 12rem"></Column>
              
              <Column :rowEditor="true" style="width: 10%; min-width: 8rem" bodyStyle="text-align:center"></Column>
            </DataTable>
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
  import { FilterMatchMode, FilterOperator } from 'primevue/api';

  export default {
    components: {
      DataTable,
      Column,
      InputText,
      inc_head
    },
    data() {
      return {
        statuses : {0: 'Deshabilitado', 1:'Habilitado', 2:'Eliminado'},
        loading: true,
        operadores: null,
        title: 'Operadores',
        filters: {
            global: { 
              value: null, matchMode: FilterMatchMode.CONTAINS 
            },
            idPerfil: { 
              nombres: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] 
            },
            nombres: { 
              nombres: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] 
            },
            apellidoPaterno: { 
              nombres: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] 
            },
            apellidoMaterno: { 
              nombres: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] 
            },
            nroDocumento: { 
              nombres: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] 
            },
          },
      };
    },
    mounted() {
      this.fetchData();
    },
    methods: {
      async fetchData() {
        const baseUrl = 'http://localhost:8080/';
        const response = await axios.get( baseUrl + 'getOperadores');
        this.operadores = response.data;
        this.loading = false;
        //ProductService.getProductsMini().then((data) => (this.operadores.value = data));
      },
      clearFilter() {
        this.$refs.search.$el.value = ''; //Limpiar el inputText
        this.filters.global.value = null; // Restablecer el valor del filtro global // Restablecer el valor del filtro nroDocumento
        this.fetchData(); // Volver a cargar los datos y refrescar la tabla
      },
    }
  };
  </script>