package ee.bredbrains.tthkapi.repository

import ee.bredbrains.tthkapi.model.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BaseEntityRepository<T> : JpaRepository<T, UUID> where T : BaseEntity