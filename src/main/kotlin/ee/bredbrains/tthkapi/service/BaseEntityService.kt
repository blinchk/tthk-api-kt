package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.model.BaseEntity

abstract class BaseEntityService<T> where T : BaseEntity {
    abstract fun all(): List<T>
}