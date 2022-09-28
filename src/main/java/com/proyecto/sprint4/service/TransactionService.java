package com.proyecto.sprint4.service;

import com.proyecto.sprint4.entity.Transaction;
import com.proyecto.sprint4.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repositorio;

    public List<Transaction> listaMovimientos(){
        return repositorio.findAll();
    }

    public void guardarMovimiento(Transaction movimientos){
        repositorio.save(movimientos);
    }

    public Transaction buscarMovimientoPorId(Long id){
        return repositorio.findById(id).get();
    }

    public void eliminarMovimiento(Long id){
        repositorio.deleteById(id);
    }
}
