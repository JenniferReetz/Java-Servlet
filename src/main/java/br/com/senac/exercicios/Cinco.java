package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pedido/*")
public class Cinco extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String pathInfo = req.getPathInfo();
        if (pathInfo == null) {
            out.println("<h1>URL inválida — formato esperado: /pedido/{numero}/item/{numero}</h1>");
            return;
        }
        String[] partes = pathInfo.split("/");
        if (partes.length != 4) {
            out.println("<h1>URL inválida — formato esperado: /pedido/{numero}/item/{numero}</h1>");
            return;
        }
        try {
            String numeroPedidoStr = partes[1];
            String itemStrLiteral = partes[2];
            String numeroItemStr = partes[3];

            if (!itemStrLiteral.equals("item")) {
                out.println("<h1>URL inválida — formato esperado: /pedido/{numero}/item/{numero}</h1>");
                return;
            }
            int numeroPedido = Integer.parseInt(numeroPedidoStr);
            int numeroItem = Integer.parseInt(numeroItemStr);
            out.println("<h1>Pedido número " + numeroPedido + ", item número " + numeroItem + "</h1>");

        } catch (NumberFormatException e) {
            out.println("<h1>Erro: os valores devem ser números válidos.</h1>");
        }
    }
}
