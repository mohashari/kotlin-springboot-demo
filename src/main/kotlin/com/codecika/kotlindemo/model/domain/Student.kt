package com.codecika.kotlindemo.model.domain

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "STUDENT")
@DynamicUpdate
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @get: NotBlank
    var name: String = ""

    @get: NotBlank
    var address: String = ""

    @get:NotBlank
    var birthday: String = ""
}