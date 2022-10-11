var email_usuario = new URL(location.href).searchParams.get("email_usuario");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

         $("#user-saldo").html("Usuario "+user.email_usuario);

        getProvedores(false, "ASC");
    });

    $("#reservar-btn").attr("href", `home.html?email_usuario=${email_usuario}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            email_usuario: email_usuario,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-email_usuario").val(parsedResult.email_usuario);
                $("#input-password_usuario").val(parsedResult.password_usuario);
                $("#input-nombre_usuario").val(parsedResult.nombre_usuario);
                $("#input-apellido_usuario").val(parsedResult.apellido_usuario);
                $("#input-telefono_usuario").val(parsedResult.telefono_usuario);
                $("#input-direccion_usuario").val(parsedResult.direccion_usuario);
               

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}


function modificarUsuario() {

    let email_usuario = $("#input-email_usuario").val();
    let password_usuario = $("#input-password_usuario").val();
    let nombre_usuario = $("#input-nombre_usuario").val();
    let apellido_usuario = $("#input-apellido_usuario").val();
    let telefono_usuario = $("#input-telefono_usuario").val();
    let direccion_usuario = $("#input-direccion_usuario").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            email_usuario: email_usuario,
            password_usuario: password_usuario,
            nombre_usuario: nombre_usuario,
            apellido_usuario: apellido_usuario,
            direccion_usuario:direccion_usuario,
            
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            email_usuario: email_usuario
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}