package com.codecika.kotlindemo.Model.Repository

import com.codecika.kotlindemo.Model.Domain.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student,Long> {
}