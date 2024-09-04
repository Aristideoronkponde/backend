package com.appmusic.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.models.Status;
import com.appmusic.backend.repositories.StatusRepository;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository; 

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status getStatusById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(Long id, Status updatedStatus) {
        Status status = statusRepository.findById(id).orElse(null);
        if (status != null) {
            status.setName(updatedStatus.getName());
            return statusRepository.save(status);
        }
        return null;
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
