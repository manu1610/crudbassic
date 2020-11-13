package com.softitlan.DemoCRUD.repository;
import com.softitlan.DemoCRUD.entity.PersonasVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<PersonasVO,Integer>{
}
