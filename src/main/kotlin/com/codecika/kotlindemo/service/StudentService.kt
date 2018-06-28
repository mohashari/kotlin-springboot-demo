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


    fun editData(student: Student): StudentVO {
        val model = studentRepository.getOne(student.id)
        model.apply {
            address = student.address
            birthday = student.birthday
            name = student.name
        }
        return studentRepository.saveAndFlush(model).toVO()
    }

    fun deleteStudent(id: Long): String {
        val model: Student = studentRepository.getOne(id)
        if (model == null) {
            return "Data Tidak Ada";
        } else {
            studentRepository.delete(model)
            return "Data Sudah Di hapus"
        }

    }
}