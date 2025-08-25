package Servlets;

import Entidades.paciente;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import com.google.gson.Gson;
import test.DAO.pacienteDAO;

@WebServlet("/api/AtualizarPaciente")
public class AtualizarPaciente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        paciente p = new Gson().fromJson(reader, paciente.class);

        pacienteDAO dao = new pacienteDAO();
        boolean sucesso = dao.atualizar(p);

        if (sucesso) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Paciente atualizado com sucesso.");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Erro ao atualizar paciente.");
        }
    }
}
