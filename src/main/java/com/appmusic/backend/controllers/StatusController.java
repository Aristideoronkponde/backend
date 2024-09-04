package com.appmusic.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import com.appmusic.backend.models.Status;
import com.appmusic.backend.services.StatusService;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Status createStatus(@RequestBody Status status) {
        return statusService.createStatus(status);
    }

    @PutMapping("/{id}")
    @Transactional
    public Status updateStatus(@PathVariable Long id, @RequestBody Status statusDetails) {
        return statusService.updateStatus(id, statusDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}
