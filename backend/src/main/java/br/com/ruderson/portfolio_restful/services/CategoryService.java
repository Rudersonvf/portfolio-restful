package br.com.ruderson.portfolio_restful.services;

import br.com.ruderson.portfolio_restful.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findALL();

    CategoryDTO findById(Long id);

    CategoryDTO insert(CategoryDTO dto);

    void deleteById(Long id);
}
