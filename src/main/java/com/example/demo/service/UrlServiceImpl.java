package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.UrlRepository;
import com.example.demo.entity.Url;
import com.example.demo.toolz.UrlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UrlServiceImpl implements UrlService {

    private UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    @Override
    public List<Url> findAll() {
        return urlRepository.findAll();
    }

    @Override
    public Url findById(int theId) {
        Optional<Url> resultUrl = urlRepository.findById(theId);
        Url url = null;

        if (resultUrl.isPresent()) {
            url = resultUrl.get();
        } else {
            throw new RuntimeException("Url not found! ");
        }

        return url;
    }

    @Override
    public void save(Url theUrl) {
        urlRepository.save(theUrl);
    }

    @Override
    public void deleteById(int theId) {
        urlRepository.deleteById(theId);
    }

    @Override
    public String generateShortUrl(String original) {
        Url url = new Url(original);
        urlRepository.save(url);
        return UrlConverter.encode(url.getId());
    }

    @Override
    public String doRedirect(String link) {
        String originalUrl = null;
        int id = UrlConverter.decode(link);
        Optional<Url> resultUrl = urlRepository.findById(id);
        if (resultUrl.isPresent()) {
            originalUrl = resultUrl.get().getOriginal();
        }

        return originalUrl;
    }
}






