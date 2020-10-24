$('document').ready(()=>{
    $('#prueba').click(() =>{
        $.ajax({
           url : 'Controlador',
           method: 'GET',
           success : () => {
            console.log('JALO')   
           },
           error : error => {
               console.log(error)
           }
        });
    })
})