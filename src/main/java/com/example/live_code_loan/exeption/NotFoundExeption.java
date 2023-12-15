package com.example.live_code_loan.exeption;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NotFoundExeption extends Exception {
    public NotFoundExeption(String message){super(message);}
}
