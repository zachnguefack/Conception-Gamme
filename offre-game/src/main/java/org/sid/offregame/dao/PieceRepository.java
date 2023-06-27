package org.sid.offregame.dao;

import org.sid.offregame.entities.Piece;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceRepository extends JpaRepository<Piece,String> {
}
