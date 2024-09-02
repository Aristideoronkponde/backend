package com.appmusic.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class StatusController {
@Autowired
private StatusService statusService;

@GetMapping
public List<Status>getAllStatus() {
return  statusService.getStatus();

}


@GetMapping("/{id}")
public Status getStatusById(@PathVariable Long id) { 
    return statusService.getStatusById(id);
}
    
}
