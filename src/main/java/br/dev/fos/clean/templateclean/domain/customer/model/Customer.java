package br.dev.fos.clean.templateclean.domain.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String name;
    private Integer age;

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
}
