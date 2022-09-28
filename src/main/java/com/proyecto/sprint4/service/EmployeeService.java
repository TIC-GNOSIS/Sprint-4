package com.proyecto.sprint4.service;

import com.proyecto.sprint4.entity.Employee;
import com.proyecto.sprint4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repositorio;

    public List<Employee> listaEmpleados() {
        return repositorio.findAll();
    }

    public void guardarEmpleado(Employee empleado) {
        repositorio.save(empleado);
    }

    public Employee buscarEmpleadoPorId(Long id) {
        return repositorio.findById(id).get();
    }

    public void eliminarEmpleado(Long id) {
        repositorio.deleteById(id);

    }
}