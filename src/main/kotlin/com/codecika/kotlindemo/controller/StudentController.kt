package com.codecika.kotlindemo.controller

import com.codecika.kotlindemo.converter.toModel
import com.codecika.kotlindemo.service.StudentService
import com.codecika.kotlindemo.vo.StudentVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/student")
class StudentController() {

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping("/get-all")
    fun getAllStudent(): List<StudentVO> {
        return studentService.getAll()
    }

    @PostMapping("/add")
    fun addData(@Valid @RequestBody student: StudentVO): StudentVO {
        return studentService.saveData(student.toModel())
    }

    @GetMapping("/student/{id}")
    fun getStudentById(@PathVariable(value = "id") id: Long): Optional<StudentVO> {
        return studentService.getDetail(id)
    }

    @PutMapping("/edit/{id}")
    fun updateArticleById(@PathVariable(value = "id") id: Long,
                          @RequestBody newStudent: StudentVO): StudentVO {
        return studentService.editData(newStudent.toModel(), id)
    }

}