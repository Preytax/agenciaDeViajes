<template>
    <inc_head />
    <div class="app">
        <button @click="sendNotification">Enviar notificación</button>
        <div v-for="notificaciones in notificaciones" :key="notificaciones.id" class="notificaciones">
            {{ notificaciones.mensaje }}
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            notificaciones: [],
            userId: 55
        };
    },
    methods: {
        sendNotification(){
            const mensaje = '¡Esta es una notificacion!';
            axios.post('/api/notificaciones', { userId: this.userId, mensaje })
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error(error);
            });
        },
        fetchNotification() {
            axios.get('/api/noticaciones/${this.userId}')
            .then(response => {
                this.notificaciones = response.data;
            })
            .catch(error => {
                console.error(error);
            });
        }
    },
    mounted(){
        this.fetchNotification();
    }
};
</script>

<style>
.notificacion{
    margin-bottom: 10px;
}
</style>
