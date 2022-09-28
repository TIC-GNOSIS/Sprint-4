package com.proyecto.sprint4.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float montoDelMovimiento;
    private String conceptoDelMovimiento;

    public Transaction() {

    }

    public Transaction(Long id, float montoDelMovimiento, String conceptoDelMovimiento) {
        this.id = id;
        this.montoDelMovimiento = montoDelMovimiento;
        this.conceptoDelMovimiento = conceptoDelMovimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMontoDelMovimiento() {
        return montoDelMovimiento;
    }

    public void setMontoDelMovimiento(float montoDelMovimiento) {
        this.montoDelMovimiento = montoDelMovimiento;
    }

    public String getConceptoDelMovimiento() {
        return conceptoDelMovimiento;
    }

    public void setConceptoDelMovimiento(String conceptoDelMovimiento) {
        this.conceptoDelMovimiento = conceptoDelMovimiento;
    }

    public void monto(){
        if(montoDelMovimiento > 0){
            System.out.println("monto positivo");
        }else{
            System.out.println("monto negativo");
        }
    }
}
