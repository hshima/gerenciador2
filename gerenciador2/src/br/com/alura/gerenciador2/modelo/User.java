package br.com.alura.gerenciador2.modelo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User {

    private String login;
    private String password;
    
    public User() {};
    public User(String login, String password) {
    	setLogin(login);
    	setPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(String login, String password) {
        if(!this.login.equals(login)) {
            return false;
        }

        if(!this.password.equals(password)) {
            return false;
        }

        return true;
    }
}