package Agencia.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URISyntaxException;
import java.util.List;

import Agencia.repo.ILocalRepo;
import Agencia.model.Local;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "local")
@Path("/local")
public class LocalResource {
	@Autowired
	ILocalRepo repo;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Local> listarTodos() {        
        return (List<Local>)repo.findAll();
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Local request) throws URISyntaxException{
		int statusCode;
        if (request.getId() == 0)
        {
        	statusCode = 201;
        }else {
        	statusCode = 200;
        }
    	repo.save(request);    	
        return Response.status(statusCode).entity(request).build();
	}
}
