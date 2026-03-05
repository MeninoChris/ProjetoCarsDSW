package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String carName = request.getParameter("car-name");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String jsonResponse;

        // Tratamento de erros caso usuario nao digite nada
        if(carName == null || carName.isEmpty()){
            jsonResponse = "{ \"error\": \"Um Carro é requerido.\" }";
        } else {
            jsonResponse = "{ \"carName\": \"" + carName + "\", \"message\": \"Carro Criado Com Sucesso\" }";
        }

        response.getWriter().write(jsonResponse);

        /*
        Alteração servlet para retornar um JSON.
        Em vez de redirecionar para a página HTML.
        Usando response.setContentType("application/json")
        E escrevi o JSON diretamente na resposta usando o response.getWriter().
         */

        /*
        Pensei, e se o usuario nao digitar nada e apertar o botão para cadastrar?
        Então adicionei uma verificação simples para ver se esta vazio ou não.
         */
    }
}