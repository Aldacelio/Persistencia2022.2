/*1. Defina uma entidade principal com pelo menos 5 atributos e relacionada a um domínio de problema. 
Crie também uma classe Java para representá-la. Exemplo de entidade com 9 atributos: Cliente: id, nome, 
cpf, endereço, email, fone, cidade, uf, cep. A entidade deve estar relacionada a algo que você gosta 
bastante como: hobie, esporte, pet, alimentação, educação, música, filmes, séries, redes sociais, etc. 
A entidade escolhida por você não pode ser a entidade Cliente dada como exemplo. Escolha uma entidade 
bem diferente dela, inclusive quanto aos seus atributos.
 */


public class Filmes {
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private String diretor;

    public Filmes(){

    }

    public Filmes(int id, String titulo, String sinopse, String genero, String diretor) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.diretor = diretor;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "ListaDeFilmes{" +
        "Filme='" + id + '\'' +
        ", titulo='" + titulo + '\'' +
        ", sinopse='" + sinopse + '\'' +
        ", genero='" + genero + '\'' +
        ", diretor='" + diretor + '\'' +
        '}';
    }
}
