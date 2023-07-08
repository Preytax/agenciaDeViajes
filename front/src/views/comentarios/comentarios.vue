<template>
    <div>
        <h1>Experiencias de otros usuarios:</h1>
        <form>
            <input v-model="name" type="text" placeholder="Nombre" required>
            <textarea v-model="comment" placeholder="Comentario" required></textarea>
            <button tyoe="submit">Enviar</button>
        </form>
        <div>
            <p>No hay comentarios.</p>
        </div>

        <div>
            <div>
                <h3>{{ comentarios.id }}</h3>
                <p>{{ comentarios.mensaje }}</p>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            id: 0,
            comentario: '',
            mensaje: [],
        };
    },
    mounted() {
        this.fetchComments();
    },
    methods: {
        submitComment(){
            const newComment = {
                name: this.name,
                Comment: this.comment,
            };
        }
    }
}
</script>