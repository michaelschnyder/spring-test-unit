package com.mgiglione.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.mgiglione.service.MangaNotFoundExcepction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.mgiglione.model.Manga;
import com.mgiglione.service.MangaService;

@RestController
@RequestMapping(value = "/manga")
public class MangaController {

    Logger logger = LoggerFactory.getLogger(MangaController.class);

    @Autowired
    private MangaService mangaService;   

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Manga> searchItemsByTitle(@RequestParam(name = "title") String title) {
        return mangaService.getMangasByTitle(title);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Manga searchItemsByTitle(@PathVariable(name = "id") long id) throws MangaNotFoundExcepction {
        return mangaService.getMangaById(id);
    }

//
//    @RequestMapping(value = "/async/{title}", method = RequestMethod.GET)
//    @Async
//    public CompletableFuture<List<Manga>> searchASync(@PathVariable(name = "title") String title) {
//        return CompletableFuture.completedFuture(mangaService.getMangasByTitle(title));
//    }
}
