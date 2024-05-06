package com.unversityregister.repository;

import com.unversityregister.demo.Computer;
import com.unversityregister.dto.ComputerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {
     ComputerResponse findByName(String name);
}
