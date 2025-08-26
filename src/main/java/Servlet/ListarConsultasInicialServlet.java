package Servlet;

import com.google.gson.Gson;
import test.DAO.consultaDAO;
import Entidades.consulta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/ListaconsultasInicial")
public class ListarConsultasInicialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      


        List<consulta> consultas;
        consultaDAO dao = new consultaDAO();

        try {
           
                consultas = dao.listar();
          

            response.setContentType("application/json");
            response.getWriter().write(new Gson().toJson(consultas));

        } catch (Exception e) {
            e.printStackTrace(); // log no console
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"erro\":\"Erro interno ao buscar consultas.\"}");
        }
    }
}
