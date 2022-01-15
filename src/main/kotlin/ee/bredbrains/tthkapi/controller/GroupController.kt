package ee.bredbrains.tthkapi.controller

import ee.bredbrains.tthkapi.model.Group
import ee.bredbrains.tthkapi.service.GroupService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/groups")
class GroupController(groupService: GroupService) : BaseEntityController<Group>(groupService)