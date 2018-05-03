package com.codecika.kotlindemo.model.repository

import com.codecika.kotlindemo.model.domain.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student,Long> {
}