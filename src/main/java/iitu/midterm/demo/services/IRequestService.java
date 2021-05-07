package iitu.midterm.demo.services;

import iitu.midterm.demo.entities.Request;
import iitu.midterm.demo.models.RequestStatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRequestService {
    List<Request> getAll();
    List<Request> getRequestById(Long userId);
    Request createNew(Request request);
    Request changeRequestStatus(Long requestId, RequestStatusEnum status);
}
