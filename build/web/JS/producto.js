$("document").ready(function(){
    $.ajax({
        url : "../Controlador",
        method : "GET",
        data : {
            caso : "OpcionesMarca"
        },
        success:function(respuesta){
            $("#ProductoMarca").html(respuesta)
        }
    })
    $.ajax({
        url : "../Controlador",
        method : "GET",
        data : {
            caso : "OpcionesCategoria"
        },
        success:function(respuesta){
            $("#ProductoCategoria").html(respuesta)
        }
    })
})