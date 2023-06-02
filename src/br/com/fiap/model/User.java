package br.com.fiap.model;

import br.com.fiap.util.CriptoSenha;

public class User {
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private int idade;
    private String admin;


    public User() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = CriptoSenha.criptografar(senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAdmin() {
        return this.admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }


	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", endereco=" + endereco
				+ ", idade=" + idade + ", admin=" + admin + "]";
	}

    

}
