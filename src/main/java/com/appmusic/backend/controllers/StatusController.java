package com.appmusic.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appmusic.backend.models.Album;
import com.appmusic.backend.models.Status;
import com.appmusic.backend.services.StatusService;

@RestController
@RequestMapping("/api/users")
public class StatusController {
@Autowired
private StatusService statusService;

@GetMapping
public List<Album>getAllStatus() {
return  statusService.getStatus();

}


@GetMapping("/{id}")
public ResponseEntity<Status>getStatusById(@PathVariable Long id) { 
    Status status = statusService.getStatusById(id);
    return ResponseEntity.ok(status);
}
    
}
