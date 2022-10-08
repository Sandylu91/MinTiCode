const usuario= "sandra@hotmail.com"
const clave= 123456

function verificar(){
    let usuario1= document.getElementById("email_usuario").value
    let clave1= document.getElementById("password_usuario").value

    if(usuario==usuario1 && clave==clave1){

        alert("Bienvenid@ ")
        }
        else{
            alert("Verifique sus datos")
        }
}