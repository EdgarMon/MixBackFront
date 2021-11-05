$(document).ready(main);

var contador = 1;

function main (){
    $('.menu_bar').click(function(){
        if (contador ==1){
            $('nav').animate({
                top:'58.8px'
                //right:'0%'
                
            });
            contador = 0;
        } else{
            contador = 1;
            $('nav').animate({
                top:'-250%'
                //right:'-100%'
                
            });
        }
    });
}

function autoInicioCategoria(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://129.151.109.197:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta(respuesta);
            let $select = $("#select-category");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.id+'>'+name.name+'</option>');
                console.log("select "+name.id);
            }); 
        }
    
    })

}
function pintarRespuesta(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="<td> <button class='botonsecundario' onclick=' actualizarInformacionCategorias("+respuesta[i].id+")'>Actualizar</button>";
        myTable+="<td> <button class='botonsecundario' onclick='borrarCategoria("+respuesta[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado1").html(myTable);
}

function guardarInformacionCategorias(){
    let var2 = {
        name:$("#Cname").val(),
        description:$("#Cdescription").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        
        url:"http://129.151.109.197:8080/api/Category/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

function actualizarInformacionCategorias(idElemento){
    let myData={
        id:idElemento,
        name:$("#Cname").val(),
        description:$("#Cdescription").val()

    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Category/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#Cname").val("");
            $("#Cdescription").val("");
            autoInicioCategoria();
            alert("se ha Actualizado correctamente la categoria")
        }
    });

}

function borrarCategoria(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Category/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            autoInicioCategoria();
            alert("Se ha Eliminado.")
        }
    });

}
////////////Tabla CAbañass////////////////////

function autoInicioCabin(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://129.151.109.197:8080/api/Cabin/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta1(respuesta);
            let $select = $("#select-cabin");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.id+'>'+name.name+'</option>');
                console.log("select "+name.id);
            });
            
        }
    
    })

}
function pintarRespuesta1(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].brand+"</td>";
        myTable+="<td>"+respuesta[i].rooms+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="<td>"+respuesta[i].id+"</td>";
        myTable+="<td> <button class='botonsecundario' onclick=' actualizarInformacionCabin("+respuesta[i].id+")'>Actualizar</button>";
        myTable+="<td> <button class='botonsecundario' onclick='borrarCabin("+respuesta[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado2").html(myTable);
}

function guardarInformacionCabin(){
    let var2 = {
        name:$("#Oname").val(),
        brand:$("#Obrand").val(),
        rooms:$("#Orooms").val(),
        description:$("#Odescription").val(),
        category: {id:+$("#select-category").val()},
        };
       
        console.log(var2);
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        
        url:"http://129.151.109.197:8080/api/Cabin/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

function actualizarInformacionCabin(idElemento){
    let myData={
        id:idElemento,
        name:$("#Oname").val(),
        brand:$("#Obrand").val(),
        rooms:$("#Orooms").val(),
        description:$("#Odescription").val(),
        category: {id:+$("#select-category").val()},


    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Cabin/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#Oname").val("");
            $("#Obrand").val("");
            $("#Orooms").val("");
            $("#Odescription").val("");
            $("#select-category").val("");
            autoInicioCabin();
            alert("se ha Actualizado correctamente Ortopedic")
        }
    });

}

function borrarCabin(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Cabin/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            autoInicioCabin();
            alert("Se ha Eliminado.")
        }
    });

}
/////////Tabla Cliente////////////////////////////

function autoInicioCliente(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://129.151.109.197:8080/api/Client/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta2(respuesta);
            let $select = $("#select-client");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.idClient+'>'+name.name+'</option>');
                console.log("select "+name.idClient);
            }); 
        }
    
    })

}
function pintarRespuesta2(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        
        myTable+="<td>"+respuesta[i].email+"</td>";
        myTable+="<td>"+respuesta[i].password+"</td>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].age+"</td>";
        myTable+="<td> <button class='botonsecundario' onclick=' actualizarInformacionCliente("+respuesta[i].idClient+")'>Actualizar</button>";
        myTable+="<td> <button class='botonsecundario' onclick='borrarCliente("+respuesta[i].idClient+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado3").html(myTable);
}

function guardarInformacionCliente(){
    let var2 = {
        
        email:$("#Clemail").val(),
        password:$("#Clpassword").val(),
        name:$("#Clname").val(),
        age:$("#Clage").val(),
     
        };
       
        console.log(var2);
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        
        url:"http://129.151.109.197:8080/api/Client/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

function actualizarInformacionCliente(idElemento){
    let myData={
        idClient:idElemento,
        email:$("#Clemail").val(),
        password:$("#Clpassword").val(),
        name:$("#Clname").val(),
        age:$("#Clage").val(),


    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Client/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#idClient").val("");
            $("#Clemail").val("");
            $("#Clpassword").val("");
            $("#Clname").val("");
            $("#Clage").val("");
            autoInicioCliente();
            alert("se ha Actualizado correctamente Cliente")
        }
    });

}

