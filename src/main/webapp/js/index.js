$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });


});

function autenticarUsuario() {

    let email_usuario = $("#email_usuario").val();
    let password_usuario = $("#password_usuario").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            email_usuario: email_usuario,
            password_usuario: password_usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let email_usuario = parsedResult['email_usuario'];
                document.location.href = "home.html?email_usuario=" + email_usuario;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {
let id_usuario = $("#input-id_usuario").val();
let nombre_usuario = $("#input-nombre_usuario").val();
    let apellido_usuario = $("#input-apellido_usuario").val();
    let email_usuario = $("#input-email_usuario").val();
    let password_usuario = $("#input-password_usuario").val();
    let telefono_usuario = $("#input-telefono_usuario").val();
    let direccion_usuario = $("#input-direccion_usuario").val();
    let cod_rol = $("#input-cod_rol").val();


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRegister",
        data: $.param({
            
            id_usuario:id_usuario,
            nombre_usuario:nombre_usuario,
            apellido_usuario:apellido_usuario,
            email_usuario:email_usuario,
            password_usuario:password_usuario,
            telefono_usuario:telefono_usuario,
            direccion_usuario:direccion_usuario,
            cod_rol: cod_rol
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                $("#register-error").addClass("d-none");
                let  email_usuario = parsedResult['email_usuario'];
                document.location.href = "home.html?email_usuario=" + email_usuario;
            } else {
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Error en el registro del usuario");
            }
        }
    });
}
