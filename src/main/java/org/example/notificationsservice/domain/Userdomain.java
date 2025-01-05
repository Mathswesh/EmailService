package org.example.notificationsservice.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Userdomain implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
}