package com.fibonachi.demo.serie.infrastructure;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api") 
public class serieController {

    @Autowired
    private implementSerie impservice;

    @GetMapping("/serie")
    public ResponseEntity<?> mostrarSeries() {
        return ResponseEntity.ok().body(impservice.mostrarSeries());
    }
    

    @PostMapping("/serie")
    public ResponseEntity<?> getserie () {
         LocalTime now = LocalTime.now();
        int hours = now.getHour();
        int minutes = now.getMinute();
        int seconds = now.getSecond();  
        String time = hours + ":" + minutes + ":" + seconds;
        return ResponseEntity.ok().body(impservice.generateSerie(time));
    }
    


}
