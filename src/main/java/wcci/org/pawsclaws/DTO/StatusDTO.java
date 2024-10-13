package wcci.org.pawsclaws.DTO;

import wcci.org.pawsclaws.Enums.PetType;

public class StatusDTO extends ErrorDataDTO {
    private String name;
    private PetType petType;
    private String status;
    private String value;
    
    public StatusDTO(String name, PetType petType, String status, String value) {
        this.name = name;
        this.petType = petType;
        this.status = status;
        this.value = value;
    }
    public StatusDTO() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PetType getPetType() {
        return petType;
    }
    public void setPetType(PetType petType) {
        this.petType = petType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
}
