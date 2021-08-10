package br.com.byamada.register.repository;

import br.com.byamada.register.model.entity.User;

import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

    User save(User user);

}

