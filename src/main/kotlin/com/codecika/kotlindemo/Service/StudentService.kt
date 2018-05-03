package com.codecika.kotlindemo.Service

import com.codecika.kotlindemo.Converter.toVO
import com.codecika.kotlindemo.Model.Domain.Student
import com.codecika.kotlindemo.Model.Repository.StudentRepository
import com.codecika.kotlindemo.VO.StudentVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService {

    @Autowired
    lateinit var studentRepository: StudentRepository

    fun saveData(student: Student): StudentVO {
        return studentRepository.save(student).toVO()
    }

    fun getAll(): List<StudentVO> {
        return studentRepository.findAll().map { it.toVO() }
    }

    fun getDetail(id: Long): Optional<StudentVO> {
        return studentRepository.findById(id).map { it.toVO() }
    }

    fun editData(student: Student, id: Long): StudentVO {
        assert(student.id == id)
        return studentRepository.saveAndFlush(student).toVO()
    }
}