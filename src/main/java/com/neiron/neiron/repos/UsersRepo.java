package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UsersRepo extends CrudRepository<Users,String> {
} 