/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;



import Entidades.paciente;
import test.DAO.pacienteDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet("/api/CadastrarPaciente")
public class PacienteCadastrarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            paciente novoPaciente = new paciente();
            novoPaciente.setNome(request.getParameter("nome"));
            novoPaciente.setCpf(request.getParameter("cpf"));
            novoPaciente.setEndereco(request.getParameter("endereco"));
            novoPaciente.setTelefone(request.getParameter("telefone"));
            novoPaciente.setEmail(request.getParameter("email"));
            novoPaciente.setHistorico_medico(request.getParameter("histMed"));

            String dataNascStr = request.getParameter("dataNasc");
         
                novoPaciente.setDataNasc(dataNascStr);
           

            pacienteDAO dao = new pacienteDAO();
            dao.cadastrar(novoPaciente);

 response.getWriter().write("{\"status\":\"success\", \"mensagem\":\"Paciente cadastrado com sucesso!\"}");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\", \"mensagem\":\"Erro ao cadastrar paciente.\"}");
        }
    }
}
