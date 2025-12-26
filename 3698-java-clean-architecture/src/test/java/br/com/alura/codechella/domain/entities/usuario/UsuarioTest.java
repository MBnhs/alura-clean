package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.entities.FabricaDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123456789-99", "João",
                LocalDate.parse("1990-01-01"), "email@email.com"));
    }


    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimentoEmail("Emily", "123.456.789-10", LocalDate.parse("2000-10-05"), "emily@gmail.com");
        Assertions.assertEquals("Emily", usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-567", 123, "Apto 136");

        Assertions.assertEquals("Apto 136", usuario.getEndereco().getComplemento());
    }

    @Test
    public void naoDeveCadastrarUsuariosComMenosDe18AnosDeIdade() {
        LocalDate dataNascimento = LocalDate.now().minusYears(17);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-99", "João",
                    dataNascimento, "email@email.com");
        });

        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade.", exception.getMessage());


    }

}
