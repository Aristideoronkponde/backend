package com.appmusic.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appmusic.backend.models.Status;
import com.appmusic.backend.repositories.StatusRepository;

@Service
@Transactional
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status getStatusById(Long id) {
        return statusRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Status not found"));
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(Long id, Status statusDetails) {
        Status status = getStatusById(id);
        status.setStatus(statusDetails.getStatus());
        return statusRepository.save(status);
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
