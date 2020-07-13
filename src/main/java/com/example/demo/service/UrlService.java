package com.example.demo.service;

import com.example.demo.entity.Url;

import java.util.List;



public interface UrlService {

	public List<Url> findAll();

	public Url findById(int theId);

	public void save(Url theUrl);

	public void deleteById(int theId);

	String generateShortUrl(String s);

	String doRedirect(String s);
	
}
