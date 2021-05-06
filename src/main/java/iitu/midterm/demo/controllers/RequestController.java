package iitu.midterm.demo.controllers;

import iitu.midterm.demo.entities.Request;
import iitu.midterm.demo.models.RequestStatusEnum;
import iitu.midterm.demo.services.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    private IRequestService iRequestService;

    // GET
    @GetMapping("")
    public ResponseEntity<?> getRequestByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(iRequestService.getRequestById(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRequest() {
        return ResponseEntity.ok(iRequestService.getAll());
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewRequest(@RequestBody Request request) {
        return ResponseEntity.ok(iRequestService.createNew(request));
    }

    //PATCH
    @PatchMapping("/{id}/change-request-status")
    public ResponseEntity<?> changeRequestStatus(@PathVariable("id") Long id, @RequestBody RequestStatusEnum status) {
        return ResponseEntity.ok(iRequestService.changeRequestStatus(id, status));
    }
}
