package servlets;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.persistence.*;
import java.io.IOException;
import test.DAO.consultaDAO;

@WebServlet("/api/ExcluirConsulta")
public class ExcluirConsultaServlet extends HttpServlet {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OdontoPU");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        consultaDAO dao = new consultaDAO();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.excluir(id);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            em.close();
        }
    }
}
