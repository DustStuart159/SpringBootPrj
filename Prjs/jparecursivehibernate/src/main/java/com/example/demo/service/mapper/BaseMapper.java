package com.example.demo.service.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public abstract class BaseMapper {
    protected final ModelMapper modelMapper = new ModelMapper();

    public <O, D> D tranferData(O orgin, D destination) {
        return modelMapper.map(orgin, (Type) destination.getClass());

    }
}
