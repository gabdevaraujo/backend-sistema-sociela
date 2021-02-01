package com.sociela.domain.enums;

public enum Orgaos {
    
    GOVERNO_DA_BAHIA(1, "Governo da Bahia"),
    CAMARA_MUNICIPAL_DE_ARACAJU(2, "Cam. Municipal de Aracaju"),
    CAMARA_MUNICIPAL_DE_ENTRE_RIOS(3, "Cam. Municipal de Entre Rios"),
    CAMARA_MUNICIPAL_DE_SALVADOR(4, "Cam. Municipal de Salvador"),
    CAMARA_MUNICIPAL_DE_SANTO_AMARO(5, "Cam. Municipal de Santo Amaro"),
    MINISTÉRIO_PÚBLICO_DA_BAHIA(6, "Ministério Público da Bahia"),
    PREFEITURA_DE_ARACAJU(7, "Prefeitura de Aracaju"),
    PREFEITURA_DE_CAMAÇARI(8, "Prefeitura de Camaçari"),
    PREFEITURA_DE_CRUZ_DAS_ALMAS(9, "Prefeitura de Cruz das Almas"),
    PREFEITURA_DE_SALVADOR(10, "Prefeitura de Salvador"),
    PREFEITURA_DE_SANTO_AMARO(11, "Prefeitura de Santo Amaro"),
    PREFEITURA_DE_SAO_FRANCISCO_DO_CONDE(12, "Prefeitura de São Francisco do Conde"),
    PREFEITURA_DE_SERRINHA(13, "Prefeitura de Serrinha"),
    GOVERNO_DO_SERGIPE(14, "Prefeitura de Sergipe");
    
    private int cod;
    private String descricao;

    Orgaos(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }
      
}