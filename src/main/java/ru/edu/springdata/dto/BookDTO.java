package ru.edu.springdata.dto;

import java.util.Set;

public record BookDTO(Long id, String title, String language,
                      Long categoryId, Boolean active, Set<Long> authorsIds) {
}
