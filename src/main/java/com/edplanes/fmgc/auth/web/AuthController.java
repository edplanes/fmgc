package com.edplanes.fmgc.auth.web;

import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;

@Timed(percentiles = { 0.5, 0.75, 0.95, 0.99 })
@RestController
@AllArgsConstructor
public class AuthController {

}
