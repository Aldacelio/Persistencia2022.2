import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ListaDeFilmes")

public class ArrayFilmes {
    private List<Filmes> filmes;

    public ArrayFilmes(){

    }

    public ArrayFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }

    @JacksonXmlElementWrapper(localName = "Filmes")
    @JacksonXmlProperty(localName = "Filme")

    public List<Filmes> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filmes> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return this.filmes.toString();        
    }

    
}
