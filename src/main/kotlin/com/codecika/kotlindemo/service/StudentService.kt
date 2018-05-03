package com.codecika.kotlindemo.service

import com.codecika.kotlindemo.converter.toVO
import com.codecika.kotlindemo.model.domain.Student
import com.codecika.kotlindemo.model.repository.StudentRepository
import com.codecika.kotlindemo.vo.StudentVO
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