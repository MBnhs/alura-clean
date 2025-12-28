package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {

    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();

        repositorio.cadastrarUsuario(new Usuario("111.222.333-44", "João",
                LocalDate.parse("2000-09-01"), "joao@email.com"));
        repositorio.cadastrarUsuario(new Usuario("222.222.333-44", "Marina",
                LocalDate.parse("2000-09-01"), "marina@email.com"));
        repositorio.cadastrarUsuario(new Usuario("333.222.333-44", "Felipe",
                LocalDate.parse("2000-09-01"), "felipe@email.com"));
        repositorio.cadastrarUsuario(new Usuario("444.222.333-44", "Adriana",
                LocalDate.parse("2000-09-01"), "adriana@email.com"));

        System.out.println(repositorio.listarTodos());
        repositorio.gravaEmArquivo("usuarios.txt");
    }

}
