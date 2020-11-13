package com.softitlan.DemoCRUD.entity;

public class PersonasBuilder {

    private PersonasBuilder(){
    }

    public static PersonasDTO fromVO(PersonasVO personaVO) {
        PersonasVO origin=personaVO;
        PersonasDTO destin=new PersonasDTO();

        destin.setName(origin.getName());
        destin.setPaternalSurname(origin.getPaternalSurname());
        destin.setMaternalSurname(origin.getMaternalSurname());
        destin.setBirthdate((origin.getBirthdate()));
        destin.setGender(origin.getGender());


        return destin;
    }

    public static PersonasVO fromDTO(PersonasDTO personaDTO) {
        PersonasDTO origin=personaDTO;
        PersonasVO destin=new PersonasVO();

        destin.setName(origin.getName());
        destin.setPaternalSurname(origin.getPaternalSurname());
        destin.setMaternalSurname(origin.getMaternalSurname());
        destin.setBirthdate((origin.getBirthdate()));
        destin.setGender(origin.getGender());

        return destin;
    }


}
