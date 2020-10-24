function RegistroMarca(){
    $.ajax({
        url : "../Controlador",
        method: "POST",
        data : {
            nombre : $("#MarcaNombre").val(),
            descripcion : $("#MarcaDescripcion").val(),
            caso : "Marca"
        },
        success : function(){
            console.log('Funciono!')
        },
        error : function(error){
            console.log(error)
        }
    })
}

function RegistrarCategoria(){
    $.ajax({
        url : "../Controlador",
        method: "POST",
        data : {
            nombre : $("#CategoriaNombre").val(),
            descripcion : $("#CategoriaDescripcion").val(),
            caso : "Categoria"
        },
        success : function(){
            console.log('Funciono!')
        },
        error : function(error){
            console.log(error)
        }
    })
}

function RegistrarProducto(){
    $.ajax({
        url : "../Controlador",
        method: "POST",
        data : {
            codigo : $("#ProductoCodigo").val(),
            nombre : $("#ProductoNombre").val(),
            descripcion : $("#ProductoDescripcion").val(),
            precio : $("#ProductoPrecio").val(),
            marca : $("#ProductoMarca").val(),
            categoria : $("#ProductoCategoria").val(),
            caso : "Producto"
        },
        success : function(){
            console.log('Funciono!')
        },
        error : function(error){
            console.log(error)
        }
    })
}