import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThymeleafServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        TemplateEngine t = new TemplateEngine();
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setTemplateMode("HTML");

        resolver.setPrefix("./../webapps/DemoThymeLeaf/WEB-INF/templates/");
            
        resolver.setSuffix(".html");

        t.setTemplateResolver(resolver);
        Context c = new Context();

// printing text
        c.setVariable("temp", "hello Thymeleaf");
        //response.getWriter().print(t.process("Login", c));

// creating table
        List<Integer> data = new ArrayList<>();
        data.add(2);
        data.add(8);
        data.add(2001);
        c.setVariable("data", data);
        response.getWriter().print(t.process("Login", c));
    }
}