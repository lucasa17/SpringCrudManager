package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {}