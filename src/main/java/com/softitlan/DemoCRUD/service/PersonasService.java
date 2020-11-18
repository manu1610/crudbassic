package com.softitlan.DemoCRUD.service;
import com.softitlan.DemoCRUD.entity.PersonasDTO;
import com.softitlan.DemoCRUD.entity.PersonasVO;
import java.util.List;
import java.util.Map;
public interface PersonasService{
	void insert(PersonasDTO personasDTO) throws Exception;
	void update(Integer id, Map<String,Object> data) throws Exception;
	void delete(Integer id) throws Exception;
	List<PersonasVO> findAll() throws Exception;
	List<PersonasVO> findAllActive() throws Exception;
}
