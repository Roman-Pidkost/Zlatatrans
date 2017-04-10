package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.zlatatrans.entity.Make;

public interface MakeDao extends JpaRepository<Make, Integer> {
    Make findByName(String name);
    @Query("select m from Make m join fetch m.models md where m.id=:param")
    Make findByIdFetchModel(@Param("param") int id);
    @Query("select m from Make m left join fetch m.models where m.name=:param")
    Make findByNameFetchModel(@Param("param") String name);
}
