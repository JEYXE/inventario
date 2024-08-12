$(document).ready(function() {
  // on ready
});


async function iniciarSesion() {
 let datos = {};
 datos.login = document.getElementById('login').value;
 datos.clave = document.getElementById('clave').value;

 const request = await fetch('/login', {
   method: 'POST',
   headers: {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
   },
   body: JSON.stringify(datos)
   
 });

 const respuesta = await request.json();
 alert( respuesta.token);
 if (respuesta.token != 'FAIL') {
   localStorage.token = respuesta.token;
   localStorage.email = datos.login;
   window.location.href = '/index.html'
 } else {
   alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
 }

 
 

}

async function iniciarSesion() {
  let datos = {};
  datos.login = document.getElementById('login').value;
  datos.clave = document.getElementById('clave').value;
 
  const request = await fetch('/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
    
  });
 
  const respuesta = await request.json();
  alert( respuesta.token);
  if (respuesta.token != 'FAIL') {
    localStorage.token = respuesta.token;
    localStorage.email = datos.login;
    window.location.href = '/index.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }
 
  
  
 
 }

 async function cosa() {
 
 
  const request = await fetch('/ejemplo', {
    method: 'GET',
    headers: {
      'Authorization': localStorage.token,
    },
    
    
  });
 
  const respuesta = await request.text();
  alert( respuesta);
    
 
 }