package com.example.detail.model

import javax.persistence.*

@Entity
@Table(name = "organisation")
data class Organisation(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val name: String,

        val address: String,

        @OneToMany
        @JoinColumn(name = "organisation_id")
        val details: Set<Detail>
)