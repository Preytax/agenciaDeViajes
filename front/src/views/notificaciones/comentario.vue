<template>
    <inc_head />
    <div class="">
        <button @click="sendNotification">Enviar notificación</button>
        <div v-for="notificacion in notificaciones" :key="notificacion.id" class="notificaciones">
            {{ notificacion.message }}
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            notificaciones: [],
            userId: 'example_user_id'
        };
    },
    methods: {
        sendNotification(){
            const mensaje = '¡Esta es una notificacion!';
            axios.post('/api/notificaciones', { userId: this.userId, message })
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
