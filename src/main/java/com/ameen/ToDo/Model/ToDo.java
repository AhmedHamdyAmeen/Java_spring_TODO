package com.ameen.ToDo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static jakarta.persistence.GenerationType.AUTO;


@Entity(name = "todos")
@Data
@Table
@Getter
@Setter
//@NoArgsConstructor // Required to map model to table in the db
public class ToDo {
    // Hibernate uses the default constructor (no arg constructor) create instance and insert it to the table of the db.
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    @NotNull(message = "Title Required")
    @Min(value = 3, message = "Title at lest 3 characters")
    private String title;

    private String description;
    private Long timestamp;

    /* Constructor
     **/

    public ToDo() {
        this.timestamp = System.currentTimeMillis();
    }

    public ToDo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

        this.timestamp = System.currentTimeMillis();

    }

    /* Getters & Setters
     **/
}
