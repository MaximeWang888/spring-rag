package com.efrei.rag.web.rest;

import com.efrei.rag.service.AssistantAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantController {

    private final AssistantAiService assistantService;

    public AssistantController(AssistantAiService assistantService) {
        this.assistantService = assistantService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantService.chat(query);
    }
}