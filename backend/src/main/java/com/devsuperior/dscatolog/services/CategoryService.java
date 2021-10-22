package com.devsuperior.dscatolog.services;

import com.devsuperior.dscatolog.entities.Category;
import com.devsuperior.dscatolog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }
}
