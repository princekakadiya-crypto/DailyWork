package com.tss.controller;

import com.tss.entity.Computer;
import com.tss.entity.Harddisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ComputerController {

    private Computer computer;
    private Harddisk harddisk;

    @Autowired
    public ComputerController(Computer computer, Harddisk harddisk) {
        this.computer = computer;
        this.harddisk = harddisk;
    }

    @GetMapping("/computer")
    public Computer getComputer(){
        return computer;
    }

    @GetMapping("/harddisk")
    public Harddisk getHarddisk(){
        return harddisk;
    }
}
