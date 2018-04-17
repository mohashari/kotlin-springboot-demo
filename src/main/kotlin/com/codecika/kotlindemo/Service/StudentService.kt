package com.codecika.kotlindemo.Service

import com.codecika.kotlindemo.Model.Domain.Student
import com.codecika.kotlindemo.Model.Repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService {

@Autowired
lateinit var studentRepository: StudentRepository

    fun saveData(student: Student) : Student {
     return studentRepository.save(student)
    }

    fun getAll():List<Student>{
        return studentRepository.findAll();
    }

    fun getDetail(id:Long): Optional<Student> {
        return studentRepository.findById(id)
    }

    fun editData(student: Student,id:Long):Student{
        assert(student.id == id)
        return studentRepository.saveAndFlush(student)
    }
}