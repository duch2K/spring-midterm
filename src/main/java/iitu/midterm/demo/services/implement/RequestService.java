package iitu.midterm.demo.services.implement;

import iitu.midterm.demo.entities.Request;
import iitu.midterm.demo.events.ChangeRequestStatus;
import iitu.midterm.demo.models.RequestStatusEnum;
import iitu.midterm.demo.repositories.RequestRepository;
import iitu.midterm.demo.services.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RequestService implements IRequestService, ApplicationEventPublisherAware {
    @Autowired
    private RequestRepository requestRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getRequestById(Long userId) {
        return requestRepository.getRequestsByUserId(userId);
    }

    @Override
    public Request createNew(Request request) {
        request.setDay(new Date());
        Request saveRequest = requestRepository.saveAndFlush(request);

        for (int i = 0; i < saveRequest.getRequestItems().size(); i++) {
            saveRequest.getRequestItems().get(i).setRequestId(saveRequest.getId());
        }

        return requestRepository.saveAndFlush(saveRequest);
    }

    @Override
    public Request changeRequestStatus(Long requestId, RequestStatusEnum status) {
        Request request = requestRepository.getOne(requestId);
        RequestStatusEnum oldStatus = request.getStatus();
        request.setStatus(status);
        eventPublisher.publishEvent(new ChangeRequestStatus(this, oldStatus, request));
        return requestRepository.saveAndFlush(request);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
