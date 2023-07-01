package com.brydie.ProyectoOdioReactBckend.repository;

import com.brydie.ProyectoOdioReactBckend.entity.Empleao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleaoRepository extends JpaRepository<Empleao,Long> {
}
