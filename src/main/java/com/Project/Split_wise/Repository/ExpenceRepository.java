package com.Project.Split_wise.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Split_wise.Entity.Expence;

public interface ExpenceRepository extends JpaRepository<Expence, Long>{
	
	List<Expence> findByGroup_Id(Long groupId);

}
