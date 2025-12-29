package com.example.OTTCRUD.controller;

import com.example.OTTCRUD.entity.OttPlatform;
import com.example.OTTCRUD.service.OttService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ott")
public class OttController
{
    private final OttService service;

    public OttController(OttService service)
    {
        this.service = service;
    }

    @PostMapping
    public OttPlatform createOtt(@RequestBody OttPlatform ott)
    {
        return service.saveOtt(ott);
    }

    @GetMapping
    public List<OttPlatform> getAllOtts()
    {
        return service.getAllOtts();
    }

    @GetMapping("/{id}")
    public OttPlatform getOttById(@PathVariable Long id)
    {
        return service.getOttById(id);
    }

    @PutMapping("/{id}")
    public OttPlatform updateOtt(@PathVariable Long id, @RequestBody OttPlatform ott)
    {
        return service.updateOtt(id, ott);
    }

    @DeleteMapping("/{id}")
    public String deleteOtt(@PathVariable Long id)
    {
        service.deleteOtt(id);
        return "ott platform deleted successfully";
    }

}
