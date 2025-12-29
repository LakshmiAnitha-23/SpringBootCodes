package com.example.SwaggerCRUD.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Schema(description = "product Entity")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "Laptop")
    private String name;

    @Schema(example = "70000")
    private double price;

    @Schema(example = "Electronics")
    private String category;
}
