package com.simplus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplus.domain.Product;

@Repository
@Transactional(readOnly=true)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAll();

    @Query("SELECT obj FROM Product obj WHERE obj.company.id = :companyId ORDER BY obj.lastUpdate")
    public List<Product> findProducts(@Param("companyId") Integer company_id);

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13  AND obj.company.id = :companyId ORDER BY obj.lastUpdate")
    public List<Product> findGtln13(@Param("companyId") Integer company_id);

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 ORDER BY last_update")
    public List<Product> findAllBy13();

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 AND obj.company.id = 1 ORDER BY last_update")
    public List<Product> findAllBy131();

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 AND obj.company.id = :companyId ORDER BY last_update")
    public List<Product> findAllBy131p(@Param("companyId") Integer company_id);

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 AND obj.company.id = :companyId ORDER BY last_update")
    public List<Product> findAllBy132p(@Param("companyId") Integer company_id);

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 AND obj.company.id = 2 ORDER BY last_update")
    public List<Product> findAllBy132();

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=14 ORDER BY last_update")
    public List<Product> findAllBy14();

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=14 AND obj.company.id = 1 ORDER BY last_update")
    public List<Product> findAllBy141();

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=14 AND obj.company.id = 2 ORDER BY last_update")
    public List<Product> findAllBy142();

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 AND obj.company.id = :companyId ORDER BY last_update")
    public List<Product> findAllBy141p(@Param("companyId") Integer company_id);

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=13 AND obj.company.id = :companyId ORDER BY last_update")
    public List<Product> findAllBy142p(@Param("companyId") Integer company_id);

    @Query("SELECT obj FROM Product obj WHERE CHARACTER_LENGTH(obj.gtin)=14  AND obj.company.id = :companyId ORDER BY obj.lastUpdate")
    public List<Product> findGtln14(@Param("companyId") Integer company_id);


}
/*
@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);

 */