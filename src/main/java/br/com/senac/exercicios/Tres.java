package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
// http://localhost:8080/java-web-demo/calculadora?n1=1&n2=2&operacao=multiplicacao
@WebServlet("/calculadora")
public class Tres extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            double n1 = Double.parseDouble(req.getParameter("n1"));
            double n2 = Double.parseDouble(req.getParameter("n2"));
            String operacao = req.getParameter("operacao");

            double resultado;
            switch (operacao) {

                case "soma":
                    resultado = n1 + n2;
                    out.println("<h1>Resultado: " + resultado + "</h1>");
                    break;

                case "subtracao":
                    resultado = n1 - n2;
                    out.println("<h1>Resultado: " + resultado + "</h1>");
                    break;

                case "multiplicacao":
                    resultado = n1 * n2;
                    out.println("<h1>Resultado: " + resultado + "</h1>");
                    break;

                case "divisao":
                    if (n2 == 0) {
                        out.println("<h1>Erro: não é possível dividir por zero.</h1>");
                    } else {
                        resultado = n1 / n2;
                        out.println("<h1>Resultado: " + resultado + "</h1>");
                    }
                    break;

                default:
                    out.println("<h1>Operação inválida");
            }

        } catch (NumberFormatException e) {
            out.println("<h1 style=\"color:red\"> Erro: parâmetros inválidos. Use números em n1 e n2.</h1>");
        }
    }

}
