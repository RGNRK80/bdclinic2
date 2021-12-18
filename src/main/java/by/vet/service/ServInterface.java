package by.vet.service;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DaoUserExistException;
import by.vet.dto.*;
import by.vet.entity.Pet;

import java.util.ArrayList;

public interface ServInterface {
    UserDataDTO addNewUser (RegUserDataDTO user) throws DaoUserExistException, DAOConnectEx;

    UserDataDTO enter (EnterDTO user);

    PetDataDTO addNewPet(RegPetDataDTO regpet);

    ArrayList<Pet> getPets(UserDataDTO userDataDTO);

    ArrayList<Pet> getZPets(UserDataDTO userDataDTO);

    PetDataDTO getDocToPet(UserDataDTO userDataDTO, long idpet);
}
