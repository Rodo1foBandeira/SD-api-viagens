package Agencia.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Agencia.model.Local;

@Repository
public interface ILocalRepo extends CrudRepository<Local, Long> {

}
