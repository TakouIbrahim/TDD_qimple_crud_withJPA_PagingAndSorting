package com.travel.mintp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 25)
    private String name;
}
