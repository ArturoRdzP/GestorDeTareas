package Logica;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Puedes realizar alguna inicialización si es necesario
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Obtén la URL solicitada
        String requestURI = httpRequest.getRequestURI();

        // Permitir el acceso a las páginas de inicio de sesión sin sesión
        if (requestURI.endsWith("login.xhtml") || requestURI.contains("javax.faces.resource")) {
            chain.doFilter(request, response);
            return;
        }

        // Redirigir al inicio de sesión si no hay token y la URL no es la de inicio de sesión
        if (session == null || session.getAttribute("userToken") == null) {
            System.out.println("Redirigiendo a login.xhtml desde: " + requestURI);
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml");
        } else {
            // Permitir el acceso si hay un token válido
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Puedes realizar alguna limpieza si es necesario
    }
}
