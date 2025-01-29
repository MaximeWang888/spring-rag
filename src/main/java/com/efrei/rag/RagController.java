package com.efrei.rag;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/samples")
public class RagController {
    @GetMapping("/EFREI")
    public String ping() {
        return "Hello EFREI! Maxime";
    }
}
