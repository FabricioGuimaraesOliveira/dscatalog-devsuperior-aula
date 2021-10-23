package com.devsuperior.dscatolog.services;

import com.devsuperior.dscatolog.dto.CategoryDTO;
import com.devsuperior.dscatolog.entities.Category;
import com.devsuperior.dscatolog.repositories.CategoryRepository;
import com.devsuperior.dscatolog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {

        List<Category> list = categoryRepository.findAll();
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findCategoryById(Long id) {

        return categoryRepository.findById(id).map(x -> new CategoryDTO(x)).orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));

    }

    @Transactional
    public CategoryDTO insertCategory(CategoryDTO dto) {

        Category entity = new Category();
        entity.setName(dto.getName());
        entity = categoryRepository.save(entity);

        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        try {
            Category category = categoryRepository.getOne(id);
            category.setName(dto.getName());
            category = categoryRepository.save(category);

            return new CategoryDTO(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }

    }
}