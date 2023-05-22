<template>
    <div class="container">
        <div class="row">
            <h3>{{ title }}</h3>
            <DataTable :value="paquetes" :paginator="true" :rows="20" tableStyle="min-width: 50rem">
                <Column field="ID" header="ID"></Column>
                <Column field="ID_MODO" header="ID_MODOs"></Column>
                <Column field="ID_DESTINO" header="ID_DESTINO"></Column>
                <Column field="ID_CRONOGRAMA" header="ID_CRONOGRAMA"></Column>
                <Column field="ID_HOTEL" header="ID_HOTEL"></Column>
                <Column field="ID_TRANSPORTE" header="ID_TRANSPORTE"></Column>
                <Column field="ID_USUARIO" header="ID_USUARIO"></Column>
                <Column field="ESTADO" header="ESTADO"></Column>
                <Column field="USUARIO_REGISTRA" header="USUARIO_REGISTRA"></Column>
                <Column field="USUARIO_MODIFICA" header="USUARIO_MODIFICA"></Column>
                <Column field="USUARIO_ELIMINA" header="USUARIO_ELIMINA"></Column>
                <Column field="FECHA_REGISTRA" header="FECHA_REGISTRA"></Column>
                <Column field="FECHA_MODIFICA" header="FECHA_MODIFICA"></Column>
                <Column field="FECHA_ELIMINA" header="FECHA_ELIMINA"></Column>
                <Column field="IP_REGISTRA" header="IP_REGISTRA"></Column>
                <Column field="IP_MODIFICA" header="IP_MODIFICA"></Column>
                <Column field="IP_ELIMINA" header="IP_ELIMINA"></Column>
            </DataTable>
        </div>   
    </div>
</template>

<script>
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import axios from 'axios';

export default{
    components: {
        DataTable,
        Column,
    },
    data() {
      return {
        operadores: null,
        title: 'PaquetesPersonalizados',
      };
    },
    mounted() {
        this.fetchData();
    },
    methods: {
      async fetchData() {
        const response = await axios.get('http://localhost:8080/getPaquetes');
        this.operadores = response.data;
      },
    },
};
</script>