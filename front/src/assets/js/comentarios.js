const express = require('express');
const cors = require('cors');

const app = express();

app.use(cors());
app.use(express.json());

let comentarios = [];

app.get('/api/comentarios', (req, res) => {
    res.json(comentarios);
});

app.post('/api/comentarios', (req, res) =>{
    const { name, comment } = req.body;
    const newComment = { name, comment };
    customElements.push(newComment);
    res.status(201).json(newComment);
})