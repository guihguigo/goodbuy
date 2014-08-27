package br.com.caelum.goodbuy.interceptors;

import br.com.caelum.goodbuy.controller.Restrito;
import br.com.caelum.goodbuy.controller.UsuariosController;
import br.com.caelum.goodbuy.modelo.UsuarioWeb;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class AutenticacaoInterceptor implements Interceptor{
	private final UsuarioWeb usuarioWeb;
	private final Result result;
	
	public AutenticacaoInterceptor(UsuarioWeb usuarioWeb, Result result) {
		this.usuarioWeb = usuarioWeb;
		this.result = result;
	}
	
	public boolean accepts(ResourceMethod method) {
		System.out.println(usuarioWeb.isLogado());
		return !usuarioWeb.isLogado() && method.containsAnnotation(Restrito.class);
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(UsuariosController.class).loginForm();
	}

}
