package br.edu.ifpb.semiti.cardapio.domain;

import java.io.Serializable;

public interface Identifiable extends Serializable {

    void setId(Long id);
    
    Long getId();

}
