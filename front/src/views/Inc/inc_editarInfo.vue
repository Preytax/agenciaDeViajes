<template>
    <transition name="fade">
        <div v-if="show" class="conteiner divSombraAlerta">
            <div class="contenedorAlerta">
                <div class="divAlerta">
                    <div class="card">
                        <div class="card-body">
                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                                    <div class="row g-3">
                                        <div class="col-sm-6">
                                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nombre</label>
                                            <InputText type="text" class="form-control" id="firstName" placeholder="" maxlength="45" v-model="nombres" required/>
                                            <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                                Valid first name is required.
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="lastName" class="form-label" _msttexthash="112346" _msthash="29">Apellido Paterno</label>
                                            <InputText type="text" class="form-control" id="lastName" placeholder="" maxlength="45" v-model="apellidoPaterno" required/>
                                            <div class="invalid-feedback" _msttexthash="592748" _msthidden="1" _msthash="30">
                                                Valid last name is required.
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Aapellido Materno</label>
                                            <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="45" v-model="apellidoMaterno" required/>
                                            <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                                Valid first name is required.
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Fecha de Nacimiento</label>
                                            <InputText type="date" class="form-control" id="lastName2" placeholder="" v-model="fechaNacimiento" required/>
                                            <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                                Valid first name is required.
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="country" class="form-label" _msttexthash="60047" _msthash="42">Tipo de Documento</label>
                                            <select class="form-select" id="country" outlined v-model="tipoDocumento">
                                                <option value="" _msttexthash="101647" _msthash="43">Elegir...</option>
                                                <option v-for="tipoDocumento in tiposDocumentos" :key="tipoDocumento.id" :value="tipoDocumento.id">{{tipoDocumento.nombre}}</option>
                                            </select>
                                            <div class="invalid-feedback" _msttexthash="685542" _msthidden="1" _msthash="45">
                                                Please select a valid country.
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="firstName" class="form-label" _msttexthash="76193" _msthash="27">Nro. de Documento</label>
                                            <InputText type="text" class="form-control" id="lastName2" placeholder="" maxlength="8" v-model="nroDocumento" required/>
                                            <div class="invalid-feedback" _msttexthash="637039" _msthidden="1" _msthash="28">
                                                Valid first name is required.
                                            </div>
                                        </div>            
                                        <div class="col-sm-6">
                                            <label for="username" class="form-label">Correo Electronico</label>
                                            <div class="input-group has-validation">
                                                <span class="input-group-text">@</span>
                                                <input v-model="correo" type="email" class="form-control" id="correo" placeholder="Correo" maxlength="150" required="">
                                                <div class="invalid-feedback">
                                                    Your username is required.
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="email" class="form-label" _msttexthash="731406" _msthash="34">Contraseña <span class="text-body-secondary" _istranslated="1"></span></label>
                                            <input v-model="password" type="password" class="form-control" id="password" placeholder="**********"  maxlength="10" _mstplaceholder="274417" _msthash="35">
                                            <div class="invalid-feedback" _msttexthash="1993589" _msthidden="1" _msthash="36">
                                                Please enter a valid email address for shipping updates.
                                            </div>
                                        </div>
                                    </div>

                                    <hr class="my-4">

                                    <a class="w-100 btn btn-primary btn-lg" @click="addOperador" href="#">Registrar</a>
                                </div>
                                <button type="button" class="btn btn-success m-1">Actualizar</button>
                                <button @click="ocultarEdit" ref="divOculto" type="button" class="btn btn-danger m-1">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>

<script>

export default {
  name: "inc_editarInfo",
  data() {
    return {
      title: 'Operadores',
      url: window.location.href,
      show: true,
    }
  },
  methods: {
    mostrarEdit(){
      this.show = true;
    },
    ocultarEdit(){
      this.show = false;
    },
  },
};

</script>

<style>

.divSombraAlerta{
  width: 100%;
  height: 100%;
  position: fixed;
  background: #c4c4c4b0;
  bottom: 0;
  left: 0;
  z-index: 9999;
}

.contenedorAlerta{
    width: 100%; 
    height: 25rem; 
    background-color: #5d87ff; 
    position: absolute; 
    bottom: 0;
    border: solid 1px;
}

.divAlerta{
    position: absolute;
    bottom: 0;
    right: 30%;
    left: 30%;
    top: -250px
}

.fade-enter-active{
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
} 
.fade-leave-active {
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.fade-enter-from, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0
}
</style>