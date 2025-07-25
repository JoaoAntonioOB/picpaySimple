package com.picpaysimple.services;

import com.picpaysimple.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message){
        String email = user.getEmail();

        ResponseEntity<String> = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);
    }
}
