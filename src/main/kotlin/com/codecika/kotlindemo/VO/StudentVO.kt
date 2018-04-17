package com.codecika.kotlindemo.VO

import lombok.Data
import javax.validation.constraints.NotBlank

class StudentVO(

        var name: String ="",

        var address: String= "",

        val birthday: String= ""
)
