package com.codecika.kotlindemo.Model.Domain

import lombok.Data
import org.hibernate.annotations.DynamicUpdate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "STUDENT")
@DynamicUpdate
 class Student{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @get: NotBlank
    val name: String = ""

    @get: NotBlank
    val address: String = ""

    @get:NotBlank
    val birthday : String = ""

}