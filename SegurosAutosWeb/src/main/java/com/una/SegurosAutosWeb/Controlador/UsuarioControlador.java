package com.una.SegurosAutosWeb.Controlador;

import com.una.SegurosAutosWeb.Modelos.Usuario;
import com.una.SegurosAutosWeb.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    UsuarioServicio servicio;

    @GetMapping("/usuarios")
    public  String findAll(Model model){
        List<Usuario> usuarios = servicio.findAllUser(); // asignando a la variable "usuarios" una lista de objetos de tipo "Usuario".
        model.addAttribute("usuarios", servicio.findAllUser());
        return "usuarios";
    }

    @GetMapping("/test")
    public  String test(){
        Usuario user = new Usuario();
        user.setId(4L);
        user.setNombre("Carlos Alvarez Ramirez");
        user.setTelefono("1233123");
        user.setEmail("Carlos@gmail");
        user.setUsername("Bavaria");
        user.setPassword("1234");
        user.setRol("Admin");
        servicio.addUser(user);
        return "index";
    }

    @GetMapping ("/addUser")
    public String addUser(){
        return  "addUser";
    }




    @PostMapping("/saveUsuarios")
        public String saveUser(@ModelAttribute("Usuario") Usuario user) {
        servicio.addUser(user);
        return "redirect:/usuarios";
    }


}