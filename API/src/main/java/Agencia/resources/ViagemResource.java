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

import Agencia.model.Viagem;
import Agencia.repo.IViagemRepo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "viagem")
@Path("/viagem")
public class ViagemResource {
	@Autowired
	IViagemRepo repo;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Viagem> listarTodos() {        
        return (List<Viagem>)repo.findAll();
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Viagem request) throws URISyntaxException{
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
	
	@GET
	@Path("/viagens")
	public Response viagens(){
		String file = "Id,Local de, Local para, Valor total\n";
		List<Viagem> lista = (List<Viagem>) repo.findAll();
		
		for(Viagem item : lista)
			file += item.viagemFormatada()+"\n";
		return Response.ok(file).header("Content-Disposition", "attachment; filename=show.csv").build();
	}
}
