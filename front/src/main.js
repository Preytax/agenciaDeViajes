import {createApp} from 'vue'
import App from './App.vue'
import router from './router'

import PrimeVue from 'primevue/config';
import "primevue/resources/themes/lara-light-indigo/theme.css";
import "primevue/resources/primevue.min.css";
import 'primeicons/primeicons.css';
import { Button } from "primevue/button"

/* MENU DESPLEGABLE */
import Dropdown from 'primevue/dropdown';
/* END MENU DESPLEGABLE */

/* CALENDARIO */
import Calendar from 'primevue/calendar';
/* END CALENDARIO */

/* DATATABLES */
import 'primevue/resources/themes/saga-blue/theme.css';
import 'primevue/resources/primevue.min.css';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';  
import InputText from 'primevue/inputtext';
/* END DATATABLES */
import { FilterMatchMode, FilterOperator } from 'primevue/api';
/* CRYPTOJS */
import CryptoJS from 'crypto-js';
/* END CRYPTOJS */
Window.axios = require('axios')
const app = createApp(App).use(router);

/* VARIBLES GLOBALES */
app.provide('baseUrl', 'http://localhost:8081/');
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

app.component('CryptoJS', CryptoJS);
// eslint-disable-next-line vue/multi-word-component-names
app.component('Calendar', Calendar);
// eslint-disable-next-line vue/multi-word-component-names
app.component('Dropdown', Dropdown);
// eslint-disable-next-line vue/multi-word-component-names
app.component('Button', Button);
app.component('DataTable', DataTable);
// eslint-disable-next-line vue/multi-word-component-names
app.component('Column', Column);
app.component('InputText', InputText);
app.component('FilterMatchMode', FilterMatchMode);
app.component('FilterOperator', FilterOperator);
app.mount('#app');

/*!
 * Color mode toggler for Bootstrap's docs (https://getbootstrap.com/)
 * Copyright 2011-2023 The Bootstrap Authors
 * Licensed under the Creative Commons Attribution 3.0 Unported License.
 */

(() => {
  'use strict'

  const storedTheme = localStorage.getItem('theme')

  const getPreferredTheme = () => {
    if (storedTheme) {
      return storedTheme
    }

    return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'
  }

  const setTheme = function (theme) {
    if (theme === 'auto' && window.matchMedia('(prefers-color-scheme: dark)').matches) {
      document.documentElement.setAttribute('data-bs-theme', 'dark')
    } else {
      document.documentElement.setAttribute('data-bs-theme', theme)
    }
  }

  setTheme(getPreferredTheme())

  const showActiveTheme = (theme, focus = false) => {
    const themeSwitcher = document.querySelector('#bd-theme')

    if (!themeSwitcher) {
      return
    }

    const themeSwitcherText = document.querySelector('#bd-theme-text')
    const activeThemeIcon = document.querySelector('.theme-icon-active use')
    const btnToActive = document.querySelector(`[data-bs-theme-value="${theme}"]`)
    const svgOfActiveBtn = btnToActive.querySelector('svg use').getAttribute('href')

    document.querySelectorAll('[data-bs-theme-value]').forEach(element => {
      element.classList.remove('active')
      element.setAttribute('aria-pressed', 'false')
    })

    btnToActive.classList.add('active')
    btnToActive.setAttribute('aria-pressed', 'true')
    activeThemeIcon.setAttribute('href', svgOfActiveBtn)
    const themeSwitcherLabel = `${themeSwitcherText.textContent} (${btnToActive.dataset.bsThemeValue})`
    themeSwitcher.setAttribute('aria-label', themeSwitcherLabel)

    if (focus) {
      themeSwitcher.focus()
    }
  }

  window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
    if (storedTheme !== 'light' || storedTheme !== 'dark') {
      setTheme(getPreferredTheme())
    }
  })

  window.addEventListener('DOMContentLoaded', () => {
    showActiveTheme(getPreferredTheme())

    document.querySelectorAll('[data-bs-theme-value]')
      .forEach(toggle => {
        toggle.addEventListener('click', () => {
          const theme = toggle.getAttribute('data-bs-theme-value')
          localStorage.setItem('theme', theme)
          setTheme(theme)
          showActiveTheme(theme, true)
        })
      })
  })
})()