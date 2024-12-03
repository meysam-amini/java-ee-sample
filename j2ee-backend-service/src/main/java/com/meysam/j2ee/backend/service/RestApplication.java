package com.meysam.j2ee.backend.service;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api") // Base path for your REST APIs
public class RestApplication extends Application {
}
