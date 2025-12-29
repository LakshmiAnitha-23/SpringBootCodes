package com.example.HyderabadCRUD.controller;

import com.example.HyderabadCRUD.entity.Hyderabad;
import com.example.HyderabadCRUD.service.HyderabadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hyderabad")
public class HyderabadController
{
    private final HyderabadService service;

    public HyderabadController(HyderabadService service)
    {
        this.service = service;
    }

    @PostMapping
    public Hyderabad create(@RequestBody Hyderabad h)
    {
        return service.saveHyderabad(h);
    }

    @GetMapping
    public List<Hyderabad> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Hyderabad getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Hyderabad update(@PathVariable Long id, @RequestBody Hyderabad h)
    {
        return service.updateHyderabad(id, h);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        service.deleteHyderabad(id);
        return "Hyderabad record deleted successfully";
    }
}
