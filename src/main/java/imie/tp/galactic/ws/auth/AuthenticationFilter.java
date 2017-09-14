package imie.tp.galactic.ws.auth;

import imie.tp.galactic.ws.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AuthenticationFilter implements Filter, Authenticator {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    private static final int GROUP_TOKEN = 1;
    private static final String LOGIN_ROUTE = "/api/login";

    private final LoginService loginService;

    @Autowired
    public AuthenticationFilter(LoginService loginService) {
        this.loginService = loginService;
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        if (!request.getServletPath().equals(LOGIN_ROUTE)) {
            if (!checkAuth((HttpServletRequest) req)) {
                ((HttpServletResponse) res).sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public boolean checkAuth(HttpServletRequest req) {
        String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null)
            return false;

        Pattern p = Pattern.compile("Token=(.*)");
        Matcher m = p.matcher(authHeader);

        if (!m.find())
            return false;

        String token = m.group(GROUP_TOKEN);

        if (token == null || token.trim().length() == 0)
            return false;

        if (!loginService.hasToken(token))
            return false;

        return true;
    }
}
