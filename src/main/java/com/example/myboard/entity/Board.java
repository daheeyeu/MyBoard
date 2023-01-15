package com.example.myboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}
