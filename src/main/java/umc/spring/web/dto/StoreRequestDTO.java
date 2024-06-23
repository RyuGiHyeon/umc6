package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class PostRequestDTO{
        @NotNull
        Float score;
        @NotBlank
        String title;
    }
}
