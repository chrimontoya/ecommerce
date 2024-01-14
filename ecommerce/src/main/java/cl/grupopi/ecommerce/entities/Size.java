package cl.grupopi.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "size", schema = "public")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
