package com.softitlan.DemoCRUD.endpoint;

import com.softitlan.DemoCRUD.entity.PersonasDTO;
import com.softitlan.DemoCRUD.entity.PersonasVO;
import com.softitlan.DemoCRUD.service.PersonasService;
import com.softitlan.DemoCRUD.config.ResponseBody;
import com.softitlan.DemoCRUD.config.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
@RestController
@RequestMapping("/personas")
public class PersonasEndpoint{


	private static final Logger LOGGER = LoggerFactory.getLogger(PersonasEndpoint.class);

	@Autowired
	private PersonasService personasService;


	@PostMapping("/insert")
	public ResponseEntity<ResponseBody<Void>> insert(@RequestBody PersonasDTO personasDTO){
		LOGGER.debug(">>>Insert()->personas:{}", personasDTO);
		ResponseEntity<ResponseBody<Void>> response=null;
		try{
			personasService.insert(personasDTO);
			response= Utils.<Void>response(HttpStatus.CREATED,"Se inserto el registro",null);
		}catch (Exception e){
			response=Utils.<Void>response(HttpStatus.BAD_REQUEST,false,"No se puedo insertar el registro",null);
		}
	return response;
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<ResponseBody<Void>> update(@PathVariable Integer id, @RequestBody Map<String,Object> data){
		LOGGER.debug(">>>> update->id: {}, personas: {}",id,data);
		ResponseEntity<ResponseBody<Void>> response=null;
		try{
			personasService.update(id,data);
			response= Utils.<Void>response(HttpStatus.OK,"Se actualizo el registro",null);
		}catch (Exception e){
			response=Utils.<Void>response(HttpStatus.BAD_REQUEST,false,"No se puedo insertar el registro",null);
		}
	return response;
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<ResponseBody<Void>> delete(@PathVariable Integer id){
		LOGGER.debug(">>>> delete->id: {}",id);
		ResponseEntity<ResponseBody<Void>> response=null;
		try{
			personasService.delete(id);
			response= Utils.<Void>response(HttpStatus.OK,"Se actualizo el registro",null);
		}catch (Exception e){
			response=Utils.<Void>response(HttpStatus.BAD_REQUEST,false,"No se puedo insertar el registro",null);
		}
	return response;
	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponseBody<List<PersonasVO>>> findAll(){
		LOGGER.debug(">>>> findAll <<<<");
		ResponseEntity<ResponseBody<List<PersonasVO>>> response=null;
		List<PersonasVO> personasVOList =null;
		try{
			personasVOList =personasService.findAll();
			response=Utils.<List<PersonasVO>>response(HttpStatus.OK,"Lista enonctrda", personasVOList);
		}catch (Exception e){
			response=Utils.<List<PersonasVO>>response(HttpStatus.NOT_FOUND,"Lista enonctrda", personasVOList);
		}
		return response;
	}
}
