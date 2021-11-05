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
function autoInicioRelacionCliente(){
    
    $.ajax({
        url:"http://129.151.109.197:8080/api/Client/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
          
            let $select = $("#select-client");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.idClient+'>'+name.name+'</option>');
            
            }); 
        }
    
    })
}
function autoInicioCabin(){

    $.ajax({
        url:"http://129.151.109.197:8080/api/Cabin/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
        
            let $select = $("#select-Cabin");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.id+'>'+name.name+'</option>');
         
            }); 
        }
    
    })
}

//Manejador "POST"
function agregarReservation() {
    
    if($("#startDate").val().length == 0 || $("#devolutionDate").val().length == 0 || $("#status").val().length == 0){
        alert("Todos los campos son Obligatorios")
    }else{  
        let elemento = {
            startDate: $("#startDate").val(),
            devolutionDate: $("#devolutionDate").val(),
            status: $("#status").val(),
            Cabin:{id: +$("#select-Cabin").val()},
            client:{idClient: +$("#select-client").val()},
            
        }

        let dataToSend = JSON.stringify(elemento);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url:"http://129.151.109.197:8080/api/Reservation/save",
            //url: "http://129.151.109.197:8080/api/Reservation/save",
            data: dataToSend,
            datatype: "json",

            success: function (response) {
                console.log(response);
                //Limpiar Campos
                $("#resultado5").empty();
                $("#startDate").val("");
                $("#devolutionDate").val("");
                $("#status").val("");

                //Listar Tabla

                alert("Se ha guardado Correctamente!")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se guardo Correctamente!")
            }
        });
    }
}



function listarReservation(){
    $.ajax({
        url:"http://129.151.109.197:8080/api/Reservation/all",
        //url: "http://129.151.109.197:8080/api/Reservation/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            pintarRespuestaReservation(response);
        }
    });
}

function pintarRespuestaReservation(response){
   
    let myTable="<table>";
    myTable+="<tr>";
        myTable+="<td>Fecha Inicio</td>";
        myTable+="<td>fecha Devolucion</td>";
        myTable+="<td>Estado</td>";
        myTable+="<td>Cabaña</td>";
        myTable+="<td>Cliente</td>";
     "</tr>";
      
    for(i=0;i<response.length;i++){
    myTable+="<tr>";
        myTable+="<td>"+response[i].startDate+"</td>";
        myTable+="<td>"+response[i].devolutionDate+"</td>";
        myTable+="<td>"+response[i].status+"</td>";
        myTable+="<td>"+response[i].Cabin.name+"</td>";
        myTable+="<td>"+response[i].client.name+"</td>";
        myTable+='<td><button class="botonsecundario" onclick="borrarReservation(' + response[i].idReservation + ')">Borrar Reserva!</button></td>';
        myTable+='<td><button class="botonsecundario" onclick="actualizarReservation(' + response[i].idReservation + ')">Actualizar Reserva!</button></td>';
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#miListaReservation").html(myTable);
}


//Manejador DELETE
function borrarReservation(idElemento) {
    let elemento = {
        id: idElemento
    }

    let dataToSend = JSON.stringify(elemento);

    $.ajax(
        {
            dataType: 'json',
            data: dataToSend,
            url:"http://129.151.109.197:8080/api/Reservation/"+idElemento,
            //url: "http://129.151.109.197:8080/api/Reservation/" + idElemento,
            type: 'DELETE',
            contentType: "application/JSON",
            success: function (response) {
                console.log(response);
                $("#miListaReservation").empty();

                alert("se ha Eliminado Correctamente!")
            },

            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se Elimino Correctamente!")
            }
        });
}

//Capturar informacion para Actualizar
function cargarDatosReservation(id) {
    $.ajax({
        dataType: 'json',
        url:"http://129.151.109.197:8080/api/Reservation/"+id,
        //url: "http://129.151.109.197:8080/api/Reservation/" + id,
        type: 'GET',

        success: function (response) {
            console.log(response);
            var item = response;

            $("#startDate").val(item.startDate);
            $("#devolutionDate").val(item.devolutionDate);
            $("#status").val(item.status);

        },

        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
}

//Manejador PUT
function actualizarReservation(idElemento) {
    
    if($("#startDate").val().length == 0 || $("#devolutionDate").val().length == 0 || $("#status").val().length == 0){
        alert("Todos los campos deben estar llenos")
    }else{
        let elemento = {
            idReservation: idElemento,
            startDate: $("#startDate").val(),
            devolutionDate: $("#devolutionDate").val(),
            status: $("#status").val(),
            Cabin:{id: +$("#select-Cabin").val()},
            client:{idClient: +$("#select-client").val()},
        }

        let dataToSend = JSON.stringify(elemento);

        $.ajax({
            datatype: 'json',
            data: dataToSend,
            contentType: "application/JSON",
            url:"http://129.151.109.197:8080/api/Reservation/update",
            //url: "http://129.151.109.197:8080/api/Reservation/update",
            type: "PUT",

            success: function (response) {
                console.log(response);
                $("#miListaReservation").empty();
                alert("se ha Actualizado Correctamente!")

                //Limpiar Campos
                $("#resultado5").empty();

                $("#startDate").val("");
                $("#devolutionDate").val("");
                $("#status").val("");

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se Actualizo Correctamente!")
            }
        });
    }
}