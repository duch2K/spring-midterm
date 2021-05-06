package iitu.midterm.demo.events.handlers;

import iitu.midterm.demo.events.ChangeRequestStatus;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChangeRequestStatusHandler implements ApplicationListener<ChangeRequestStatus> {

    @Override
    public void onApplicationEvent(ChangeRequestStatus changeOrderStatus) {
        System.out.println("ChangeRequestStatusHandler is triggered!");
        System.out.println("Request ID: " + changeOrderStatus.getRequest().getId());
        System.out.println("Old status: " + changeOrderStatus.getOldStatus());
        System.out.println("New status: " + changeOrderStatus.getRequest().getStatus());
    }
}
