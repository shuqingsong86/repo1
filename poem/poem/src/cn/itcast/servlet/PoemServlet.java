package cn.itcast.servlet;

import cn.itcast.domain.Poem;
import cn.itcast.service.impl.poemServiceImpl;
import cn.itcast.service.poemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/poem/*")
public class PoemServlet extends BaseServlet {
    public void findPoems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        poemService service = new poemServiceImpl();
        List<Poem> list = service.findAll(category);
        //System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }
    public void findOneById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        poemService service = new poemServiceImpl();
        Poem poem = service.findOne(id);
  /*      System.out.println(poem);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),poem);*/
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(poem);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        System.out.println(json);

    }
}
