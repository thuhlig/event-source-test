package de.c4u.eventsourcetest.web.sync

import de.c4u.eventsourcetest.persistence.service.MessageService
import de.c4u.eventsourcetest.web.dto.MessageRequest
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController(val messageService: MessageService) {

    @GetMapping
    fun home(): String {
        return "index"
    }

    @PostMapping
    fun sendMessage(@Validated request: MessageRequest) {
        this.messageService.save(request)
    }
}
