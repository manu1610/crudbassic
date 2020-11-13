package com.softitlan.DemoCRUD.service.impl;

import com.softitlan.DemoCRUD.entity.PersonasBuilder;
import com.softitlan.DemoCRUD.entity.PersonasDTO;
import com.softitlan.DemoCRUD.entity.PersonasVO;
import com.softitlan.DemoCRUD.repository.PersonasRepository;
import com.softitlan.DemoCRUD.service.PersonasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;

@Service
public class PersonasServiceImpl implements PersonasService{


	private static final Logger LOGGER = LoggerFactory.getLogger(PersonasServiceImpl.class);

	@Autowired
	private PersonasRepository personasRepository;


	@Override
	public void insert(PersonasDTO personasDTO) throws Exception{
		PersonasVO vo = null;
		LOGGER.debug(">>>Insert()->personas:{}", personasDTO);
		try{
			vo = PersonasBuilder.fromDTO(personasDTO);
			vo.setId(0);
			vo.setCreatedAt(new Date());
			vo.setCreatedBy(1);
			vo.setModifiedAt(new Date());
			vo.setModifiedBy(1);
			vo.setStatus(1);
			personasRepository.save(vo);
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
	}
	@Override
	public void update(Integer id, Map<String,Object> data) throws Exception{

		LOGGER.debug(">>>> update->id: {}, personas: {}",id,data);
		try{
			Optional<PersonasVO> personasOptional = personasRepository.findById(id);
			if(!personasOptional.isPresent()){
				throw new Exception("No existe el registro");
			}
			//name
			if(data.containsKey("name")){
				String name = data.get("name").toString();
				personasOptional.get().setName(name);
			}
			//paternalSurname
			if(data.containsKey("paternalSurname")){
				String paternalSurname = data.get("paternalSurname").toString();
				personasOptional.get().setPaternalSurname(paternalSurname);
			}
			//maternalSurname
			if(data.containsKey("maternalSurname")){
				String maternalSurname = data.get("maternalSurname").toString();
				personasOptional.get().setMaternalSurname(maternalSurname);
			}
			//birthdate
			if(data.containsKey("birthdate")){
				Date birthdate = (Date)data.get("birthdate");
				personasOptional.get().setBirthdate(birthdate);
			}
			//gender
			if(data.containsKey("gender")){
				String gender = data.get("gender").toString();
				personasOptional.get().setGender(gender);
			}
			//status
			if(data.containsKey("status")){
				Integer status = (Integer)data.get("status");
				personasOptional.get().setStatus(status);
			}
			//createdAt
			if(data.containsKey("createdAt")){
				Date createdAt = (Date)data.get("createdAt");
				personasOptional.get().setCreatedAt(createdAt);
			}
			//createdBy
			if(data.containsKey("createdBy")){
				Integer createdBy = (Integer)data.get("createdBy");
				personasOptional.get().setCreatedBy(createdBy);
			}
			//modifiedAt
			if(data.containsKey("modifiedAt")){
				Date modifiedAt = (Date)data.get("modifiedAt");
				personasOptional.get().setModifiedAt(modifiedAt);
			}
			//modifiedBy
			if(data.containsKey("modifiedBy")){
				Integer modifiedBy = (Integer)data.get("modifiedBy");
				personasOptional.get().setModifiedBy(modifiedBy);
			}
			personasRepository.save(personasOptional.get());
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
	}
	@Override
	public void delete(Integer id) throws Exception{
		LOGGER.debug(">>>> delete->id: {}",id);
		try{
			PersonasVO personasVO = personasRepository.getOne(id);
			if (personasVO == null) {
				throw new Exception("No existe el registro");
			}
			if (personasVO.getStatus() == 0) {
				throw new Exception("No existe el registro");
			}
			personasVO.setStatus(0);
			personasRepository.save(personasVO);
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
	}
	@Override
	public List<PersonasVO> findAll() throws Exception{
		LOGGER.debug(">>>> findAll <<<<");
		List<PersonasVO> personasVOList =null;
		try{
			personasVOList = personasRepository.findAll();
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
		LOGGER.debug(">>>> findAll <<<< personasList: {}", personasVOList);
		return personasVOList;
	}

}
