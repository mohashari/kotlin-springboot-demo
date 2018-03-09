package com.codecika.kotlindemo.Service

import com.codecika.kotlindemo.Model.Domain.Student
import com.codecika.kotlindemo.Model.Repository.StudentRepository
import com.codecika.kotlindemo.VO.StudentVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService {

@Autowired
lateinit var studentRepository: StudentRepository

    fun saveData(student: Student) : Student {
     return studentRepository.save(student)
    }

}