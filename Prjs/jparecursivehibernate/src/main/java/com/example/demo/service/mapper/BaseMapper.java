package com.example.demo.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;
import java.util.*;

public abstract class BaseMapper {
    protected final ModelMapper modelMapper = new ModelMapper();
    private Type destination;

    /**
     * @param origin       đối tượng chứa data cần transfer
     * @param destination đối tượng cần lấy class để transfer
     * @param <O>         class của đối tượng origin
     * @param <D>         class của dối tượng destination
     * @return đối tượng destination có chứa data của đối tượng origin
     */
    public <O, D> D tranferData(O origin, D destination) {
        if (null==origin) return null;

        return modelMapper.map(origin, (Type) destination.getClass());
    }

    /**
     * @param id          list id của đối tượng cần get
     * @param repo        repository của đối tượng cần get
     * @param destination đối tượng cung cấp class cần transfer data
     * @param <D>         class cần transfer data
     * @param <O>         class được transfer data
     * @param <R>         loại repository
     * @return đối tượng destination
     */
    public <D, O, R extends JpaRepository<O, Long>> D getDataById(Long id, R repo, D destination) {
        if (null == id) return null;

        Optional<O> opt = repo.findById(id);
        if (opt.isPresent()) {
            O origin = opt.get();
            return this.tranferData(origin, destination);
        } else {
            return null;
        }
    }

    public <D, O, R extends JpaRepository<O, Long>> Set<D> getSetDataByIds(List<Long> ids, R repo, D destination) {
        ids = null == ids ? new ArrayList<>() : ids;
        Set<D> set = new HashSet<>();

        for (long id : ids) {
            set.add(this.getDataById(id, repo, destination));
        }

        return set;
    }

    public <O, D> Set<D> tranferDataList(Set<O> orginList, D destination) {
        Set<D> set = new HashSet<>();

        for (O origin : orginList) {
            set.add(this.tranferData(origin, destination));
        }

        return set;
    }
}
