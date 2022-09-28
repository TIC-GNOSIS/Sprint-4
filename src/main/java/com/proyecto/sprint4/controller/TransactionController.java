package com.proyecto.sprint4.controller;

import com.proyecto.sprint4.entity.Transaction;
import com.proyecto.sprint4.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService servicio;

//    @GetMapping("/transaction")
//    public List<Transaction> generarTransaction(){
//        return servicio.listaMovimientos();
//    }

    @PostMapping("/transaction")
    public RedirectView guardarTransaction(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Transaction transaction, Model model){
        model.addAttribute(transaction);
        servicio.guardarMovimiento(transaction);
        this.servicio.guardarMovimiento(transaction);
        return new RedirectView("/enterprise/gestionEnterprise/transactionTable");
    }

    @PatchMapping("/transaction/{id}")
    public ResponseEntity<?> actualizarTransaction(@RequestBody Transaction transaction, @PathVariable Long id){
        Transaction transactionExistente = servicio.buscarMovimientoPorId(id);
        servicio.guardarMovimiento(transaction);
        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }

    @GetMapping("/transaction/borrar/{id}")
    public RedirectView eliminarTransaction(@PathVariable("id") Long id){
        this.servicio.eliminarMovimiento(id);
        return new RedirectView("/enterprise/gestionEnterprise/eliminarTransaction");
    }


}
