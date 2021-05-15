package com.example.qrcode2;

import com.google.gson.annotations.SerializedName;

public class Post {
    private Integer id;



    @SerializedName("idmaquina")
    private String idmaquina;

    @SerializedName("avaria")
    private String avaria;

    @SerializedName("dataabertura")
    private String dataabertura;

    @SerializedName("datafecho")
    private String datafecho;

    @SerializedName("problema")
    private String problema;

    @SerializedName("solicitante")
    private String solicitante;

    @SerializedName("planificador")
    private String planificador;

    public Post(String idmaquina, String avaria, String dataabertura, String datafecho, String problema, String solicitante, String planificador) {
        this.idmaquina = idmaquina;
        this.avaria = avaria;
        this.dataabertura = dataabertura;
        this.datafecho = datafecho;
        this.problema = problema;
        this.solicitante = solicitante;
        this.planificador = planificador;
    }

    public int getId() {
        return id;
    }

    public String getIdmaquina() {
        return idmaquina;
    }

    public String getAvaria() {
        return avaria;
    }

    public String getDataabertura() {
        return dataabertura;
    }

    public String getDatafecho() {
        return datafecho;
    }

    public String getProblema() {
        return problema;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getPlanificador() {
        return planificador;
    }
}
