package wcci.org.pawsclaws.DTO;

import wcci.org.pawsclaws.Enums.PetType;

/**
 * Data Transfer Object (DTO) representing a pet's information, 
 * including its state and attributes.
 */
public class PetDTO extends ErrorDataDTO {
    
    private Long id; // Unique identifier for the pet
    private PetType petType; // Type of the pet (e.g., dog, cat)
    private String name; // Name of the pet
    private Integer age; // Age of the pet
    private int happiness; // Happiness level of the pet (scale not specified)
    private int health;
    private String deathBy; // Cause of death (if applicable)
    private int hunger; // Hunger level of the pet (scale not specified)
    private int thirst; // Thirst level of the pet (scale not specified)
    private int battery;
    private int oil;
    private boolean dead; // Indicates if the pet is deceased
    // private String status; //Shows the pet's status.

    /**
     * Constructor for creating a PetDTO instance.
     * 
     * @param id Unique identifier for the pet.
     * @param petType Type of the pet.
     * @param name Name of the pet.
     * @param age Age of the pet.
     * @param happiness Happiness level of the pet.
     * @param health Health level of the pet.
     * @param deathBy Cause of death (if applicable).
     * @param hunger Hunger level of the pet.
     * @param thirst Thirst level of the pet.
     * @param dead Indicates if the pet is deceased.
     * @param status Shows a pet's status.
     */
    public PetDTO(Long id, PetType petType, String name, Integer age, int happiness, String deathBy, int hunger, int thirst, boolean dead) {
        this.id = id;
        this.petType = petType;
        this.name = name;
        this.age = age;
        this.happiness = happiness;
        this.deathBy = deathBy;
        this.hunger = hunger;
        this.thirst = thirst;
        this.dead = dead;
        // this.status = status;
    }

    // Getter and setter methods for each field

    // public String getStatus() {
    //     return status;
    // }

    // public void setStatus(String status) {
    //     this.status = status;
    // }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
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

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public String getDeathBy() {
        return deathBy;
    }

    public void setDeathBy(String deathBy) {
        this.deathBy = deathBy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isRobot() {
        return (this.getPetType() == petType.RoboCat || this.getPetType() == petType.RoboDog);
    }
}
