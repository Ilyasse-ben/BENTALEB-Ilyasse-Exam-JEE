package net.ilyasse.bentaleb.backend.DTOs;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ClientDto {

    private Long id;
    private String  name;
    private String email;

}
