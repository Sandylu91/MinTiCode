var email_usuario = new URL(location.href).searchParams.get("email_usuario");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","perfil.html?email_usuario=" + email_usuario);
        
        $("#user-saldo").html("Bienvenido usuario "+user.email_usuario);
         getProvedores(false, "ASC");

         
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            email_usuario: email_usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}

function getProvedores(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProveedoresListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarProveedores(parsedResult);
            } else {
                console.log("Error recuperando los datos de las usuarios");
            }
        }
    });
    function mostrarProveedores(usuarios) {

    let contenido = "";

    $.each(usuarios, function (index, usuario) {

        usuario = JSON.parse(usuario);
       

    contenido += '<tr><th scope="row">' + usuario.id_usuario + '</th>' +
                    '<td>' + usuario.nombre_usuario+ '</td>' +
                    '<td>' + usuario.apellido_usuario + '</td>' +
                    '<td>' + usuario.email_usuario + '</td>' +
                    '<td>' + usuario.telefono_usuario + '</td>' +
                    '<td>' + usuario.direccion_usuario + '</td>' +
                    '<td>' + usuario.cod_rol + '</td>'+
                    '<td><button class="button">Modificar</button></td>'+
                    '<td><button class="button">Eliminar</button></td></tr>';
            
    });
    $("#usuarios-tbody").html(contenido);
}

}