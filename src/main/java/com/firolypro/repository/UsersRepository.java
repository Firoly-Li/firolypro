package com.firolypro.repository;

import com.firolypro.dataobj.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
