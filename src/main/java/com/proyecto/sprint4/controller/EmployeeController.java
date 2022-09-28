package com.proyecto.sprint4.controller;

import com.proyecto.sprint4.entity.Employee;
import com.proyecto.sprint4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService servicio;

//    @GetMapping("/employee")
//    public List<Employee> generarEmployee(){
//        return servicio.listaEmpleados();
//    }

    @PostMapping("/employee")
    public RedirectView guardarEmployee(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Employee employee, Model model){
        model.addAttribute(employee);
        this.servicio.guardarEmpleado(employee);
        return new RedirectView("/enterprise/gestionEnterprise/employeeTable");
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<?> actualizarEmployee(@RequestBody Employee employee, @PathVariable Long id){
        Employee employeExistente = servicio.buscarEmpleadoPorId(id);
        servicio.guardarEmpleado(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @GetMapping("/employee/borrar/{id}")
    public RedirectView eliminarEmployee(@PathVariable("id") Long id ){
        this.servicio.eliminarEmpleado(id);
        return new RedirectView("/enterprise/gestionEnterprise/eliminarEmployee");
    }

}
