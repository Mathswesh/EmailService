package org.example.notificationsservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.notificationsservice.Mail.EmailService;
import org.example.notificationsservice.domain.Userdomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class EmailConsumer {

    @Autowired
    private EmailService emailService;
    @JmsListener(destination = "queue-one")
    public void consumeEmail(String user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Userdomain userdomain = mapper.readValue(user, Userdomain.class);
        emailService.sendSimpleMail(userdomain.getEmail(),"Success message","your regostration is sucessfull");
        System.out.println(userdomain);
    }
}
