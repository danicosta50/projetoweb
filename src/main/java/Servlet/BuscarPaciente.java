package Servlets;

import Entidades.paciente;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.google.gson.Gson;
import test.DAO.pacienteDAO;

@WebServlet("/api/BuscarPaciente")
public class BuscarPaciente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("ID não informado.");
            return;
        }

        int id = Integer.parseInt(idParam);
        pacienteDAO dao = new pacienteDAO();
        paciente p = dao.buscarPorId(id);

        if (p == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Paciente não encontrado.");
            return;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = new Gson().toJson(p);
        response.getWriter().write(json);
    }
}
