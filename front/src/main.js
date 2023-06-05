import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import { FilterMatchMode, FilterOperator } from 'primevue/api';

/* AXIOS */
Window.axios = require('axios')
/* END AXIOS */

const app = createApp(App).use(router);


/* VARIBLES GLOBALES */
const BASE_URL = "http://" + window.location.host + "/";
app.provide('BASE_URL', BASE_URL);

const BASE_URL_AXIOS = BASE_URL.replace('8081', '8080');
app.provide('BASE_URL_AXIOS', BASE_URL_AXIOS);
/* END VARIBLES GLOBALES */


/* PRIMEVUE */
app.use(PrimeVue);
app.use(PrimeVue, { ripple: true });
app.use(PrimeVue, { inputStyle: "filled" });
app.use(PrimeVue, {
    zIndex: {
        modal: 1100,        //dialog, sidebar
        overlay: 1000,      //dropdown, overlaypanel
        menu: 1000,         //overlay menus
        tooltip: 1100       //tooltip
    }
});
/* END PRIMEVUE */


/* CRYPTOJS */
import CryptoJS from 'crypto-js';
app.component('CryptoJS', CryptoJS);
/* END CRYPTOJS */


/* DATATABLES */
import PrimeVue from 'primevue/config';
import 'primevue/resources/primevue.min.css';
import 'primevue/resources/themes/saga-blue/theme.css';
import 'primeicons/primeicons.css';
//import "primevue/resources/themes/lara-light-indigo/theme.css";
//import 'primevue/resources/themes/saga-blue/theme.css';

// eslint-disable-next-line vue/multi-word-component-names
import Dropdown from 'primevue/dropdown';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';  
import InputText from 'primevue/inputtext';
// eslint-disable-next-line vue/multi-word-component-names
app.component('Dropdown', Dropdown);
app.component('DataTable', DataTable);
// eslint-disable-next-line vue/multi-word-component-names
app.component('Column', Column);
app.component('InputText', InputText);
app.component('FilterMatchMode', FilterMatchMode);
app.component('FilterOperator', FilterOperator);
/* END DATATABLES */


app.mount('#app');