package wcci.org.pawsclaws.Conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import wcci.org.pawsclaws.DTO.*;
import wcci.org.pawsclaws.Enums.PetType;
import wcci.org.pawsclaws.Services.PetService;





/**
 * Controller class responsible for handling requests related to pets.
 */
@Controller
public class PetController {

    @Autowired
    private PetService service; // Injected PetService to handle pet-related operations
    
    /**
     * Handles GET requests to the root path and "/home".
     * 
     * @return The name of the view to be rendered (in this case, the "ViewPets" view).
     */
    @GetMapping({"/", "/home"})
    public String getAllPets(Model model) {
        try {
            List<PetDTO> pets = service.getAllPets();
            model.addAttribute("pets", pets);
            model.addAttribute("title", "Shelter Pets");
            return "Shelter/ViewPets";
        }
        catch(Exception ex) {
            ErrorDataDTO errorData = new ErrorDataDTO();
            errorData.setErrorMessage(ex.getMessage());
            errorData.setErrorCode(500);
            model.addAttribute("errorData", errorData);
            model.addAttribute("title", "Shelter Pets - Error");
            return "Shelter/ErrorMessage";
        }// Navigate to the view for displaying pets
    }

    @GetMapping("details/{id}")
    public String getDetails(@PathVariable long id, Model model) {
        try {
            StatusDTO status = new StatusDTO();
            PetDTO pet = service.getPetById(id);
            model.addAttribute("pet", pet);
            model.addAttribute("title", "Details for " + pet.getName());
            model.addAttribute("status", status);
            
            return "Shelter/ViewDetails";
        }
        catch (Exception ex) {
            ErrorDataDTO errorData = new ErrorDataDTO();
            errorData.setErrorMessage(ex.getMessage());
            errorData.setErrorCode(500);
            model.addAttribute("errorData", errorData);
            model.addAttribute("title", "This pet doesn't exist.");
            return "redirect:/ErrorMessage";
        }
    }

    @GetMapping("create")
    public String createPet(Model model) {
        AdmissionDTO addPet = new AdmissionDTO();
        model.addAttribute("pet", addPet);
        model.addAttribute("title", "Create Pet");
        model.addAttribute("petTypes", PetType.values());
        return "Shelter/CreatePet";
    }

    @GetMapping("about")
    public String aboutPage(Model model) {
        return "Shelter/About";
    }

    @GetMapping("contact")
    public String contactPage(Model model) {
        return "Shelter/Contact";
    }

    @GetMapping("edit/{id}")
    public String editPet(@PathVariable long id, Model model) {
        EditPetDTO pet = new EditPetDTO(service.getPetById(id));
        model.addAttribute("pet", pet);
        model.addAttribute("title", "Edit Pet");
        model.addAttribute("petTypes", PetType.values());
        return "Shelter/EditPet";
    }

    @PostMapping("saveadd")
    public String saveadd(@ModelAttribute AdmissionDTO pet, Model model) {
        try {
            service.saveAdd(pet);
        }
        catch (Exception ex) {
            pet.setErrorMessage(ex.getMessage());
            pet.setErrorCode(400);
            model.addAttribute("pet", pet);
            model.addAttribute("title", "Edit Pet");
            model.addAttribute("petTypes", PetType.values());
            return "Shelter/CreatePet";
        }
        return "redirect:/home";
    }

    @PatchMapping("saveedit")
    public String saveEdit(@ModelAttribute EditPetDTO pet, Model model) {
        try {
            service.saveEdit(pet);
        }
        catch (Exception ex) {
            pet.setErrorMessage(ex.getMessage());
            pet.setErrorCode(400);
            model.addAttribute("pet", pet);
            model.addAttribute("title", "Edit Pet");
            model.addAttribute("petTypes", PetType.values());
            return "Shelter/EditPet";
        }
        return "redirect:/home";
    }

    @GetMapping("feed/{id}")
    public String feedAPet(@PathVariable long id, Model model) {
        StatusDTO status = service.carePet(id, "feed");
        PetDTO pet = service.getPetById(id);
        model.addAttribute("pet", pet);
        model.addAttribute("title", "Details for " + pet.getName());
        model.addAttribute("petTypes", PetType.values());
        model.addAttribute("status", status);
        return "Shelter/ViewDetails";
    }

    @GetMapping("water/{id}")
    public String waterAPet(@PathVariable long id, Model model) {
        StatusDTO status = service.carePet(id, "water");
        PetDTO pet = service.getPetById(id);
        model.addAttribute("pet", pet);
        model.addAttribute("title", "Details for " + pet.getName());
        model.addAttribute("petTypes", PetType.values());
        model.addAttribute("status", status);
        return "Shelter/ViewDetails";
    }

    @GetMapping("heal/{id}")
    public String healAPet(@PathVariable long id, Model model) {
        StatusDTO status = service.carePet(id, "heal");
        PetDTO pet = service.getPetById(id);
        model.addAttribute("pet", pet);
        model.addAttribute("title", "Details for " + pet.getName());
        model.addAttribute("petTypes", PetType.values());
        model.addAttribute("status", status);
        return "Shelter/ViewDetails";
    }

    @GetMapping("play/{id}")
    public String playWithAPet(@PathVariable long id, Model model) {
        StatusDTO status = service.carePet(id, "play");
        PetDTO pet = service.getPetById(id);
        model.addAttribute("pet", pet);
        model.addAttribute("title", "Details for " + pet.getName());
        model.addAttribute("petTypes", PetType.values());
        model.addAttribute("status", status);
        return "Shelter/ViewDetails";
    }

    @GetMapping("adopt/{id}")
    public String adoptAPet(@PathVariable long id, Model model) {
        try {
            service.deletePetById(id);
        }
        catch (Exception ex) {
            ErrorDataDTO errorData = new ErrorDataDTO();
            errorData.setErrorMessage(ex.getMessage());
            errorData.setErrorCode(500);
            model.addAttribute("errorData", errorData);
            model.addAttribute("title", "Error adopting pet.");
            return "Shelter/ErrorMessage";
        }
        return "redirect:/home";
    }
    
    
}
