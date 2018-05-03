package com.codecika.kotlindemo.converter

import com.codecika.kotlindemo.model.domain.Student
import com.codecika.kotlindemo.vo.StudentVO

fun Student.toVO(): StudentVO {
    return StudentVO(
            name = name,
            address = address,
            birthday = birthday
    )
}

fun StudentVO.toModel(): Student {
    return Student().apply {
        name = this@toModel.name
        address = this@toModel.address
        birthday = this@toModel.birthday
    }
}