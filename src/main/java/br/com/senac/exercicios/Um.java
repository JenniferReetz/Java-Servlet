package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/info")
public class Um extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h1>Desenvolvimento Web com Java</h1>");
        resp.getWriter().println("<h1>Data de hoje: "+LocalDate.now()+"</h1>");
        resp.getWriter().println("<h1>Versão do Java: "+System.getProperty("java.version")+"</h1>");
    }
}