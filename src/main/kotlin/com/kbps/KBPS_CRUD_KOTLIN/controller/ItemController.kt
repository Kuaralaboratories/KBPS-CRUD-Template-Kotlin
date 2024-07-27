package com.kbps.KBPS_CRUD_KOTLIN

import com.example.crudapp.model.Item
import com.example.crudapp.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/items")
class ItemController(private val itemService: ItemService) {

    @GetMapping
    fun getAllItems(): List<Item> = itemService.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): ResponseEntity<Item> {
        val item = itemService.getItemById(id)
        return if (item != null) ResponseEntity.ok(item) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createItem(@RequestBody item: Item): Item = itemService.saveItem(item)

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody item: Item): ResponseEntity<Item> {
        val existingItem = itemService.getItemById(id)
        return if (existingItem != null) {
            val updatedItem = item.copy(id = id)
            ResponseEntity.ok(itemService.saveItem(updatedItem))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long): ResponseEntity<Void> {
        return if (itemService.getItemById(id) != null) {
            itemService.deleteItem(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}