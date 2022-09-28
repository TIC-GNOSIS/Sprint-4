package com.proyecto.sprint4.service;

import com.proyecto.sprint4.entity.Enterprise;
import com.proyecto.sprint4.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository repositorio;

    public List<Enterprise> listarEmpresa() {
        return repositorio.findAll();
    }

    public void guardarEmpresa(Enterprise empresa) {
        repositorio.save(empresa);
    }

    public Enterprise buscarEmpresasPorId(Long id) {
        return repositorio.findById(id).get();
    }

    public void eliminarEmpresas(Long id) {
        repositorio.deleteById(id);

    }
}