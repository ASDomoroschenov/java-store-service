package ru.mai.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.inventoryservice.dto.mapper.InventoryMapper;
import ru.mai.inventoryservice.dto.request.InventoryRequest;
import ru.mai.inventoryservice.dto.response.InventoryResponse;
import ru.mai.inventoryservice.repository.InventoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    /**
     * Запрос на получение всех продуктов на складе
     *
     * @return List<InventoryResponse> - список ответов
     */
    public List<InventoryResponse> retrieveAll() {
        return inventoryRepository.findAll().stream()
                .map(InventoryMapper::modelToResponse)
                .toList();
    }

    /**
     * Запрос на получение списка всех продуктов на складе по их id
     *
     * @param ids - список id
     * @return List<InventoryResponse> - список ответов
     */
    public List<InventoryResponse> retrieveAllByIds(List<Long> ids) {
        return inventoryRepository.findAllById(ids).stream()
                .map(InventoryMapper::modelToResponse)
                .toList();
    }

    /**
     * Сохранение или обновление переданных в теле запроса продуктов склада
     *
     * @param requests - список запросов
     * @return List<InventoryResponse> - список сохраненных/обновленных продуктов
     */
    public List<InventoryResponse> save(List<InventoryRequest> requests) {
        return inventoryRepository.saveAllAndFlush(
                        requests.stream()
                                .map(InventoryMapper::requestToModel)
                                .toList()
                )
                .stream()
                .map(InventoryMapper::modelToResponse)
                .toList();
    }

    /**
     * Удаление всех записей в таблице по переданному списку id
     *
     * @param ids - список id
     */
    public void remove(List<Long> ids) {
        inventoryRepository.deleteAllById(ids);
    }

}
