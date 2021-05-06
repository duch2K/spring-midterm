package iitu.midterm.demo.events;

import iitu.midterm.demo.entities.Request;
import iitu.midterm.demo.models.RequestStatusEnum;
import org.springframework.context.ApplicationEvent;

public class ChangeRequestStatus extends ApplicationEvent {
    private RequestStatusEnum oldStatus;
    private Request request;

    public ChangeRequestStatus(Object source, RequestStatusEnum oldStatus, Request request) {
        super(source);
        this.oldStatus = oldStatus;
        this.request = request;
    }

    public RequestStatusEnum getOldStatus() {
        return oldStatus;
    }

    public Request getRequest() {
        return request;
    }
}
