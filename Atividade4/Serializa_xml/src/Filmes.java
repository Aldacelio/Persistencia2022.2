import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ListaDeFilmes")

public class Filmes {
    private List<Filme> filmes;

    public Filmes(){}

    public Filmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @JacksonXmlElementWrapper(localName = "filmes")
    @JacksonXmlProperty(localName = "filme")

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return this.filmes.toString();        
    }

}
