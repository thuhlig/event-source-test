package de.c4u.eventsourcetest.web.sync

import de.c4u.eventsourcetest.persistence.service.MessageService
import de.c4u.eventsourcetest.web.dto.MessageRequest
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/")
class HomeController(val messageService: MessageService) {

    @GetMapping
    fun home(): String {
        return "index"
    }

    @PostMapping
    @ResponseBody
    fun sendMessage(@Validated @RequestBody request: MessageRequest) {
        this.messageService.save(request)
    }
}
