package com.una.SegurosAutosWeb.Controlador;
import com.una.SegurosAutosWeb.Modelos.Auto;
import com.una.SegurosAutosWeb.Servicio.AutoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Controller
public class AutoControlador {
    @Autowired
    AutoServicio servicio;

    @GetMapping("/autos")
    public  String findAll(Model model){
        List<Auto> autos = servicio.findAllAuto();// asignando a la variable "autos" una lista de objetos de tipo "Auto".
        model.addAttribute("autos", servicio.findAllAuto());
        return "autos";
    }
    @GetMapping ("/addAuto")
    public String addUser(){
        return  "addAuto";
    }

    @PostMapping("/saveAutos")
    public String saveUser(@ModelAttribute("auto") Auto auto) {
        JdbcAggregateOperations userRepository;
        servicio.addAuto(auto);
        return "redirect:/autos";
    }
}
