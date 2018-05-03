package com.codecika.kotlindemo.Controller

import com.codecika.kotlindemo.Model.Domain.Student
import com.codecika.kotlindemo.Model.Repository.StudentRepository
import com.codecika.kotlindemo.Service.StudentService
import com.codecika.kotlindemo.VO.StudentVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/student")
class StudentController() {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping("/get-all")
    fun getAllStudent(): List<StudentVO> {
     return studentService.getAll()
    }

    @PostMapping("/add")
    fun addData(@Valid @RequestBody student: Student): StudentVO {
        return studentService.saveData(student)
    }

    @GetMapping("/student/{id}")
    fun getStudentById(@PathVariable(value = "id") id: Long): Optional<StudentVO>{
        return studentService.getDetail(id)
    }


    @PutMapping("/edit/{id}")
    fun updateArticleById(@PathVariable(value = "id") id: Long,
                          @RequestBody newStudent: Student): StudentVO {
        return studentService.editData(newStudent,id)

    }

}