package com.example.lab10.controller;

import com.example.lab10.entity.Practicante;
import com.example.lab10.repository.PracticanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/practicantes/api")
public class PracticanteApiController {

    private final PracticanteRepository practicanteRepository;

    public PracticanteApiController(PracticanteRepository practicanteRepository) {
        this.practicanteRepository = practicanteRepository;
    }

    @GetMapping("")
    public List<Practicante> listar() {
        return practicanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id) {
        Optional<Practicante> practicante = practicanteRepository.findById(id);
        if (practicante.isPresent()) {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.OK.value(),
                    "practicante", practicante.get()
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } else {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Practicante con ID: "+id+" no encontrado"
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }
    }


    @PostMapping("/product")
    public ResponseEntity<?> crearProducto(@RequestBody Practicante practicante) {
        practicanteRepository.save(practicante);

        Map<String, Object> responseBody = Map.of(
                "status", HttpStatus.OK.value(),
                "mensaje","Practicante actualizado con éxito",
                "practicante", practicante
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping("/product")
    public ResponseEntity<?> actualizarProducto(@RequestBody Practicante practicante) {
        boolean existe = practicanteRepository.existsById(practicante.getId());
        if (existe) {
            practicanteRepository.save(practicante);

            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.OK.value(),
                    "mensaje",  "Practicante actualizado con éxito",
                    "practicante", practicante
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        } else {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Producto con ID: "+practicante.getId()+" no encontrado"
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        boolean exist = practicanteRepository.existsById(id);
        if (exist) {
            practicanteRepository.deleteById(id);

            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.OK.value(),
                    "mensaje", "Practicante eliminado con éxito"
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);

        } else {
            Map<String, Object> responseBody = Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", "Practicante con ID: "+id+" no encontrado"
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }
    }

}
