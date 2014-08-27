package br.com.caelum.goodbuy.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@SuppressWarnings("deprecation")
@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory>{
	
	private SessionFactory factory;
	
	public SessionFactory getInstance() {
		return factory;
	}
	
	@PostConstruct
	public void abre() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		
		this.factory = configuration.buildSessionFactory();
		System.out.println("Abre: Factory aberta");
	}
	
	@PreDestroy
	public void fecha() {
		this.factory.close();
		System.out.println("Fecha: Factory fechada");
	}
}
