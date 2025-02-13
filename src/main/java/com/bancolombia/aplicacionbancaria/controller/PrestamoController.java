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
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<PrestamoDTO> crearPrestamo(@RequestBody PrestamoDTO prestamoDTO,
                                                  @RequestParam Long clienteId) {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(prestamoDTO.getMonto());
        prestamo.setInteres(prestamoDTO.getInteres());
        prestamo.setDuracionMeses(prestamoDTO.getDuracionMeses());

        Prestamo prestamoCreado = prestamoService.crearPrestamo(prestamo, clienteId);
        PrestamoDTO prestamoDTO1 = new PrestamoDTO(prestamoCreado.getId(),prestamoCreado.getMonto(),prestamoCreado.getInteres(),prestamoCreado.getDuracionMeses(),prestamoCreado.getEstado());
        return ResponseEntity.ok(prestamoDTO1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> aprobarRechazarPrestamo(@PathVariable Long id, @RequestParam String estado) {
        Prestamo prestamoActualizado = prestamoService.aprobarRechazarPrestamo(id, estado);
        return prestamoActualizado != null ? ResponseEntity.ok(prestamoActualizado) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> obtenerPrestamoPorId(@PathVariable Long id) {
        Optional<Prestamo> prestamo = prestamoService.obtenerPrestamoPorId(id);
        PrestamoDTO prestamoDTO = new PrestamoDTO(prestamo.get().getId(),prestamo.get().getMonto(),prestamo.get().getInteres(),prestamo.get().getDuracionMeses(),prestamo.get().getEstado());
        return ResponseEntity.ok(prestamoDTO);
    }

    @PostMapping("/simularcuotas/{id}")
    public ResponseEntity<BigDecimal> simularCuotas(@PathVariable Long id) {
        Optional<Prestamo> prestamo = prestamoService.obtenerPrestamoPorId(id);
        if(prestamo.isPresent()){
            BigDecimal cuota = (prestamo.get().getMonto().multiply(prestamo.get().getInteres())).divide(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(prestamo.get().getDuracionMeses()));
            return ResponseEntity.ok(cuota);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/prestamoporcliente/{id}")
    public ResponseEntity<List<PrestamoDTO>> obtenerPrestamoPorCliente(@PathVariable Long id) {
        List<Prestamo> prestamos = prestamoService.obtenerPrestamoPorCliente(id);
        List<PrestamoDTO> prestamoDTOs = prestamos.stream()
                .map(prestamo -> new PrestamoDTO(
                        prestamo.getId(),
                        prestamo.getMonto(),
                        prestamo.getInteres(),
                        prestamo.getDuracionMeses(),
                        prestamo.getEstado()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(prestamoDTOs);
    }

    @GetMapping("/ultimosprestamoporcliente/{id}")
    public ResponseEntity<List<PrestamoDTO>> obtenerUltimosPrestamosPorCliente(@PathVariable Long id) {
        List<Prestamo> prestamos = prestamoService.obtenerUltimosPrestamosPorCliente(id);
        List<PrestamoDTO> prestamoDTOs = prestamos.stream()
                .map(prestamo -> new PrestamoDTO(
                        prestamo.getId(),
                        prestamo.getMonto(),
                        prestamo.getInteres(),
                        prestamo.getDuracionMeses(),
                        prestamo.getEstado()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(prestamoDTOs);
    }

}



