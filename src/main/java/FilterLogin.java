
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter("/*")
public class FilterLogin implements Filter {
	public static final String ACCES_PUBLIC     = "/WEB-INF/views/Login.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
	private ServletContext context;
    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String requestPath = request.getRequestURI();

        if (requestPath.endsWith("Login.jsp")
                || requestPath.endsWith("Login_servlet")) {
            chain.doFilter(request, response);
            System.out.println(request.getSession(false));
            return;
        }
        

        if (session == null || session.getAttribute("sessionUtilisateur") == null) {
        	((HttpServletResponse) res).sendRedirect(request.getContextPath() +"/Login_servlet");
        	//response.sendRedirect(request.getContextPath() + "/WEB-INF/views/Login.jsp");
        } else {
            chain.doFilter(request, response);
        }
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//this.context = fConfig.getServletContext();
		//this.context.log("AuthenticationFilter initialized");
	}

}
