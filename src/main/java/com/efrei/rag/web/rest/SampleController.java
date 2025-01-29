package com.efrei.rag.web.rest;

import com.efrei.rag.web.dto.Sample;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/samples")
public class SampleController {
    @GetMapping("/EFREI")
    public String ping() {
        return "Hello EFREI! Maxime";
    }

    @GetMapping("/dto/{value}")
    public Sample helloJson(@PathVariable(value = "value", required = false) final String value) {
        return new Sample("Hello " + value + "! Maxime");
    }
}
