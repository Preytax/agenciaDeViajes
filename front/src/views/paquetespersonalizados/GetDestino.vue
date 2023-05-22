<template>
    <div class="container">
        <div class="row">
            <h3>{{ title }}</h3>
            <DataTable :value="paquetes" :paginator="true" :rows="20" tableStyle="min-width: 50rem">
                <Column field="ID" header="ID"></Column>
                <Column field="ID_PAIS" header="ID_PAIS"></Column>
                <Column field="NOMBRE" header="NOMBRE"></Column>
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
        title: 'Destinos',
      };
    },
    mounted() {
        this.fetchData();
    },
    methods: {
      async fetchData() {
        const response = await axios.get('http://localhost:8080/getDestinos');
        this.operadores = response.data;
      },
    },
};
</script>