package mum.edu.cs544.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.cs544.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
    
}