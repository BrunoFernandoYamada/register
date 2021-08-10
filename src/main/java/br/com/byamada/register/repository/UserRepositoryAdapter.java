package br.com.byamada.register.repository;

import java.util.Optional;

import br.com.byamada.register.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UserRepositoryAdapter implements UserRepositoryPort{

    @Autowired
    private UserRepository authRepository;

    @Override
    public User save(User user) {
        return authRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id){
        return authRepository.findById(id);
    }

}