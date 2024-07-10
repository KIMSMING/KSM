package data.data.PhoneBook;

import com.fasterxml.jackson.annotation.JsonIgnore;
import data.data.Category.CategoryDto;
import data.data.Category.ICategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.swing.text.html.parser.Entity;

@Getter
@Setter
@Builder
public class PhoneBookRequest implements IPhoneBook{
    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 2, max = 12)
    private String name;

    @NotBlank
    private CategoryDto category;

    @NotBlank
    @Size(min = 0, max = 20)
    private String phoneNumber;

    @Size(min = 0, max = 200)
    private String email;

    @Override
    public void setCategory(ICategory category) {
        this.category = (CategoryDto) category;
    }
}
