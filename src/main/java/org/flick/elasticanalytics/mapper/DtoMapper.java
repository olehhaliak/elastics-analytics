package org.flick.elasticanalytics.mapper;

public interface DtoMapper<M, D> {

    M mapToModel(D dto);

//    D mapToDto(M model);

}
