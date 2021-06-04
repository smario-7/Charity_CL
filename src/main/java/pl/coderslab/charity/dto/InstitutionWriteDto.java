package pl.coderslab.charity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InstitutionWriteDto {
    private Long id;
    @NotBlank (message = "nie nie wpisałeś")
    private String name;
    @NotBlank (message = "nie nie wpisałeś")
    @Size(max = 255)
    private String description;

    public InstitutionWriteDto() {
    };

    public InstitutionWriteDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
