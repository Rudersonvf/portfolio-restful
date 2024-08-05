package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.CategoryDTO;
import br.com.ruderson.portfolio_restful.entities.Category;
import br.com.ruderson.portfolio_restful.mappers.CategoryMapper;
import br.com.ruderson.portfolio_restful.repositories.CategoryRepository;
import br.com.ruderson.portfolio_restful.services.exceptions.DatabaseException;
import br.com.ruderson.portfolio_restful.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findALL() {
        List<Category> result = categoryRepository.findAll();
        return result.stream().map(categoryMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category result = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o id " + id));
        return categoryMapper.toDto(result);
    }

    @Override
    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = categoryMapper.toEntity(dto);
        entity = categoryRepository.save(entity);
        return categoryMapper.toDto(entity);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrada com o id " + id);
        }

        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
