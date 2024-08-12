package com.fontebo.inventario.Controlador;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fontebo.inventario.Servicios.ServicioToken;
import com.fontebo.inventario.Modelo.Usuario;
import com.fontebo.inventario.Registros.DatosAutenticacionUsuario;
import com.fontebo.inventario.Registros.DatosToken;

@RestController
@RequestMapping("/login")
public class ControladorLogin {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ServicioToken servicioToken;

    

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        System.out.println(datosAutenticacionUsuario);
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        System.out.println(authToken);
        try {
            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            System.out.println(usuarioAutenticado);
            var JWTtoken = servicioToken.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            System.out.println(JWTtoken);
            return ResponseEntity.ok(new DatosToken(JWTtoken));
        } catch (Exception e) {
            return ResponseEntity.ok("{\"jwTtoken\": \"FAIL\"}");
        }
       
        

    }

}
