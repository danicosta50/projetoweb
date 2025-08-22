package Servlets;

import test.DAO.pacienteDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/api/ExcluirPaciente")
public class PacienteExcluirServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

      
        String idParam = request.getParameter("id");

        try {
            int id = Integer.parseInt(idParam); 

            pacienteDAO dao = new pacienteDAO();
            dao.excluir(id);

            response.setStatus(HttpServletResponse.SC_OK); 
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); 
            response.getWriter().write("Erro ao excluir paciente: " + e.getMessage());
        }
    }
}
