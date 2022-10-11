reg_nombres = document.getElementById("nombre_usuario");
reg_apellidos = document.getElementById("apellido_usuario");
reg_telefono = document.getElementById("telefono_usuario");
reg_documento = document.getElementById("id_usuario");
reg_email = document.getElementById("email_usuario");
reg_direccion = document.getElementById("direccion_usuario");
reg_contraseña = document.getElementById("password_usuario");
reg_perfil = document.getElementById("cod_rol");
 var perfil;

function imprimir() {
 perfil = reg_perfil.value;

  if (perfil == 1) {
    perfil = "Cliente";
  } else if (perfil == 2) {
    perfil = "Proveedor";
  } else {
    perfil = "Perfil no seleccionado";
  }

  alert(
    "Se ha realizado el registro exitosamente \n Nombre: " +
      reg_nombres.value 
      +
      "\n Apellido: " +
      reg_apellidos.value +
       "\n Telefono: " +
      reg_telefono.value +
       "\n Documento: " +
       reg_documento.value +
       "\n Email: " +
       reg_email.value +
       "\n Usuario: " +
       reg_direccion.value +
       "\n Contraseña: " +
       reg_contraseña.value +
      "\n Perfil: " +
      perfil
  );
}
