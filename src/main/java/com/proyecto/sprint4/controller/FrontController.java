package com.proyecto.sprint4.controller;


import com.proyecto.sprint4.entity.Employee;
import com.proyecto.sprint4.entity.Enterprise;
import com.proyecto.sprint4.entity.Transaction;
import com.proyecto.sprint4.service.EmployeeService;
import com.proyecto.sprint4.service.EnterpriseService;
import com.proyecto.sprint4.service.TransactionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontController {

    EnterpriseService servicio;
    EmployeeService servicio2;
    TransactionService servicio3;


    public FrontController(EnterpriseService servicio, EmployeeService servicio2, TransactionService servicio3) {
        this.servicio = servicio;
        this.servicio2 = servicio2;
        this.servicio3 = servicio3;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        return "index";
    }

    @GetMapping("/enterprise")
    public String enterprise(Model model){
        List<Enterprise> enterprise = this.servicio.listarEmpresa();
        model.addAttribute("enterprise", enterprise);
        return "enterprise";
    }

    @GetMapping("/enterprise/newEnterprise")
    public String newEnterprise(Model model){
        model.addAttribute("enterprise", new Enterprise());
        return "newEnterprise";
    }

    @GetMapping("/enterprise/gestionEnterprise")
    public String gestionEnterprise(){
        return "gestionEnterprise";
    }

    @GetMapping("/enterprise/gestionEnterprise/newEmployee")
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "newEmployee";
    }

    @GetMapping("/enterprise/gestionEnterprise/newTransaction")
    public String newTransaction(Model model){
        model.addAttribute("transaction", new Transaction());
        return "newTransaction";
    }

    @GetMapping("/enterprise/gestionEnterprise/employeeTable")
    public String employeeTable(Model model){
        List<Employee> employeeList = this.servicio2.listaEmpleados();
        model.addAttribute("employee", employeeList);
        return "employeeTable";
    }

    @GetMapping("/enterprise/gestionEnterprise/transactionTable")
    public String transactionTable(Model model){
        List<Transaction> transactionList = this.servicio3.listaMovimientos();
        model.addAttribute("transaction", transactionList);
        return "transactionTable";
    }

    @GetMapping("/enterprise/gestionEnterprise/eliminarEmployee")
    public String modiOElimEmployee(Model model){
        List<Employee> modiOElimEmployee = this.servicio2.listaEmpleados();
        model.addAttribute("employee", modiOElimEmployee);
        return "eliminarEmployee";
    }

    @GetMapping("/enterprise/gestionEnterprise/eliminarTransaction")
    public String modiOElimTransaction(Model model){
        List<Transaction> modiOElimTransaction = this.servicio3.listaMovimientos();
        model.addAttribute("transaction", modiOElimTransaction);
        return "eliminarTransaction";
    }

}