function borrarCliente(idElemento){
    let myData={
        idClient:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Client/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            autoInicioCliente();
            alert("Se ha Eliminado.")
        }
    });

}
////////////Tabla mensaje////////////////////////
function autoInicioMensaje(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://129.151.109.197:8080/api/Message/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta3(respuesta);
            
        }
    
    })

}
function pintarRespuesta3(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].messageText+"</td>";
        myTable+="<td>"+respuesta[i].idMessage+"</td>";
        myTable+="<td>"+respuesta[i].idMessage+"</td>";        
        myTable+="<td> <button class='botonsecundario' onclick=' actualizarInformacionMensaje("+respuesta[i].idMessage+")'>Actualizar</button>";
        myTable+="<td> <button class='botonsecundario' onclick='borrarMensaje("+respuesta[i].idMessage+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado4").html(myTable);
}

function guardarInformacionMensaje(){
    let var2 = {
        messageText:$("#messageText").val(),
        cabin: {id:+$("#select-cabin").val()},
        client: {idClient:+$("#select-client").val()},
        };
       
        console.log(var2);
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        
        url:"http://129.151.109.197:8080/api/Message/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            //window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              //window.location.reload()
            //alert("No se guardo correctamente");
    
    
        }
        });

}

function actualizarInformacionMensaje(idElemento){
    let myData={
        idMessage:idElemento,
        messageText:$("#messageText").val(),
        cabin:{id:+$("#select-cabin").val()},
        client:{idClient:+$("#select-client").val()},       


    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Message/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#idMessage").val("");
            $("#messageText").val("");
            $("#select-cabin").val("");
            $("#select-client").val("");            
            autoInicioMensaje();
            alert("se ha Actualizado correctamente")
        }
    });

}

function borrarMensaje(idElemento){
    let myData={
        idMessage:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Message/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            autoInicioMensaje();
            alert("Se ha Eliminado.")
        }
    });

}

////////////Tabla Reservación////////////////////
function traerInformacionReserva(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://129.151.109.197:8080/api/Reservation/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta4(respuesta);
             
        }

    });

}

function pintarRespuesta4(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].startDate+"</td>";
        myTable+="<td>"+respuesta[i].devolutionDate+"</td>";
        myTable+="<td>"+respuesta[i].idReservation+"</td>";
        myTable+="<td>"+respuesta[i].idReservation+"</td>";
        myTable+="<td> <button class='botonsecundario' onclick=' actualizarElementoReserva("+respuesta[i].idReservation+")'>Actualizar</button>";
        myTable+="<td> <button class='botonsecundario' onclick='borrarElementoReserva("+respuesta[i].idReservation+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado5").html(myTable);

}
function guardarInformacionReserva(){
    let var2 = {
        startDate:$("#startDate").val(),
        devolutionDate:$("#devolutionDate").val(),
        cabin:{id:+$("#select-cabin").val()},
        client:{idClient:+$("#select-client").val()},
        
    };
    console.log(var2);
    $.ajax({
    type:'POST',
    contentType: "application/json; charset=utf-8",
    dataType: 'JSON',
    data: JSON.stringify(var2),
    
    url:"http://129.151.109.197:8080/api/Reservation/save",
    
    
    success:function(response) {
            console.log(response);
        console.log("Se guardo correctamente");
        alert("Se guardo correctamente");
        window.location.reload()

    },
    
    error: function(jqXHR, textStatus, errorThrown) {
            window.location.reload()
        alert("No se guardo correctamente");


    }
    });

}

function actualizarElementoReserva(idElemento){
    let myData={
        idReservation:idElemento.val(),
        startDate:$("#startDate").val(),
        devolutionDate:$("#devolutionDate").val(),
        cabin:{id:+$("#select-cabin").val()},
        client:{idClient:+$("#select-client").val()},
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Reservation/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#idReservation").val("");
            $("#startDate").val("");
            $("#devolutionDate").val("");
            $("#select-cabin").val("");
            $("#select-client").val("");
            traerInformacionReserva();
            alert("se ha Actualizado")
        }
    });
}

function borrarElementoReserva(idElemento){
    let myData={
        idReservation:idElemento.val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.109.197:8080/api/Reservation/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            traerInformacionReserva();
            alert("Se ha Eliminado.")
        }
    });
}
function cargarCabin(){
    $.ajax({
        url:"http://129.151.109.197:8080/api/Cabin/all",
        type:"GET",
        async: false,
        datatype:"JSON",
        success:function(respuesta){
            
            const $select = document.querySelector("#nameCabin");
            for (let i = $select.options.length; i >= 0; i--) {
                 $select.remove(i);
                }
             datos=respuesta;
            console.log(datos.length);
            for(let i=0;i<datos.length;i++){
                console.log(datos[i].id);
                const option = document.createElement('option');
                option.value = datos[i].id;
                  option.text = datos[i].name;
                   $select.appendChild(option);
            }
        }
        });
}
function cargarClient(){
    $.ajax({
        url:"http://129.151.109.197:8080/api/Client/all",
        type:"GET",
        async: false,
        datatype:"JSON",
        success:function(respuesta){
            
            const $select = document.querySelector("#nameClient");
            for (let i = $select.options.length; i >= 0; i--) {
                 $select.remove(i);
                }
             datos=respuesta;
            console.log(datos.length);
            for(let i=0;i<datos.length;i++){
                console.log(datos[i].id);
                const option = document.createElement('option');
                option.value = datos[i].id;
                  option.text = datos[i].name;
                   $select.appendChild(option);
            }
        }
        });
}