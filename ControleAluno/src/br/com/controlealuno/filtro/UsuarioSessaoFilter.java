package br.com.controlealuno.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controlealuno.constant.ControleAlunoConstant;
import br.com.controlealuno.model.LoginEntity;

public class UsuarioSessaoFilter implements Filter {

	public UsuarioSessaoFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LoginEntity login = (LoginEntity) ((HttpServletRequest) request).getSession().getAttribute(ControleAlunoConstant.USER_SESSION);
		if (!((HttpServletRequest)request).getServletPath().equals("/login.jsp")){
			if (login != null){
				chain.doFilter(request, response);
			}else{
				((HttpServletResponse) response).sendRedirect("login.jsp");
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
