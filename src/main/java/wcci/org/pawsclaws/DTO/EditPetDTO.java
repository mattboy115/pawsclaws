package wcci.org.pawsclaws.DTO;

public class EditPetDTO extends ErrorDataDTO{
    private long id;
    public String name;
    public Integer age;
    
    public EditPetDTO(PetDTO pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.age = pet.getAge();
    }

    public EditPetDTO() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
