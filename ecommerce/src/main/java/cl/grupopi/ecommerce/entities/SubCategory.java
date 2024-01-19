package cl.grupopi.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sub_category", schema = "public")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
//    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //    public List<Product> getProducts() {
//        return products;
//    }
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}
