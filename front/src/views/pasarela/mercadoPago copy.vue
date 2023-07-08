<template>
  <div id="wallet_container"></div>
</template>

<script>
console.log("");
/*
import "@mercadopago/sdk-js";

// eslint-disable-next-line no-undef
const mp = new MercadoPago("TEST-95883d63-e692-4068-9dac-957331fe1e14");
// eslint-disable-next-line no-unused-vars
const bricksBuilder = mp.bricks();

mp.bricks().create("wallet", "wallet_container", {
    initialization: {
        preferenceId: "1234",
    },
});


// Crea un objeto de preferencia
let preference = {
  items: [
    {
      title: 'Mi producto',
      unit_price: 100,
      quantity: 1,
    }
  ],
  purpose: 'wallet_purchase'
};

mp.preferences.create(preference)
.then(function(response){
console.log(response);
}).catch(function(error){
  console.log(error);
});



export default {
  name: 'MercadoPagoForm',
  // Resto del código del componente
}; */
</script>

<style>
  #form-checkout {
    display: flex;
    flex-direction: column;
    max-width: 600px;
  }

  .container {
    height: 18px;
    display: inline-block;
    border: 1px solid rgb(118, 118, 118);
    border-radius: 2px;
    padding: 1px 2px;
  }
</style>
