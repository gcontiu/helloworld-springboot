package com.helloworld.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ArticleReadAction {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Article article;

    @Column(nullable = false)
    private Date timeStamp;

    @Column(nullable = false)
    private Integer secondsSpent;

    @Column(nullable = false)
    private Float nrOfCoins;
}
