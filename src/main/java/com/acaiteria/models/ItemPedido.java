package com.acaiteria.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "tamanho_id")
    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "recipiente_id")
    private Recipiente recipiente;

    @ManyToMany
    @JoinTable(
            name = "item_pedido_acompanhamento",
            joinColumns = @JoinColumn(name = "item_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "acompanhamento_id")
    )
    private List<Acompanhamento> acompanhamentos;

    public ItemPedido() {
        super();
    }
    public ItemPedido(Long id, Pedido pedido, Produto produto, Tamanho tamanho, Recipiente recipiente, List<Acompanhamento> acompanhamentos) {
        super();
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.tamanho = tamanho;
        this.recipiente = recipiente;
        this.acompanhamentos = acompanhamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Recipiente getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public List<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
    }

    public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }
}
