$("document").ready(function(){
    $.ajax({
        url : "../Controlador",
        method : "GET",
        data : {
            caso : "Marcas"
        },
        success : function (respuesta){
          $("#TablaMarca").html(respuesta)  
        }
    })
    $.ajax({
        url : "../Controlador",
        method : "GET",
        data : {
            caso : "Categorias"
        },
        success : function (respuesta){
          $("#TablaCategoria").html(respuesta)  
        }
    })
    $.ajax({
        url : "../Controlador",
        method : "GET",
        data : {
            caso : "Productos"
        },
        success : function (respuesta){
          $("#TablaProducto").html(respuesta)  
        }
    })
})


