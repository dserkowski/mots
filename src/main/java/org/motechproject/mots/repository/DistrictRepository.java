package org.motechproject.mots.repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import org.motechproject.mots.domain.District;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DistrictRepository extends PagingAndSortingRepository<District, UUID>,
    QueryDslPredicateExecutor<District> {

  List<District> findAllByOrderByNameAsc();

  @Query()
  List<District> findAll(Predicate predicate);
}
