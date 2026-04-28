package org.example.bigdata_seoul_back.Repository;

import org.example.bigdata_seoul_back.Domain.SeoulData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeoulDataRepository extends JpaRepository<SeoulData, Long> {

    List<SeoulData> findByCategory(String category);
}
