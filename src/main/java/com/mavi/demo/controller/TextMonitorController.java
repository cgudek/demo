package com.mavi.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextMonitorController {

  @GetMapping("/textMonitor")
  public ResponseEntity<String> getText() {

    return new ResponseEntity<String>("Merhaba Mavidev, ben Cuneyt!", HttpStatus.OK);
  }
}
