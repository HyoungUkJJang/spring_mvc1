package hello.mypackage.chapter1.basic1.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.mypackage.chapter1.basic1.HelloData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name="responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("hyounguk");
        helloData.setAge(26);

        String result = objectMapper.writeValueAsString(helloData);

        PrintWriter writer = response.getWriter();
        writer.write(result);
    }
}
