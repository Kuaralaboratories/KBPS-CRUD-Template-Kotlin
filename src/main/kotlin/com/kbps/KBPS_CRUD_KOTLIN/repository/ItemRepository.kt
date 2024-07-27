package com.kbps.KBPS_CRUD_KOTLIN

import com.example.crudapp.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>
