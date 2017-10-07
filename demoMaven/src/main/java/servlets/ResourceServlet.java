package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resourceServer.ResourceServerControllerMBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by misha on 07.10.17.
 */
public class ResourceServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";
    private final ResourceServerControllerMBean resourceServerControllerMBean;

    public ResourceServlet(ResourceServerControllerMBean resourceServerControllerMBean) {
        this.resourceServerControllerMBean = resourceServerControllerMBean;
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String pathResources = request.getParameter("path");

        resourceServerControllerMBean.loadResource(pathResources);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}