package Agencia.API;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import Agencia.resources.LocalResource;
import Agencia.resources.ViagemResource;

@Component
public class JerseyConfig extends ResourceConfig{
	 public JerseyConfig()
	    {
	        register(LocalResource.class);
	        register(ViagemResource.class);
	    }
}
