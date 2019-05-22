
package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByEmail(String email);
}
