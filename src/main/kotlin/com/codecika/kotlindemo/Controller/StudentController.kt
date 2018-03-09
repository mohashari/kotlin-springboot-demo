package com.codecika.kotlindemo.Controller

import com.codecika.kotlindemo.Model.Domain.Student
import com.codecika.kotlindemo.Model.Repository.StudentRepository
import com.codecika.kotlindemo.Service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/student")
class StudentController() {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping("/get-all")
    fun getAllStudent(): List<Student> =
            studentRepository.findAll()

    @PostMapping("/add")
    fun addData(@Valid @RequestBody student: Student): Student =
            studentService.saveData(student)

    @GetMapping("/student/{id}")
    fun getStudentById(@PathVariable(value = "id") id: Long): ResponseEntity<Student> {
        return studentRepository.findById(id).map { student ->
            ResponseEntity.ok(student)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("/edit/{id}")
    fun updateArticleById(@PathVariable(value = "id") id: Long,
                          @RequestBody newStudent: Student) {
        assert(newStudent.id == id)
        studentRepository.saveAndFlush(newStudent)

    }

}