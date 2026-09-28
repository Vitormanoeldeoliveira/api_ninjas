package br.com.fatec.clas.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name="cla")
@Valid
public class Cla {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id_cla;

    @Column (name = "nome", nullable=false)
    @NotBlank(message = "O nome é obrigatório.")
    @Size (min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Column (name = "descricao", nullable=false, unique=true)
    @NotBlank(message = "A descrição é obrigatória.")
    @Size (min = 5, message = "Descricao deve ter no mínimo 5 caracteres.")
    private String descricao;

    @Column (name = "habilidade", nullable=false, unique=true)
    @NotBlank(message = "A habilidade é obrigatória.")
    @Size (min = 3, max = 50, message = "Habilidade deve ter entre 3 e 50 caracteres.")
    private String habilidade;
}
