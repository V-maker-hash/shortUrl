package com.example.demo.rest;

import com.example.demo.dao.GenerateRequest;
import com.example.demo.dao.GenerateResponse;
import com.example.demo.entity.Url;
import com.example.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping
public class UrlRestController {

    final String PREFIX = "/l";

    private UrlService urlService;

    public UrlRestController(UrlService urlService) {
        this.urlService = urlService;
    }


    @PostMapping("/generate")
    GenerateResponse generate(@RequestBody @Valid GenerateRequest request) {
        return new GenerateResponse(
                PREFIX, urlService.generateShortUrl(request.getOriginal())
        );
    }

    @GetMapping("/l/{link}")
    RedirectView redirect(@PathVariable String link) {
        return new RedirectView(urlService.doRedirect(link));
    }


    // expose "/urls" and return list of urls
    @GetMapping("/urls")
    public List<Url> findAll() {
        return urlService.findAll();
    }

    // add mapping for GET /urls/{urlId}

    @GetMapping("/urls/{urlId}")
    public Url getUrl(@PathVariable int urlId) {

        Url theUrl = urlService.findById(urlId);

        if (theUrl == null) {
            throw new RuntimeException("Url id not found - " + urlId);
        }

        return theUrl;
    }

    // add mapping for POST /urls - add new url

    @PostMapping("/urls")
    public Url addUrl(@RequestBody Url theUrl) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theUrl.setId(0);

        urlService.save(theUrl);

        return theUrl;
    }

    // add mapping for PUT /urls - update existing url

    @PutMapping("/urls")
    public Url updateUrl(@RequestBody Url theUrl) {

        urlService.save(theUrl);

        return theUrl;
    }

    // add mapping for DELETE /urls/{urlId} - delete url

    @DeleteMapping("/urls/{urlId}")
    public String deleteUrl(@PathVariable int urlId) {

        Url tempUrl = urlService.findById(urlId);

        // throw exception if null

        if (tempUrl == null) {
            throw new RuntimeException("Url id not found - " + urlId);
        }

        urlService.deleteById(urlId);

        return "Deleted url id - " + urlId;
    }

}










