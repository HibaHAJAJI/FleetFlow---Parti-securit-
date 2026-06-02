package com.fleetflow.Repository;

import com.fleetflow.Entity.Livraison;
import com.fleetflow.enums.StatutLivraison;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

    Page<Livraison> findByStatut(StatutLivraison statut,Pageable pageable);

    Page<Livraison> findByClientId(Long clientId,Pageable pageable);

    @Query("SELECT l FROM Livraison l WHERE l.dateLivraison BETWEEN :dateDebut AND :dateFin")
    Page<Livraison> findLivraisonsBetweenDates(
            @Param("dateDebut") LocalDate dateDebut,
            @Param("dateFin") LocalDate dateFin,Pageable pageable
    );

    @Query("SELECT l FROM Livraison l WHERE l.adresseDestination LIKE %:ville%")
    Page<Livraison> findByVilleDestination(@Param("ville") String ville, Pageable pageable);
}