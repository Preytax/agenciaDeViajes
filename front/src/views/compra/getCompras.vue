<template>
    <inc_head/>
    <div class="body-wrapper" style="margin-left: 0;">
      <div class="pt-0 container-fluid">
        <div class="card">
          <div class="card-body">
            <h3>{{ title }}</h3><!--showGridlines-->
            <DataTable 
              :value="compras" editMode="row" tableClass="editable-cells-table" 
              :rows="10" filterDisplay="row" tableStyle="min-width: 50rem; border:0" 
              paginator scrollable :row-class-name="'table-row-space'"
              :globalFilterFields="['idPerfil', 'nombres', 'apellidoPaterno', 'apellidoPaterno', 'tipoDocumento', 'nroDocumento']">
              
      
              <template #empty>
                Sin datos de clientes.
              </template>
      
              <template #loading>
                Cargando datos de clientes. Por favor espere.
              </template>
      
              <Column field="usuarioRegistra" header="Usuario Registra" style="min-width: 12rem"></Column>
              <Column field="fechaRegistro" header="Fecha Registro" style="min-width: 12rem"></Column>
              <Column field="ipRegistra" header="IP Registro" style="min-width: 12rem"></Column>
              <!--<Column :rowEditor="true" style="width: 10%; min-width: 8rem" bodyStyle="text-align:center"></Column>-->
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
  /* import InputText from 'primevue/inputtext';
  import axios from 'axios'; */

export default{
    inject: ['BASE_URL_AXIOS','BASE_URL'],
    components: {
        DataTable,
        Column,
        //InputText,
        inc_head
    },
    data(){
        return {
            title: 'Paquetes Comprados',
            id: localStorage.getItem('id'),
            idPerfil: null
        }
    },
    props: [],
    mounted: async function() {

    },
    methods: {
        
    }
}
</script>