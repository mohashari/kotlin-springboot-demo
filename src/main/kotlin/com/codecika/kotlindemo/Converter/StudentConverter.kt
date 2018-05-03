package com.codecika.kotlindemo.Converter

import com.codecika.kotlindemo.Model.Domain.Student
import com.codecika.kotlindemo.VO.StudentVO


fun Student.toVO(): StudentVO{
    return StudentVO(
            name = name,
            address = address,
            birthday = birthday
    )
}