package com.codecika.kotlindemo.VO

import lombok.Data
import javax.validation.constraints.NotBlank

data class StudentVO(

        var name: String,

        var address: String,

        var birthday: String
)
