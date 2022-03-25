package com.revature.techshop.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Builder
public class Orders {
    @Id
    @SequenceGenerator(name = "orders_sequence",
    sequenceName = "orders_sequence",
    allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_sequence"
    )
    int orderNumber;
    @ManyToOne(
            cascade = CascadeType.ALL
    )@JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    User user;
    double amount;


}
