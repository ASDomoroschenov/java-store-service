package ru.mai.productservice.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import ru.mai.productservice.controller.IProductController;
import ru.mai.productservice.dto.request.ProductRequest;
import ru.mai.productservice.dto.response.ProductResponse;
import ru.mai.productservice.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class ProductController implements IProductController {

    private final ProductService productService;

    @GetMapping("/retrieveAll")
    public List<ProductResponse> retrieveAll() {
        return productService.retrieveAll();
    }


    @GetMapping("/retrieveAllByIds")
    public List<ProductResponse> retrieveAllByIds(@RequestBody List<Long> ids) {
        return productService.retrieveAllByIds(ids);
    }

    @PostMapping("/save")
    public List<ProductResponse> save(@RequestBody List<ProductRequest> requests) {
        return productService.save(requests);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestBody List<Long> ids) {
        productService.remove(ids);
    }

}
