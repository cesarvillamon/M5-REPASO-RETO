package com.bancolombia.aplicacionbancaria.prestamo;

import com.bancolombia.aplicacionbancaria.cliente.Cliente;
import com.bancolombia.aplicacionbancaria.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Prestamo crearPrestamo(Prestamo prestamo, Long clienteId) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            prestamo.setCliente(cliente);
            prestamo.setEstado("Pendiente");
            return prestamoRepository.save(prestamo);
        }
        return null;
    }

    public Prestamo aprobarRechazarPrestamo(Long prestamoId, String estado) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(prestamoId);
        if (prestamoOpt.isPresent()) {
            Prestamo prestamo = prestamoOpt.get();
            prestamo.setEstado(estado);
            return prestamoRepository.save(prestamo);
        }
        return null;
    }

    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    public List<Prestamo> obtenerPrestamoPorCliente(Long id) {
        return prestamoRepository.findByClienteId(id);
    }

    public List<Prestamo> obtenerUltimosPrestamosPorCliente(Long id) {
        return prestamoRepository.findTop3ByClienteIdOrderByIdDesc(id);
    }
}



