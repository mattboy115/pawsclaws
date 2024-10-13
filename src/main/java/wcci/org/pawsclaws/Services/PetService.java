package wcci.org.pawsclaws.Services;

import java.util.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import wcci.org.pawsclaws.DTO.AdmissionDTO;
import wcci.org.pawsclaws.DTO.EditPetDTO;
import wcci.org.pawsclaws.DTO.PetDTO;
import wcci.org.pawsclaws.DTO.StatusDTO;

/**
 * Service class responsible for handling operations related to pets.
 */
@Service
public class PetService {
    
    private final RestTemplate restTemplate; // RestTemplate for making HTTP requests
    private final String server = "http://localhost:8080"; // Base URL for the API

    /**
     * Constructor for PetService.
     * 
     * @param restTemplate RestTemplate instance for making API calls.
     */
    public PetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves a list of all pets from the shelter API.
     * 
     * @return List of PetDTO objects representing all pets available.
     */
    public List<PetDTO> getAllPets() {
        String url = server + "/api/v1/shelter"; // Construct the URL for the shelter API
        PetDTO[] pets = restTemplate.getForObject(url, PetDTO[].class); // Make GET request to retrieve pets

        return Arrays.asList(pets); // Convert the array to a List and return it
    }

    public PetDTO getPetById(long id) {
        String url = server + "/api/v1/shelter/" + id;
        PetDTO pet = restTemplate.getForObject(url, PetDTO.class);
        return pet;
    }

    public PetDTO saveAdd(AdmissionDTO admit) {
        String url = server + "/api/v1/shelter"; // Construct the URL for the shelter API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<AdmissionDTO> requestEntity = new HttpEntity<>(admit,headers);
        PetDTO pet = restTemplate.postForObject(url, requestEntity, PetDTO.class); // Make GET request to retrieve pets

        return pet; // Convert the array to a List and return it
    }

    public PetDTO saveEdit(EditPetDTO edit) {
        String url = server + "/api/v1/shelter"; // Construct the URL for the shelter API
        HttpHeaders headers = new HttpHeaders();
        
        headers.set("Content-Type", "application/json");
        HttpEntity<EditPetDTO> requestEntity = new HttpEntity<>(edit,headers);
        PetDTO pet = restTemplate.postForObject(url, requestEntity, PetDTO.class); // Make GET request to retrieve pets

        return pet; // Convert the array to a List and return it
    }

    public StatusDTO carePet(long id, String action) {
        String url = server + "/api/v1/shelter/" + action + "/" + id; // Construct the URL for the shelter API
        StatusDTO status = restTemplate.getForObject(url, StatusDTO.class); // Make GET request to retrieve pets

        return status; // Convert the array to a List and return it
    }

    public void deletePetById(long id) {
        String url = server + "/api/v1/shelter/" + id;
        restTemplate.delete(url);
    }
}
