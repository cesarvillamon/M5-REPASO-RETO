package com.bancolombia.aplicacionbancaria.controller;
import com.bancolombia.aplicacionbancaria.prestamo.Prestamo;
import com.bancolombia.aplicacionbancaria.prestamo.PrestamoDTO;
import com.bancolombia.aplicacionbancaria.prestamo.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<Prestamo> crearPrestamo(@RequestBody PrestamoDTO prestamoDTO,
                                                  @RequestParam Long clienteId) {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(prestamoDTO.getMonto());
        prestamo.setInteres(prestamoDTO.getInteres());
        prestamo.setDuracionMeses(prestamoDTO.getDuracionMeses());

        Prestamo prestamoCreado = prestamoService.crearPrestamo(prestamo, clienteId);
        return ResponseEntity.ok(prestamoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> aprobarRechazarPrestamo(@PathVariable Long id, @RequestParam String estado) {
        Prestamo prestamoActualizado = prestamoService.aprobarRechazarPrestamo(id, estado);
        return prestamoActualizado != null ? ResponseEntity.ok(prestamoActualizado) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPrestamoPorId(@PathVariable Long id) {
        return prestamoService.obtenerPrestamoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}



