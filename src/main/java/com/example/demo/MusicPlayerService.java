package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"playlist"})
public class MusicPlayerService
{
    private static Logger log = LoggerFactory.getLogger(MusicPlayerService.class);

    @Cacheable(condition = "#instrument.equals('guitar')")
    public void play(String instrument) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
    }

}