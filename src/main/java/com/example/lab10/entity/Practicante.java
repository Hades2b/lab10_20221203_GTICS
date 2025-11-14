package com.example.lab10.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "practicantes")
public class Practicante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPracticante;

    private String nombre;
    private String carrera;
    private String universidad;
    private String email;
    private String pais;
    private String estado;



    // Get Set
    public Integer getId() {
        return idPracticante;
    }
    public void setId(Integer idPracticante) {
        this.idPracticante = idPracticante;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUniversidad() {
        return universidad;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
