package api;
import Entidades.paciente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.DAO.pacienteDAO;


import com.google.gson.Gson;

@WebServlet("/api/Listapacientes")
public class PacienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");

        pacienteDAO dao = new pacienteDAO();
        List<paciente> pacientes = dao.listar(nome != null ? nome : "", cpf != null ? cpf : "");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // converter lista para JSON
        String json = new Gson().toJson(pacientes);
        response.getWriter().write(json);
    }
}
