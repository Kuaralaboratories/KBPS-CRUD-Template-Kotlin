package com.kbps.KBPS_CRUD_KOTLIN

import com.example.crudapp.model.Item
import com.example.crudapp.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(private val itemRepository: ItemRepository) {
    fun getAllItems(): List<Item> = itemRepository.findAll()

    fun getItemById(id: Long): Item? = itemRepository.findById(id).orElse(null)

    fun saveItem(item: Item): Item = itemRepository.save(item)

    fun deleteItem(id: Long) = itemRepository.deleteById(id)
}