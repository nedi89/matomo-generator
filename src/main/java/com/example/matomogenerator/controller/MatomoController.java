package com.example.matomogenerator.controller;

import com.example.matomogenerator.entity.MatomoEntity;
import com.example.matomogenerator.repository.MatomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matomo")
public class MatomoController {
    private final MatomoRepository matomoRepository;

    @Autowired
    public MatomoController(MatomoRepository matomoRepository) {
        this.matomoRepository = matomoRepository;
    }


    @PostMapping("/create")
    public ResponseEntity<MatomoEntity> createMatomo(@RequestBody MatomoEntity matomo) {
        if (matomoRepository.findByNameAndNamespace(matomo.getName(), matomo.getNamespace()).isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        MatomoEntity savedMatomo = matomoRepository.save(matomo);
        return ResponseEntity.ok(savedMatomo);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MatomoEntity>> getAllMatomo() {
        List<MatomoEntity> matomoList = matomoRepository.findAll();
        return ResponseEntity.ok(matomoList);
    }
}