package ru.mai.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.productservice.dto.mapper.ProductMapper;
import ru.mai.productservice.dto.request.ProductRequest;
import ru.mai.productservice.dto.response.ProductResponse;
import ru.mai.productservice.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Запрос на получение всех продуктов
     *
     * @return List<ProductResponse> - список ответов
     */
    public List<ProductResponse> retrieveAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::modelToResponse)
                .toList();
    }

    /**
     * Запрос на получение списка всех продуктов по их id
     *
     * @param ids - список id
     * @return List<ProductResponse> - список ответов
     */
    public List<ProductResponse> retrieveAllByIds(List<Long> ids) {
        return productRepository.findAllById(ids).stream()
                .map(ProductMapper::modelToResponse)
                .toList();
    }

    /**
     * Сохранение или обновление переданных в теле запроса продуктов
     *
     * @param requests - список запросов
     * @return List<ProductResponse> - список сохраненных/обновленных продуктов
     */
    public List<ProductResponse> save(List<ProductRequest> requests) {
        return productRepository.saveAllAndFlush(
                        requests.stream()
                                .map(ProductMapper::requestToModel)
                                .toList()
                )
                .stream()
                .map(ProductMapper::modelToResponse)
                .toList();
    }

    /**
     * Удаление всех записей в таблице по переданному списку id
     *
     * @param ids - список id
     */
    public void remove(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }

}
