package Agencia.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Agencia.model.Viagem;

@Repository
public interface IViagemRepo extends CrudRepository<Viagem, Long>{

}
