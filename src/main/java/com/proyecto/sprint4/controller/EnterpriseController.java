package com.proyecto.sprint4.controller;

import com.proyecto.sprint4.entity.Enterprise;
import com.proyecto.sprint4.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService servicio;

//    @GetMapping("/enterprise")
//    public List<Enterprise> generarEnterprise(){
//        return servicio.listarEmpresa();
//    }

    @PostMapping("/enterprise")
    public RedirectView guardarEnterprise(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.servicio.guardarEmpresa(enterprise);
        return new RedirectView("/enterprise");
    }

    @PatchMapping("/enterprise/{id}")
    public ResponseEntity<?> actualizarEnterprise(@RequestBody Enterprise enterprise, @PathVariable Long id){
        Enterprise enterpriseExistente = servicio.buscarEmpresasPorId(id);
        servicio.guardarEmpresa(enterprise);
        return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
    }

    @PostMapping("/enterprise/{id}")
    public RedirectView eliminarEnterprise(@PathVariable("id") Long id){
        this.servicio.eliminarEmpresas(id);
        return new RedirectView("/enterprise");
    }
}
