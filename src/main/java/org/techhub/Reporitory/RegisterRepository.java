package org.techhub.Reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.techhub.model.Register;

import jakarta.transaction.Transactional;

@Repository("RegRepo")
public interface RegisterRepository extends JpaRepository<Register,Integer>{

	@Modifying
	@Transactional
	@Query("update Register r set r.name=:rname,r.sal=:rsal where r.id=:rid")
	int updateData(@Param("rname")String rname,@Param("rsal")Integer rsal,@Param("rid")Integer rid);

    public Register findByNameAndSal(String name, int sal);
}
