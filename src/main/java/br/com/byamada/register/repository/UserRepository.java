package br.com.byamada.register.repository;

import java.util.Optional;

import br.com.byamada.register.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    Optional<User> findByEmail(String email);

}
