package com.appmusic.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appmusic.backend.models.Status;
import com.appmusic.backend.services.StatusService;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {
@Autowired
private StatusService statusService;

@GetMapping
public List<Album>getAllStatus() {
return  statusService.getStatus();

    @Autowired
        private StatusService statusService;
    
        @GetMapping
        public List<Status> getAllStatuses() {
            return statusService.getAllStatuses();
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
            Status status = statusService.getStatusById(id);
            return status != null ? ResponseEntity.ok(status) : ResponseEntity.notFound().build();
        }
    
        @PostMapping
        public Status createStatus(@RequestBody Status status) {
            return statusService.createStatus(status);
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status statusDetails) {
            Status updatedStatus = statusService.updateStatus(id, statusDetails);
            return updatedStatus != null ? ResponseEntity.ok(updatedStatus) : ResponseEntity.notFound().build();
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
            statusService.deleteStatus(id);
            return ResponseEntity.noContent().build();
        }
}


@GetMapping("/{id}")
public ResponseEntity<Status>getStatusById(@PathVariable Long id) { 
    Status status = statusService.getStatusById(id);
    return ResponseEntity.ok(status);
}
    
}
