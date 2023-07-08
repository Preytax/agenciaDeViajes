const express = require('express');
const bodyParser = require('body.parser');
const app = express();

app.use(bodyParser.json());

let notificaciones = [];

app.post('/api/notifications', (req, res)=>{
    const {userId, message} = req.body;
    const notificaciones = {userId, message};
    notificaciones.push(notificacion);
    res.json({ success: true, message: 'Notificación enviada correctamente' });
});